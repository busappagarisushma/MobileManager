package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update-mobile")
public class UpdateMobile extends HttpServlet{

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
					("SELECT * FROM mobile WHERE mobileId=?");
			pst.setInt(1, mobileId);

			ResultSet rs = pst.executeQuery();

			req.setAttribute("resultSet", rs);
			RequestDispatcher rd = req.getRequestDispatcher("UpdateMobile.jsp");
			rd.forward(req, resp);

		} catch (ClassNotFoundException | SQLException e) {
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
