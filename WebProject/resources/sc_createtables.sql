/* 회원관리 테이블 */
CREATE TABLE sc_member (
  m_email      VARCHAR2(30)    PRIMARY KEY,
  m_pwd        VARCHAR2(15)    NOT NULL,
  m_nickname   VARCHAR2(30)    NOT NULL,
  m_regdate    DATE            DEFAULT SYSDATE
);
/* 게시판목록 테이블 */
CREATE TABLE sc_bbs (
    bbs_id		    NUMBER(8)		    primary key,
    bbs_name	    VARCHAR2(100)	 	not null,
    bbs_category    VARCHAR2(100)	 	not null
);
/* 게시글목록 테이블 */
CREATE TABLE sc_bbs_post (  
    bbs_id      NUMBER(8)           not null,  
    b_id		NUMBER(8)		    not null,
    b_nickname	VARCHAR2(30)	 	not null,
    b_email     VARCHAR2(30),
    b_pwd       VARCHAR2(15),
    b_title		VARCHAR2(300)		not null,
    b_contents  CLOB                not null,
    b_date		DATE			    default Sysdate,
    b_hit		NUMBER(20)          default 0,
    PRIMARY KEY (b_id, bbs_id),
    foreign key(bbs_id) references sc_bbs(bbs_id)
        ON DELETE CASCADE
);
/* 게시글추천자목록 테이블 */
CREATE TABLE sc_bbs_post_good (
    bbs_id          NUMBER(8)       not null,
    b_id		    NUMBER(8)		not null,
    g_id            NUMBER(8)       not null,
    g_email         VARCHAR2(30),
    PRIMARY KEY (g_id, b_id, bbs_id),
    foreign key(b_id, bbs_id) references sc_bbs_post(b_id, bbs_id)
        ON DELETE CASCADE        
);
/* 게시글별댓글목록 테이블 */
CREATE TABLE sc_bbs_post_comments(
    bbs_id      NUMBER(8)           not null,
    b_id		NUMBER(8)		    not null,
    c_id        NUMBER(8)           not null,  
    c_comments	VARCHAR2(500)       not null,
    c_nickname  VARCHAR2(30)        default '��ȸ��',
    c_email     VARCHAR2(30),
    c_pwd       VARCHAR2(15),
    c_date		DATE			    default Sysdate,
    PRIMARY KEY (c_id, b_id, bbs_id),
    foreign key(b_id, bbs_id) references sc_bbs_post(b_id, bbs_id)
        ON DELETE CASCADE
);
/* 게시글속 이미지목록 테이블 */
CREATE TABLE sc_bbs_post_image (
    bbs_id          NUMBER(8)       not null,
    b_id		    NUMBER(8)		not null,
    i_id            NUMBER(8)       not null,
    i_path          VARCHAR2(100)   not null,
    i_line          NUMBER(8)       not null,
    PRIMARY KEY (i_id, b_id, bbs_id),
    foreign key(b_id, bbs_id) references sc_bbs_post(b_id, bbs_id)
        ON DELETE CASCADE        
);
/* 추천 수 보여주는 뷰 */
CREATE VIEW goodCount_view
(bbs_id, b_id, g_count)
AS
	SELECT p.bbs_id, p.b_id, count(g.g_id) 
	FROM    
        sc_bbs_post p
    left outer join 
        sc_bbs_post_good g
    on p.bbs_id = g.bbs_id and p.b_id = g.b_id 
    group by p.bbs_id, p.b_id
    order by p.bbs_id, p.b_id;
    
/* 코멘트 수 보여주는 뷰 */
CREATE VIEW commentCount_view
(bbs_id, b_id, c_count)
AS
	SELECT p.bbs_id, p.b_id, count(c.c_id) 
	FROM    
        sc_bbs_post p
    left outer join 
        sc_bbs_post_comments c
    on p.bbs_id = c.bbs_id and p.b_id = c.b_id 
    group by p.bbs_id, p.b_id
    order by p.bbs_id, p.b_id; 
    
/* 게시글 내용/목록 종합정보 뷰 */
CREATE VIEW post_view
(bbs_id, b_id, b_nickname, b_email, b_pwd, b_title, b_contents, b_date, b_hit, g_count, c_count)
AS
	SELECT p.bbs_id, p.b_id, p.b_nickname, p.b_email, p.b_pwd, p.b_title, p.b_contents, p.b_date, p.b_hit, g.g_count, c.c_count
    FROM    
        sc_bbs_post p, goodCount_view g, commentCount_view c
    WHERE p.bbs_id = g.bbs_id AND p.b_id = g.b_id
        AND p.bbs_id = c.bbs_id AND p.b_id = c.b_id
    ORDER BY p.bbs_id, p.b_id;    
--drop view post_view;

-- 히트게시판 - 조회수 상위 뷰
CREATE VIEW hit_click_view
(bbs_id, b_id, b_nickname, b_email, b_pwd, b_title, b_contents, b_date, b_hit, g_count, c_count)
AS
	SELECT p.bbs_id, p.b_id, p.b_nickname, p.b_email, p.b_pwd, p.b_title, p.b_contents, p.b_date, p.b_hit, g.g_count, c.c_count
    FROM    
        sc_bbs_post p, goodCount_view g, commentCount_view c
    WHERE p.bbs_id = g.bbs_id AND p.b_id = g.b_id
        AND p.bbs_id = c.bbs_id AND p.b_id = c.b_id
        AND p.b_hit >= 3
    ORDER BY b_date;
--drop view hit_click_view;
    
-- 히트게시판 - 추천수 상위 뷰
CREATE VIEW hit_good_view
(bbs_id, b_id, b_nickname, b_email, b_pwd, b_title, b_contents, b_date, b_hit, g_count, c_count)
AS
	SELECT p.bbs_id, p.b_id, p.b_nickname, p.b_email, p.b_pwd, p.b_title, p.b_contents, p.b_date, p.b_hit, g.g_count, c.c_count
    FROM    
        sc_bbs_post p, goodCount_view g, commentCount_view c
    WHERE p.bbs_id = g.bbs_id AND p.b_id = g.b_id
        AND p.bbs_id = c.bbs_id AND p.b_id = c.b_id
        AND g.g_count >= 3
    ORDER BY b_date;
--drop view hit_good_view;

-- 히트게시판 - 댓글수 상위 뷰
CREATE VIEW hit_comment_view
(bbs_id, b_id, b_nickname, b_email, b_pwd, b_title, b_contents, b_date, b_hit, g_count, c_count)
AS
	SELECT p.bbs_id, p.b_id, p.b_nickname, p.b_email, p.b_pwd, p.b_title, p.b_contents, p.b_date, p.b_hit, g.g_count, c.c_count
    FROM    
        sc_bbs_post p, goodCount_view g, commentCount_view c
    WHERE p.bbs_id = g.bbs_id AND p.b_id = g.b_id
        AND p.bbs_id = c.bbs_id AND p.b_id = c.b_id
        AND c.c_count >= 3
    ORDER BY b_date;  
--drop view hit_comment_view;

commit;