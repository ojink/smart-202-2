package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HrFactory	 {
	private static SqlSessionFactory factory;
	public static SqlSessionFactory getInstance() {
		if( factory==null ) {
			InputStream stream;
			try {
				stream = Resources.getResourceAsStream("mybatis/hr_config.xml");
				factory = new SqlSessionFactoryBuilder().build(stream);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return factory;
	}
	
}
