package core.jda.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import core.jda.servlets.model.Model;

public class DataBaseUtil {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
			      .getConnection("jdbc:mysql://10.0.0.160/db100017?user=u100017&password=LBKwhBnT6K");

			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Connection is not returned");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static boolean registerUser(Model model) {
		Connection con = getConnection();
		try {
			String sql = "INSERT INTO user (firstname,lastname,username,email,gender,password)  VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, model.getFirstName());
			ps.setString(2, model.getLastName());
			ps.setString(3, model.getUserName());
			ps.setString(4, model.getEmail());
			ps.setString(5, model.getGender());
			ps.setString(6, model.getPassword());

			int id = ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static Model getUser(String userName, String password) {

		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM user where username = ?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == true) {
				Model model = new Model();
				model.setFirstName(rs.getString("firstname"));
				model.setLastName(rs.getString("lastname"));
				model.setUserName(rs.getString("username"));
				model.setEmail(rs.getString("email"));
				model.setGender(rs.getString("gender"));
				model.setPassword(rs.getString("password"));
				return model;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
