package com.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SqlSessionUtil {
	public static SqlSession getSqlSession() throws Exception {
		final Properties prop = new Properties();
		Logger logger = LogManager.getLogger(SqlSessionUtil.class.getName());

		String db_host = System.getenv("DB_HOST");
		String user = System.getenv("DB_USER");
		String db_port = System.getenv("DB_PORT");
		String pass = System.getenv("DB_PASSWORD");
		logger.error("DB_HOST from environment is :" + db_host);
		logger.error("DB_USER from environment is :" + user);
		logger.error("DB_PORT from environment is :" + db_port);
		logger.error("DB_PASSWORD from environment is :" + pass);
		if (db_host != null) {
			if (db_port == null) {
				db_port = "3306";
			}
			String db_url = "jdbc:mysql://" + db_host + ":" + db_port + "/bookstore";
			prop.setProperty("db_url", db_url);
		}
		if (user != null) {
			prop.setProperty("username", user);
		}
		if (pass != null) {
			prop.setProperty("password", pass);
		}

		String resource = "MapConfig.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = Resources.getResourceAsStream(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build((is), prop);

		// 创建能执行映射文件中sql的sqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		return sqlSession;
	}
}
