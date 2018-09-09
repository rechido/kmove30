insert into 
    sc_member(m_email,m_pwd,m_nickname)
values
    ('admin@admin.admin','12345','관리자');
    
insert into
    sc_bbs
values
    ('10001','조회수 상위','히트게시판');
    
insert into
    sc_bbs
values
    ('10002','추천수 상위','히트게시판');
    
insert into
    sc_bbs
values
    ('10003','댓글수 상위','히트게시판');
    
commit;