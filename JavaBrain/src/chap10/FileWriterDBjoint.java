package chap10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.kosea.kmove30.Member;
import com.kosea.kmove30.MybatisQuery;

public class FileWriterDBjoint {

	public static void main(String[] args) {
		File file1 = new File("DBmember.txt");

		try {
			file1.createNewFile();
		} catch (IOException ioe) {
			System.out.println("파일을 불러올 수 없습니다.");
		}

		MybatisQuery query = new MybatisQuery("mybatis-config.xml");

		List<Member> list = query.selectAll();

		// System.out.println(list.get(0).getId());

		PrintWriter writer = null;

		try {
			writer = new PrintWriter("DBmember.txt");
			for (int cnt = 0; cnt < list.size(); cnt++)
				writer.printf("###%s###%s###%d\n", list.get(cnt).getId(), list.get(cnt).getPassword(),
						list.get(cnt).getmNo());
		} catch (IOException ioe) {
			System.out.println("파일을 불러올 수 없습니다.");
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
