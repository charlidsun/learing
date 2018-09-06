package com.sun.magic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilss {
	// 定义数据库四大基本信息
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/learning?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=false";
	private static String username = "root";
	private static String password = "123456";
	private static Connection conn;

	// 定义一个静态块,在调用JDBCUtils类是初始化,获取数据库链接
	static {
		try {
			/*
			 * java.sql.DriverManager是用来管理数据库驱动程序的 static void registerDriver(Driver driver)
			 * 向 DriverManager 注册给定驱动程序。
			 * 工具源码里面有一个static驱动,当调用driver类时已经调用了,所以这里不需要再次调用,我们可以使用反射技术
			 * DriverManager.registerDriver(new Driver());
			 */
			Class.forName(driver);
			// 获取数据库链接对象
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// 把编译异常转变为运行时异常
			throw new RuntimeException("数据库链接失败");
		}
	}

	// 返回数据库链接对象
	public static Connection getConnection() {
		return conn;
	}

	// 静态关闭流对象
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
