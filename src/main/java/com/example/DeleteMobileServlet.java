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

public class DeleteMobileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));

		//JDBC LOGIC
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/servlet_mobiledb?user=root&password=root");

			PreparedStatement pst = conn.prepareStatement
					("DELETE FROM mobile WHERE mobileId=?");

			pst.setInt(1, mobileId);

			pst.execute();

			resp.sendRedirect("Dispaly-All-Mobiles");

		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
		}
	}
}
