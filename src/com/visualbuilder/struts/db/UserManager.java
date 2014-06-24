
package com.visualbuilder.struts.db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.visualbuilder.struts.ResourceManager;
import com.visualbuilder.struts.beans.User;

/**
 * @author VisualBuilder
 * This is a singleton class
 */
public class UserManager {
	private static UserManager mgr = null;
	private Connection con = null;
	
	private UserManager()
	{
		String driverClass = ResourceManager.getString("database.driver");
		String dbUrl = ResourceManager.getString("database.url");
		String dbUser = ResourceManager.getString("database.user");
		String dbPassword = ResourceManager.getString("database.password");
		try{
			Class.forName(driverClass);
			con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}catch(Exception exp){
			System.err.println("Could not connect to dtabase.\n"+exp.getMessage());
		}
	}
	public void saveUser(User user) throws SQLException
	{
		if(user == null)
			throw new SQLException(ResourceManager.getString("save.user.null"));
		Connection connection = getConnection();
		
		PreparedStatement pstmt = connection.prepareStatement("insert into users(user_id,first_name,last_name,age,email) values(?,?,?,?,?)");
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getFirstName());
		pstmt.setString(3, user.getLastName());
		pstmt.setInt(4, user.getAge());
		pstmt.setString(5, user.getEmail());
		
		pstmt.executeUpdate();
		
		pstmt.close();
	}	
	public User getUser(String userId) throws SQLException
	{
		if(userId == null || userId.length() == 0)
			throw new SQLException(ResourceManager.getString("retrieve.user.null"));
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where user_id='"+userId+"'");
		User user = null;
		if(rs.next())
		{			
			user = new User(userId);
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setAge(rs.getInt("age"));
			user.setEmail(rs.getString("email"));
		}
		rs.close();
		stmt.close();
		return user;
	}
	public List list() throws SQLException
	{
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		User user = null;
		List list = new ArrayList();
		while(rs.next())
		{			
			user = new User(rs.getString("user_id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setAge(rs.getInt("age"));
			user.setEmail(rs.getString("email"));
			list.add(user);
		}
		rs.close();
		stmt.close();
		return list;
	}
	private Connection getConnection() throws SQLException
	{
		if(con == null)
			throw new SQLException(ResourceManager.getString("database.notConnected"));
		return con;
	}
	public static UserManager getInstance()
	{
		if(mgr == null)
		{
			mgr = new UserManager();
		}
		return mgr;
	}
	public void finalize()
	{
		try{
			con.close();			
		}catch(Exception exp){}
	}
}
