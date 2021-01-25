package org.fasttrackit.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Date;

import javax.servlet.http.Part;

public class Annoncement {
private int id;
private String userName;
private String titluAnunt;
private String dataAnunt;
private String textAnunt;
private String pretAnunt;

private InputStream photo1;
private InputStream  photo2;
private InputStream  photo3;
private InputStream  photo4;
private InputStream  photo5;

private byte[] img1;
private byte[] img2;
private byte[] img3;
private byte[] img4;
private byte[] img5;

private String statute;

public Annoncement() {
	// TODO Auto-generated constructor stub
}





public Annoncement(String userName, String titluAnunt, String dataAnunt, String textAnunt, String pretAnunt,
		InputStream photo1, InputStream photo2, InputStream photo3, InputStream photo4, InputStream photo5,
		String statute) {
	super();
	this.userName = userName;
	this.titluAnunt = titluAnunt;
	this.dataAnunt = dataAnunt;
	this.textAnunt = textAnunt;
	this.pretAnunt = pretAnunt;
	this.photo1 = photo1;
	this.photo2 = photo2;
	this.photo3 = photo3;
	this.photo4 = photo4;
	this.photo5 = photo5;
	this.statute = statute;
}





public Annoncement(int id, String userName, String titluAnunt, String dataAnunt, String textAnunt, String pretAnunt,
		InputStream photo1, InputStream photo2, InputStream photo3, InputStream photo4, InputStream photo5,
		String statute) {
	super();
	this.id = id;
	this.userName = userName;
	this.titluAnunt = titluAnunt;
	this.dataAnunt = dataAnunt;
	this.textAnunt = textAnunt;
	this.pretAnunt = pretAnunt;
	this.photo1 = photo1;
	this.photo2 = photo2;
	this.photo3 = photo3;
	this.photo4 = photo4;
	this.photo5 = photo5;
	this.statute = statute;
}





public Annoncement(int id, String userName, String titluAnunt, String dataAnunt, String textAnunt, String pretAnunt,
		byte[] img1, byte[] img2, byte[] img3, byte[] img4, byte[] img5, String statute) {
	super();
	this.id = id;
	this.userName = userName;
	this.titluAnunt = titluAnunt;
	this.dataAnunt = dataAnunt;
	this.textAnunt = textAnunt;
	this.pretAnunt = pretAnunt;
	this.img1 = img1;
	this.img2 = img2;
	this.img3 = img3;
	this.img4 = img4;
	this.img5 = img5;
	this.statute = statute;
}





public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getTitluAnunt() {
	return titluAnunt;
}





public void setTitluAnunt(String titluAnunt) {
	this.titluAnunt = titluAnunt;
}





public String getDataAnunt() {
	return dataAnunt;
}


public void setDataAnunt(String dataAnunt) {
	this.dataAnunt = dataAnunt;
}


public String getTextAnunt() {
	return textAnunt;
}


public void setTextAnunt(String textAnunt) {
	this.textAnunt = textAnunt;
}


public String getPretAnunt() {
	return pretAnunt;
}


public void setPretAnunt(String pretAnunt) {
	this.pretAnunt = pretAnunt;
}


public InputStream getPhoto1() {
	return photo1;
}


public void setPhoto1(InputStream photo1) {
	this.photo1 = photo1;
}


public InputStream getPhoto2() {
	return photo2;
}


public void setPhoto2(InputStream photo2) {
	this.photo2 = photo2;
}


public InputStream getPhoto3() {
	return photo3;
}


public void setPhoto3(InputStream photo3) {
	this.photo3 = photo3;
}


public InputStream getPhoto4() {
	return photo4;
}


public void setPhoto4(InputStream photo4) {
	this.photo4 = photo4;
}


public InputStream getPhoto5() {
	return photo5;
}


public void setPhoto5(InputStream photo5) {
	this.photo5 = photo5;
}


public String getStatute() {
	return statute;
}


public void setStatute(String statute) {
	this.statute = statute;
}





public byte[] getImg1() {
	return img1;
}





public void setImg1(byte[] img1) {
	this.img1 = img1;
}





public byte[] getImg2() {
	return img2;
}





public void setImg2(byte[] img2) {
	this.img2 = img2;
}





public byte[] getImg3() {
	return img3;
}





public void setImg3(byte[] img3) {
	this.img3 = img3;
}





public byte[] getImg4() {
	return img4;
}





public void setImg4(byte[] img4) {
	this.img4 = img4;
}





public byte[] getImg5() {
	return img5;
}





public void setImg5(byte[] img5) {
	this.img5 = img5;
}




}
