package org.fasttrackit.controller;

import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.InputStream; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet 
	.ServletConfig; 
import javax.servlet 
	.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet 
	.annotation.MultipartConfig; 
import javax.servlet 
	.annotation.WebServlet; 
import javax.servlet 
	.http.HttpServlet; 
import javax.servlet 
	.http.HttpServletRequest; 
import javax.servlet 
	.http.HttpServletResponse; 
import javax.servlet.http.Part;
import org.fasttrackit.dao.SaleDAO;
import org.fasttrackit.helper.DBHelper;
import org.fasttrackit.pojo.Annoncement;



//import Dao.UploadFileDao; 
//import connection.copy.MyConnection; 

// This is the annotation-based 
// mapping URL to Servlet. 
@WebServlet("/Sales") 

// This annotation defines the maximum 
// file size which can be taken. 
@MultipartConfig(maxFileSize = 16177215) 

public class Sales extends HttpServlet { 

	// auto generated 
	private static final long serialVersionUID = 1L; 

	public Sales() 
	{ 
		super(); 
	} 

		//verificare string 
		public static boolean isNotNullNotEmptyNotWhiteSpace( String string)
		{
			boolean stringOk =false;
			if((string!=null)&&(!string.isBlank())&&(!string.trim().isEmpty()))
			{
				stringOk=true;
			}
		   return stringOk;
		}
		
	// As Submit button is hit from 
	// the Web Page, request is made 
	// to this Servlet and 
	// doPost method is invoked. 
	protected void doPost( 
		HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		boolean isLogin=false;
		String myUser = LoginController.getMyUserName();
		isLogin=isNotNullNotEmptyNotWhiteSpace( myUser);
		System.out.println("My User  "+myUser);
		if(isLogin==true) {
		LocalDateTime myDateObj = LocalDateTime.now();
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		 String formattedDate = myDateObj.format(myFormatObj);
		SaleDAO udao =new SaleDAO();
		 Annoncement anunt= new Annoncement();
		// Getting the parametes from web page 
		 String titluAnunt 
			= request.getParameter("titluAnunt");
		String textAnunt 
			= request.getParameter("textAnunt"); 

		String pretAnunt 
			= request.getParameter("pretAnunt"); 
		// Obtains the upload file 
				// part in this multipart request
		Part filePart1 
		= request.getPart("photo1");
		Part filePart2 
		= request.getPart("photo2");
		Part filePart3 
		= request.getPart("photo3");
		Part filePart4 
		= request.getPart("photo4");
		Part filePart5 
		= request.getPart("photo5");
		
		// Input stream of the upload file 
		InputStream inputStream1 = null; 
		InputStream inputStream2 = null; 
		InputStream inputStream3 = null; 
		InputStream inputStream4 = null; 
		InputStream inputStream5 = null; 
		String message = null; 

		if (filePart1 != null) { 
			anunt.setUserName(myUser);
			anunt.setTitluAnunt(titluAnunt);
anunt.setDataAnunt(formattedDate);
anunt.setTextAnunt(textAnunt);
anunt.setPretAnunt(pretAnunt);

			// Prints out some information 
			// for debugging 

System.out.println("Price "+pretAnunt);
			System.out.println( 
				filePart1.getName()); 
			System.out.println( 
				filePart1.getSize()); 
			System.out.println( 
				filePart1.getContentType()); 

			// Obtains input stream of the upload file 
			inputStream1 
				= filePart1.getInputStream(); 
			inputStream2 
			= filePart2.getInputStream(); 
			inputStream3 
			= filePart3.getInputStream(); 
			inputStream4 
			= filePart4.getInputStream(); 
			inputStream5
			= filePart5.getInputStream(); 
			anunt.setPhoto1(inputStream1);
			anunt.setPhoto2(inputStream2);
			anunt.setPhoto3(inputStream3);
			anunt.setPhoto4(inputStream4);
			anunt.setPhoto5(inputStream5);
			anunt.setStatute("FORBIDDEN");
			
		} 

		// Sends the statement to the 
				// database server 
				int row=0;
				try {
					row = udao.insertAnunt(anunt);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				if (row > 0) { 
					message 
						= "File uploaded and "
						+ "saved into database"; 
				} 
				System.out.println(message); 
	}
	}
	
} 


