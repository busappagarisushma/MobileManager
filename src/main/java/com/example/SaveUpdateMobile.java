package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUpdateMobile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));

		//JDBC LOGIC
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/servlet_mobiledb?user=root&password=root");

			PreparedStatement pst = conn.prepareStatement
					("UPDATE mobile SET mobileModel=?,mobileBrand=?,mobilePrice=? WHERE mobileId=?");

			pst.setString(1, mobileModel);
			pst.setString(2, mobileBrand);
			pst.setInt(3, mobilePrice);
			pst.setInt(4, mobileId);

			pst.execute();

			resp.sendRedirect("Dispaly-All-Mobiles");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
