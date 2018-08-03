package com.kosea.kmove30;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisQuery {
	
	String resource;
	private SqlSessionFactory sqlSessionFactory = null; 	
	
	public MybatisQuery(String resource) {
		super();
		this.resource = resource;
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	// Insert Query
	public int insertMember(Member member) { 
		int count = -1; 
		SqlSession session = sqlSessionFactory.openSession(); 
		
		try { 
			count = session.insert("memberMapper.insertMember", member); 
		} finally { 
				session.commit(); 
				session.close(); 
		} 
		
		return count; 
	}
	
	
	// Select All
	public List<Member> selectAll() {
		List<Member> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			list = session.selectList("memberMapper.selectAll");
		} finally {
			session.close();
		}
		//System.out.println(list);
		return list;
	}
	
	
	
	public Member selectOne(int mNo) { 
		Member member = null; 
		SqlSession session = sqlSessionFactory.openSession(); 
		
		try { 
			member = session.selectOne("memberMapper.selectMember", mNo); 
		} finally { 
			session.close(); 
		} 
		
		return member; 
	}
	
	public Member selectOne(String id) { 
		Member member = new Member(); 
		member.setId(id);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		
		try { 
			member = session.selectOne("memberMapper.selectID", member); 
		} finally { 
			session.close(); 
		} 
		
		return member; 
	}
	
	
	
	public void update(Member member) { 
		int count = -1; 
		SqlSession session = sqlSessionFactory.openSession(); 
		
		try { 
			count = session.update("memberMapper.updateMember", member); 
			System.out.println(count + "건 수정했습니다.");
		} finally { 
			session.commit(); 
			session.close(); 
		} 
		
	}
	
	public void delete(String id) { 
		int count = -1; 
		Member member = new Member(); 
		member.setId(id);
		SqlSession session = sqlSessionFactory.openSession(); 		
		
		try { 
			count = session.delete("memberMapper.deleteID", member); 
			System.out.println(count + "건 삭제했습니다.");
		} finally { 
			session.commit(); 
			session.close(); 
		} 
		
	}
	
	public void deleteAll() { 
		int count = -1; 
		SqlSession session = sqlSessionFactory.openSession(); 		
		
		try { 
			count = session.delete("memberMapper.deleteAll"); 
			System.out.println(count + "건 삭제했습니다.");
		} finally { 
			session.commit(); 
			session.close(); 
		} 
		
	}



	




	

	

}
