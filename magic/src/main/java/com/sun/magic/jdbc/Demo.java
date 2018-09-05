package com.sun.magic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class Demo {
	public static void main(String[] args) {
		//定义局部变量
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//获取数据库链接对象
			connection = JdbcUtilss.getConnection();
			//获取数据执行方法
			statement = connection.createStatement();
			String sql = "select * from stu";
			//请求数据sql返回结果集
			resultSet = statement.executeQuery(sql);
			//next是否有下一个
			while(resultSet.next()){
				System.out.println(resultSet.getString("name")+"\t"+resultSet.getString("gender"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			//关闭流对象
			JdbcUtilss.close(resultSet, statement, connection);
		}
	}
}
