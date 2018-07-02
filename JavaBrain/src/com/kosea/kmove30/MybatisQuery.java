package com.kosea.kmove30;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MybatisQuery {
	
	private SqlSessionFactory sqlSessionFactory = null; 
	
	public MybatisQuery(SqlSessionFactory sqlSessionFactory) { 
		this.sqlSessionFactory = sqlSessionFactory; 
	}
	
	
	// Insert Query
	public int insertMember(Member member) { 
		int count = -1; 
		SqlSession session = sqlSessionFactory.openSession(); 
		
		try { 
			count = session.insert("member.insertMember", member); 
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
			list = session.selectList("member.selectAll");
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
			member = session.selectOne("member.selectMember", mNo); 
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
			member = session.selectOne("member.selectID", member); 
		} finally { 
			session.close(); 
		} 
		
		return member; 
	}
	
	
	
	public void update(Member member) { 
		int count = -1; 
		SqlSession session = sqlSessionFactory.openSession(); 
		
		try { 
			count = session.update("member.updateMember", member); 
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
			count = session.delete("member.deleteID", member); 
			System.out.println(count + "건 삭제했습니다.");
		} finally { 
			session.commit(); 
			session.close(); 
		} 
		
	}



	




	

	

}
