package org.fasttrackit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.fasttrackit.helper.DBHelper;

/**
 * Servlet implementation class DownloadImage
 */
@WebServlet("/DownloadImage")
public class DownloadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req,ServletResponse resp) throws ServletException, IOException {
	byte[] img = null;
	ServletOutputStream sos = null;
		String query ="SELECT photo1 FROM microgame33202510.sales where id=17";
		 
		 try {
			 DBHelper helper = new DBHelper();
				Connection con= helper.getConnectionSocietate();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
			img = rs.getBytes(1);	
			}
			sos = resp.getOutputStream();
			sos.write(img);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
