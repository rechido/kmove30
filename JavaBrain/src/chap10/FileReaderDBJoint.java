package chap10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import com.kosea.kmove30.Member;
import com.kosea.kmove30.MybatisQuery;

public class FileReaderDBJoint {

	public static void main(String[] args) {
		
		MybatisQuery query = new MybatisQuery("mybatis-config.xml");
		//query.deleteAll();
		
		BufferedReader reader = null;
		StringBuffer strb = new StringBuffer();
		String id, password; int mNo;
		int cnt = 0;

		try {
			reader = new BufferedReader(new FileReader("DBmember.txt"));

			while (true) {
				String str = reader.readLine();

				if (str == null)
					break;
				strb.append(str);

				cnt++;

			}
			// System.out.println(strb.toString());
			

			StringTokenizer stok = new StringTokenizer(strb.toString(), "###");
			while (stok.hasMoreTokens()) {
				id = stok.nextToken();
				password= stok.nextToken();
				mNo= Integer.parseInt(stok.nextToken());
				//System.out.println(id + " " + pass + " " +  mno);
				Member member = new Member(mNo, id, password);
				query.insertMember(member);
			}
			
			
			
				

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
