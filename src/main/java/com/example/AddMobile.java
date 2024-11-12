package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-mobile")
public class AddMobile extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));

		Connection conn = null;
		//JDBC Logic
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/servlet_mobiledb?user=root&password=root");

			PreparedStatement pst = conn.prepareStatement("INSERT INTO mobile (mobileModel, mobileBrand, mobilePrice) VALUES (?, ?, ?)");
			//			pst.setInt(1, mobileId);
			pst.setString(1, mobileModel);
			pst.setString(2, mobileBrand);
			pst.setInt(3, mobilePrice);

			pst.execute();

			resp.sendRedirect("index.jsp");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
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
