/**
 * 2018. 6. 5. Dev. by D. A. Lee
 */
package com.kosea.kmove30;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {
	public static void main(String[] args) {
		
		String resource = "mybatis-config.xml"; // src 경로
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// select query 문
			 // Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
				Member member = session.selectOne("memberMapper.selectMember", 101);
//				//Member member = session.selectOne("org.mybatis.example.SelectMapper.selectID", "rechido");
//				System.out.println("회원 아이디: " + member.getId());
//				System.out.println("회원 비번: " + member.getPassword());
				
				member.printlog("\n아이디: " + member.getId() +
								"\n패스워드: " + member.getPassword() +
								"\nmNo: " + member.getmNo());
				
				
				
//				Member member = new Member();
//				member.setId("abcde");
//				member = session.selectOne("org.mybatis.example.SelectMapper.selectID", member);
//				System.out.println("회원 아이디: " + member.getId());
//				System.out.println("회원 비번: " + member.getPassword());
				// select query 문 끝
				
				
				
				// select All 문
//				List<Member> member = session.selectList("org.mybatis.example.SelectMapper.selectAll");
//				for(int i=0; i<5; i++) 
//					System.out.println(member.get(i).getId() + " " + member.get(i).getPassword());
				// select All 문 끝
				
				
				
				// delete query 문				
//				int deleteCount = session.delete("org.mybatis.example.SelectMapper.deleteMember", 101);
//				System.out.println(deleteCount + "건을 삭제했습니다.");
				// delete query 문 끝		
				
				
				// insert 문
//				Member newMember = new Member(101, "이다은", "1111");
//				int insertCount = session.insert("org.mybatis.example.SelectMapper.insertMember", newMember);
//				System.out.println(insertCount + "건을 삽입했습니다.");
				
//				int insertCount = 0;
//				for(int i=0; i<100; i++) {
//					String str = String.valueOf(i);
//					//System.out.println(str);
//					Member newMember = new Member(i, str, "1111");					
//					insertCount	+= session.insert("org.mybatis.example.SelectMapper.insertMember", newMember);
//				}
//				System.out.println(insertCount + "건을 삽입했습니다.");
				// insert 문 끝
				
				
				// update 문
//				Member updateMember = new Member(102, "이다은", "3333");	
//				int updateCount = session.update("org.mybatis.example.SelectMapper.updateMember", updateMember);
//				System.out.println(updateCount + "건을 수정했습니다.");
				// update 문 끝
				
				
				
				
				
				
				//////// MybatisQuery 클래스의 쿼리 실행 메소드를 이용 ////////
				MybatisQuery query = new MybatisQuery(sqlSessionFactory);
				
				
				// Insert 문
//				Member updateMember = new Member(101, "이다은", "1111");				
//				int insertCount = query.insertMember(updateMember);
//				System.out.println(insertCount + "건 삽입되었습니다.");
				
				// Select All
//				List<Member> member = query.selectAll();
//				for(int i=0; i<member.size(); i++) 
//					System.out.println(member.get(i).getId() + " " + member.get(i).getPassword());
				
				// SelectOne
				//Member member = query.selectOne(101);
//				Member member = query.selectOne("이다은");
//				System.out.println(member.getId() + " " + member.getPassword());
				
				// update
//				Member updateMember = new Member(101, "이다은", "2222");
//				int updateCount = query.update(updateMember);
//				System.out.println(updateCount);
				
				// delete
				//query.delete("이다윗");
				//query.selectAll();
				
				
				
				
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				//session.commit();
				//session.close();
			} 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
