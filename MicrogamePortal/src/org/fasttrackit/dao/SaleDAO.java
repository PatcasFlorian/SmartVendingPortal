package org.fasttrackit.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import org.fasttrackit.helper.DBHelper;
import org.fasttrackit.pojo.Annoncement;
import org.fasttrackit.pojo.User;

public class SaleDAO {
	
	
	//Create table
	public void createTableSales() throws SQLException {
			
		    
			DBHelper helper = new DBHelper();
			Connection con = helper.getConnectionSocietate();
			String insertUser = "CREATE TABLE IF NOT EXISTS sales"+ 
					" (id INTEGER not NULL auto_increment primary key,user_name VARCHAR(50) NOT NULL,titlu_anunt VARCHAR(200) NULL,data_anunt VARCHAR(30) NULL,"
					+ "text_anunt VARCHAR(500) NULL,pret_anunt VARCHAR(30) NULL,photo1 MEDIUMBLOB NULL,photo2 MEDIUMBLOB NULL,"
					+ "photo3 MEDIUMBLOB NULL,photo4 MEDIUMBLOB NULL,"
					+ "photo5 MEDIUMBLOB NULL,statute VARCHAR(30) NULL)";
					
		      Statement stmt = con.createStatement();
		      
		       stmt.execute(insertUser);
		       helper.closeConnection(con);
		       
		}
	
	
	// get all annuncemnt by userName
	public ArrayList<Annoncement> getAllAnuncementUser(String user_name) throws SQLException{
		Annoncement anunt =null;
		ArrayList<Annoncement> listAnunt = new ArrayList<Annoncement>();
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionSocietate();
		String getUser = "SELECT*FROM sales where user_name ='"+user_name+"'";
	      Statement stmt = con.createStatement();
	      ResultSet rst = stmt.executeQuery(getUser);
	      while(rst.next()) {
	    	     int id = rst.getInt("id");
	    	     String userName = rst.getString("user_name");
	    	     String titluAnunt = rst.getString("titlu_anunt");
	    		 String dataAnunt = rst.getString("data_anunt");
	    		 String textAnunt = rst.getString("text_anunt");
	    		 String pretAnunt = rst.getString("pret_anunt");
	    		 byte[] img1 = rst.getBytes("photo1");
	    		 byte[] img2 = rst.getBytes("photo2");
	    		 byte[] img3 =  rst.getBytes("photo3");
	    		 byte[] img4 = rst.getBytes("photo4");
	    		 byte[] img5 = rst.getBytes("photo5");
	    		 String statute = rst.getString("statute");
	    		 anunt = new Annoncement(id,userName,titluAnunt,dataAnunt,textAnunt,pretAnunt,img1
	    			  ,img2,img3,img4,img5,statute);
	    		 listAnunt.add(anunt);
		    	  }
		
		return listAnunt;
		
	}

	/*
	public Annoncement getAnuncementId(int id) throws SQLException{
		Annoncement anunt =null;
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionSocietate();
		String getUser = "SELECT*FROM anunt_vanzare where id ='"+id+"'";
	      Statement stmt = con.createStatement();
	      ResultSet rst = stmt.executeQuery(getUser);
	      while(rst.next()) {
	    	    // int id = rst.getInt("id");
	    		 String userName = rst.getString("user_name");
	    		 String dataAnunt = rst.getString("data_anunt");
	    		 String textAnunt = rst.getString("text_anunt");
	    		 String pretAnunt = rst.getString("pret_anunt");
	    		 FileInputStream photo1 =  (FileInputStream) rst.getBlob("photo1");
	    		 FileInputStream photo2 =  (FileInputStream) rst.getBlob("photo2");
	    		 FileInputStream photo3 =  (FileInputStream) rst.getBlob("photo3");
	    		 FileInputStream photo4 =  (FileInputStream) rst.getBlob("photo4");
	    		 FileInputStream photo5 =  (FileInputStream) rst.getBlob("photo5");
	    		 anunt = new Annoncement(id,userName,dataAnunt,textAnunt,pretAnunt,photo1
	    			  ,photo2,photo3,photo4,photo5);
	    		 
		    	  }
		
		return anunt;
		
	}
		*/
	//Insert  into table anunt_vanzare
	public int insertAnunt( 
			Annoncement anunt) throws SQLException, FileNotFoundException {
		
		int row = 0; 
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionSocietate();
		InputStream fs1=anunt.getPhoto1();
		InputStream fs2=anunt.getPhoto2();
		InputStream fs3=anunt.getPhoto3();
		InputStream fs4=anunt.getPhoto4();
		InputStream fs5=anunt.getPhoto5();
		
		String insertUser = "INSERT INTO sales "
				+ "(user_name,titlu_anunt,data_anunt,text_anunt,pret_anunt, "
				+ "photo1,photo2,photo3,photo4,photo5,statute) values ( ?, ?,?,?,?,?,?,?,?,?,?)"; 
		
		
		PreparedStatement ps = con.prepareStatement(insertUser);
		ps.setString(1, anunt.getUserName());
		ps.setString(2, anunt.getTitluAnunt());
		ps.setString(3,anunt.getDataAnunt());
		ps.setString(4, anunt.getTextAnunt());
		ps.setString(5, anunt.getPretAnunt());
		ps.setBlob(6,fs1);
		ps.setBlob(7,fs2);
		ps.setBlob(8,fs3);
		ps.setBlob(9,fs4);
		ps.setBlob(10,fs5);
		ps.setString(11,anunt.getStatute());
		row = ps.executeUpdate();
		
		 helper.closeConnection(con);
	     
		 return row; 
	}

}
