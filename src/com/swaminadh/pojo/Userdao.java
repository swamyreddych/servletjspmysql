package com.swaminadh.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.swaminadh.model.User;
import com.swaminadh.util.Dbutil;

public class Userdao {
     private Connection connection;
	public Userdao( )
	{	 connection = Dbutil.getConnection();
	}
	public void addUser(User user){
		try {
			PreparedStatement ps = connection.prepareStatement("insert into users(fname,lname,dob,email)values(?,?,?,?)");
			ps.setNString(1, user.getFname());
			ps.setString(2,user.getLname() );
			ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
			ps.setString(4, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void deleteuser(User user){
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("delete from users where userid =? ");
			ps.setInt(1, user.getUserid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public void updateUser(User user) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?" +
	                            "where userid=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getFname());
	            preparedStatement.setString(2, user.getFname());
	            preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
	            preparedStatement.setString(4, user.getEmail());
	            preparedStatement.setInt(5, user.getUserid());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	public List<User> getAllusers(){
		List<User> users = new ArrayList<User>();
		try {
			Statement ps = connection.createStatement();
			ResultSet rs =ps.executeQuery("select * from users");
			while (rs.next()){
				User user =new User();
				user.setUserid(rs.getInt("userid"));
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getNString("lanme"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
	
	public User getUserbyid(User user){
		
		try{
		PreparedStatement ps = connection.prepareStatement("select * from users whrere userid =?" );
		ps.setInt(1, user.getUserid());
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
        user.setFname(rs.getString("fname"));
		user.setLname(rs.getNString("lanme"));
		user.setDob(rs.getDate("dob"));
		user.setEmail(rs.getString("email"));
        }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
