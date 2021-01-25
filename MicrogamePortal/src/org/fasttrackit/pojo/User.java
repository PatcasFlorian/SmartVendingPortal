/**
 * 
 */
package org.fasttrackit.pojo;

/**
 * @author Florin
 *
 */
public class User {

	/**
	 * 
	 */
	private int id;
	private String fullName;
	private String phoneNumber;
	private String companyName;
	private String vatNumber;
	private String nrOnrc;
	private String companyAdress;
	private String email;
	private String salt;
	private String password;
	private String retypePassword;
	private String role1;
	private String statute1;
	
	public User() {
		// TODO Auto-generated constructor stub
	}



	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public User(String email, String salt, String password) {
		super();
		this.email = email;
		this.salt = salt;
		this.password = password;
	}




	

	public User(String fullName, String phoneNumber, String companyName, String vatNumber, String nrOnrc,
			String companyAdress, String email, String salt, String password, String role1,
			String statute1) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
		this.vatNumber = vatNumber;
		this.nrOnrc = nrOnrc;
		this.companyAdress = companyAdress;
		this.email = email;
		this.salt = salt;
		this.password = password;
		this.role1 = role1;
		this.statute1 = statute1;
	}



	public User(int id, String fullName, String phoneNumber, String companyName, String vatNumber, String nrOnrc,
			String companyAdress, String email, String salt, String password, String role1, String statute1) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
		this.vatNumber = vatNumber;
		this.nrOnrc = nrOnrc;
		this.companyAdress = companyAdress;
		this.email = email;
		this.salt = salt;
		this.password = password;
		this.role1 = role1;
		this.statute1 = statute1;
	}



	public User(int id, String fullName, String phoneNumber, String companyName, String vatNumber, String nrOnrc,
			String companyAdress, String email, String role1, String statute1) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
		this.vatNumber = vatNumber;
		this.nrOnrc = nrOnrc;
		this.companyAdress = companyAdress;
		this.email = email;
		this.role1 = role1;
		this.statute1 = statute1;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}


	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}


	public String getNrOnrc() {
		return nrOnrc;
	}


	public void setNrOnrc(String nrOnrc) {
		this.nrOnrc = nrOnrc;
	}


	public String getCompanyAdress() {
		return companyAdress;
	}


	public void setCompanyAdress(String companyAdress) {
		this.companyAdress = companyAdress;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRetypePassword() {
		return retypePassword;
	}


	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getRole1() {
		return role1;
	}



	public void setRole1(String role1) {
		this.role1 = role1;
	}



	public String getStatute1() {
		return statute1;
	}



	public void setStatute1(String statute1) {
		this.statute1 = statute1;
	}

	

}
