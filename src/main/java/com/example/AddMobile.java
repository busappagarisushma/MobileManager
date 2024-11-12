package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMobile extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));

	}
}
