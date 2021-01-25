/**
 * 
 */
package org.fasttrackit.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fasttrackit.dao.SaleDAO;
import org.fasttrackit.dao.UserDAO;
import org.fasttrackit.password.PasswordUtils;
import org.fasttrackit.pojo.Annoncement;
import org.fasttrackit.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import email.send_email_gmail;


@Controller
@MultipartConfig(maxFileSize = 16177215) 
public class LoginController {
	private static boolean isLoginSuperAdmin = false ;
	private static String myUserName=null;
	
	public static boolean isLoginSuperAdmin() {
		return isLoginSuperAdmin;
	}
	

	public   void setLoginSuperAdmin(boolean isLoginSuperAdmin) {
		this.isLoginSuperAdmin = isLoginSuperAdmin;
	}


	public static String getMyUserName() {
		return myUserName;
	}



	public void setMyUserName(String myUserName) {
		this.myUserName = myUserName;
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
	
	
	// redirect to adminregister.jsp
	@RequestMapping(value="register-admin.htm")
	public ModelAndView adminRegister() throws SQLException {
		
		return new ModelAndView("WEB-INF/Register/adminregister.jsp");
		
	}
	
	// redirect to termens.jsp
		@RequestMapping(value="termens.htm")
		public ModelAndView redirectTermens() throws SQLException {
			
			return new ModelAndView("WEB-INF/Register/termens.jsp");
			
		}
	
	 //collect and validate data from adminregister.jsp
	@RequestMapping(value="new-user.htm")
	public ModelAndView insertNewUser(@ModelAttribute("newuser") User newUser , HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		PasswordUtils utilPassword = new PasswordUtils();
		send_email_gmail adminEmail =new send_email_gmail();
		String fullName = newUser.getFullName();
		 String phoneNumber = newUser.getPhoneNumber();
		 String companyName = newUser.getCompanyName();
		 String vatNumber = newUser.getVatNumber();
		 String nrOnrc = newUser.getNrOnrc();
		 String companyAdress = newUser.getCompanyAdress();
		 String email = newUser.getEmail();
		 String password = newUser.getPassword();
		 String retypePassword = newUser.getRetypePassword();
		 String generatePassword = null;
		 String saltWord = null;
		 
		 if((newUser.getPassword()!=null)&&(!newUser.getPassword().isBlank())&&(!newUser.getPassword().isEmpty())) {
		 if(newUser.getPassword().equals(newUser.getRetypePassword())) {
			 saltWord = utilPassword.getSalt(30);
			 generatePassword = utilPassword.generateSecurePassword(password, saltWord);
		
		 newUser.setSalt(saltWord);
		 newUser.setPassword(generatePassword);
		newUser.setRole1("USER");
		newUser.setStatute1("FORBIDDEN");
		UserDAO udao = new UserDAO();
		udao.insertUser(newUser);
		adminEmail.sendAdminEmail();
		out.print("<p style=text-align:center;color:blue>Felicitari, Inregistrare cu succes! In cel mai scurt timp o sa va contactam pentru activarea contului</p>");
		
		 HttpSession session=request.getSession();
			session.invalidate();
			out.close();
			
		 }
		    }
		 else {
			 setLoginSuperAdmin(false);
	
			 out.print("<p style=text-align:center;color:red>Sorry, username or password error1!</p>");
			 HttpSession session=request.getSession();
				session.invalidate();
				out.close();
				}
		 
		return new ModelAndView("WEB-INF/Register/adminregister.jsp");
		          }
	
	
	//Login for admin&user
	@RequestMapping(value="login-portal.htm")
	public ModelAndView adminPortal( HttpServletRequest request, HttpServletResponse response,final RedirectAttributes redirectAttributes) throws SQLException, IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		UserDAO udao = new UserDAO();
		ArrayList<User> userList = new ArrayList<User>();
		String myEmail = request.getParameter("email");
		String myPassword = request.getParameter("password");
		
		PasswordUtils uPassword = new PasswordUtils();
		String salt = null ;
		String adminPassword = "admin33202510";
		salt = uPassword.getSalt(30);
		String generatePassword = null;
		 generatePassword = uPassword.generateSecurePassword( adminPassword,salt);
		User superAdmin = new User("Ovidiu Milosan","+40733551555","Microgame S.R.L",
              "33202510","J05/844/2014","Oradea,Str. Muntele Gaina,Nr. 18",
             "ovidiu.milo@gmail.com",salt,generatePassword,"SUPERADMIN","ACTIVE");	
UserDAO udao1 = new UserDAO();
SaleDAO sales = new SaleDAO();

 try {
	udao1.createTableUser();
	sales.createTableSales();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 int count=0;
try {
	 
	 count = udao1.verifyTableUser();
	 
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

if(count==0) {
	   try {
		udao1.insertUser(superAdmin);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
 }
		
		
		
		boolean myEmailIsOk = isNotNullNotEmptyNotWhiteSpace(myEmail) ;
		boolean myPasswordIsOk = isNotNullNotEmptyNotWhiteSpace(myPassword);
		userList = udao.getUser();
		if((myEmailIsOk==true)&&(myPasswordIsOk==true)) {
		for(User myUser:userList) {
		 boolean adminPasswordMatch=false;
		 String verifyPassword = myUser.getPassword();
		 String adminSalt = myUser.getSalt();
			adminPasswordMatch = PasswordUtils.verifyUserPassword( myPassword,myUser.getPassword(), myUser.getSalt());
        if((adminPasswordMatch==true)&&(myUser.getEmail().equalsIgnoreCase(myEmail))) 
        {
        	setMyUserName(myUser.getFullName());
        	if((myUser.getRole1().equals("SUPERADMIN"))&&(myUser.getStatute1().equals("ACTIVE"))) {
        		setLoginSuperAdmin(true);
        	redirectAttributes.addFlashAttribute("myUser", myUser);
            return new ModelAndView("redirect:/lista-user.htm");
        	}
        	if((myUser.getRole1().equals("ADMIN"))&&(myUser.getStatute1().equals("ACTIVE"))) {
        		setLoginSuperAdmin(true);
        		redirectAttributes.addFlashAttribute("myUser", myUser);
                return new ModelAndView("redirect:/lista-user.htm");
            	}
        	else if((myUser.getRole1().equals("USER"))&&(myUser.getStatute1().equals("ACTIVE"))) {
        		setLoginSuperAdmin(true);
        		redirectAttributes.addFlashAttribute("myUser", myUser);
                return new ModelAndView("WEB-INF/Home/home.jsp");
            	}
        	
                    } 
		              }
		                 }
		if(isLoginSuperAdmin == false) {
            out.print("<p style=text-align:center;color:red>Sorry, email or password error!</p>");
			out.close();
		                       }
		         setMyUserName(null);
				 setLoginSuperAdmin(false);
				 return new ModelAndView("index.html");
        
		
	}
	
	
	
	//listare clienti user
	@RequestMapping(value="lista-user.htm")
	public ModelAndView listareUseri(@ModelAttribute("myUser") User myUser ,Model model,BindingResult result) throws SQLException, ServletException, IOException {
		
		if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
			
			UserDAO udao = new UserDAO();
			ArrayList<User> userList = new ArrayList<User>();
			ArrayList<User> userList1 = new ArrayList<User>();
			userList=udao.getUser();
			myUser =udao.getOneUser(getMyUserName());
		String myUserFullName = getMyUserName();
		int nr = 1;
		
		for(int i=1;i<userList.size();i++) {
		User user1 = userList.get(i);
		user1.setId(i);
		nr++;
		  userList1.add(user1) ;                
		  }
		model.addAttribute("nr", nr);
		model.addAttribute("myUser", getMyUserName());
		model.addAttribute("userList1",userList1);
		return new ModelAndView("WEB-INF/Admin/userlist.jsp","model",model);
		}
		else {
			 isLoginSuperAdmin = false;
			 return new ModelAndView("redirect:/login-portal.htm");
		}
	}
	
	//editare User 
	@RequestMapping(value="edit-user.htm")
	public ModelAndView listareUser(@ModelAttribute("user") User user,Model model,BindingResult result) throws SQLException, ServletException, IOException {
		String myUserFullName= getMyUserName();
		String fullName = user.getFullName();
		
		if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
		UserDAO adao = new UserDAO();
		user = adao.getOneUser(fullName);
		user.setId(1);
		model.addAttribute("myUser", getMyUserName());
		model.addAttribute("user", user);
		
		return new ModelAndView("WEB-INF/Admin/userview.jsp","model",model);
	}
		else {
			isLoginSuperAdmin = false;
		
			 return new ModelAndView("redirect:/login-portal.htm");
		}
	}
	
	//back to userList 
		@RequestMapping(value="back-userlist.htm")
		public ModelAndView backUserList(HttpServletRequest request, HttpServletResponse response,final RedirectAttributes redirectAttributes) throws SQLException, IOException, ServletException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("index.html").include(request, response);
			User myUser = new User();
			if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
				UserDAO udao = new UserDAO();
				myUser=udao.getOneUser(getMyUserName());
				redirectAttributes.addFlashAttribute("myUser", myUser);
			return new ModelAndView("redirect:/lista-user.htm");
			}
			else {
			isLoginSuperAdmin = false;
			return new ModelAndView("redirect:/login-portal.htm");
			}
			
			
		}
		
	//editare User/role
		@RequestMapping(value="update-rolestatute.htm")
		public ModelAndView editareRoleUser(@ModelAttribute("updateUser") User updateUser,
				Model model,BindingResult result) throws SQLException {
			if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
			User user =new User();
			User myUser=new User();
			String fullName= updateUser.getFullName();
			String fullnameMyUser = getMyUserName();
			UserDAO udao = new UserDAO();
			user = udao.getOneUser(fullName);
			myUser = udao.getOneUser(getMyUserName());
			boolean stringOk =false;
			
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getPhoneNumber());
			
			String phone=updateUser.getPhoneNumber();
			if(stringOk==true)
			 {
				user.setPhoneNumber(updateUser.getPhoneNumber());
			}
			else {
				user.setPhoneNumber(user.getPhoneNumber());
			}
			
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getCompanyName());
			
			if(stringOk==true) {
				user.setCompanyName(updateUser.getCompanyName());
			}
			else {
				user.setCompanyName(user.getCompanyName());
			}
			
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getVatNumber());
			if(stringOk==true) {
				user.setVatNumber(updateUser.getVatNumber());
			}
			else {
				user.setVatNumber(user.getVatNumber());
			}
			
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getNrOnrc());
			if(stringOk==true) {
				user.setNrOnrc(updateUser.getNrOnrc());
			}
			else {
				user.setNrOnrc(user.getNrOnrc());
			}
			
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getCompanyAdress());
			if(stringOk==true) {
				user.setCompanyAdress(updateUser.getCompanyAdress());
			}
			else {
				user.setCompanyAdress(user.getCompanyAdress());
			}
			
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getEmail());
			if(stringOk==true) {
				user.setEmail(updateUser.getEmail());
			}
			else {
				user.setEmail(user.getEmail());
			}
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getStatute1());
			if(stringOk==true) {
			user.setStatute1(updateUser.getStatute1());
			}
			else {
				user.setStatute1(user.getStatute1());
			}
			stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getRole1());
			if(stringOk==true) {
			user.setRole1(updateUser.getRole1());
			}
			else {
				user.setRole1(user.getRole1());
			}
			udao.updateUser(user, updateUser.getFullName());
			
			
			model.addAttribute("myUser",getMyUserName());
			model.addAttribute("user", user);
			 return new ModelAndView("WEB-INF/Admin/userview.jsp","model",model);
			}
			else {
				isLoginSuperAdmin = false;
				 return new ModelAndView("redirect:/login-portal.htm");
			}
		}
		//redirectionare spre pagina comuna
				@RequestMapping(value="home.htm")
				public ModelAndView microportal(@ModelAttribute("isLogin") User user,Model model,
						BindingResult result) throws SQLException {
					String fullName = getMyUserName();
					UserDAO udao =new UserDAO();
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					user=udao.getOneUser(fullName);
					//user.setMyUserFullName(fullName);
					model.addAttribute("user", user);
					model.addAttribute("fullName", getMyUserName());
					return new ModelAndView("WEB-INF/Home/home.jsp","model",model);
					}
					else {
						isLoginSuperAdmin = false;
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				//editare User
				@RequestMapping(value="my-acount.htm")
				public ModelAndView editUser(Model model) throws SQLException {
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null))	{
					User user = new User();
					UserDAO adao = new UserDAO();
					user = adao.getOneUser(getMyUserName());
					user.setId(1);
					model.addAttribute("user", user);
					model.addAttribute("fullName", getMyUserName());
					return new ModelAndView("WEB-INF/Home/myacount.jsp","model",model);
					}
					else {
						isLoginSuperAdmin = false;
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				

				//editare User/role
				@RequestMapping(value="update-user.htm")
				public ModelAndView editareUser(@ModelAttribute("fullName") User updateUser,Model model,BindingResult result) throws SQLException {
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null))	{
					User user = new User();
					UserDAO udao = new UserDAO();
					user=udao.getOneUser(getMyUserName());
					boolean stringOk =false;
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getPhoneNumber());
					String phone=updateUser.getPhoneNumber();
					if(stringOk==true)
					 {
						user.setPhoneNumber(updateUser.getPhoneNumber());
					}
					else {
						user.setPhoneNumber(user.getPhoneNumber());
					}
					
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getCompanyName());
					if(stringOk==true) {
						user.setCompanyName(updateUser.getCompanyName());
					}
					else {
						user.setCompanyName(user.getCompanyName());
					}
					
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getVatNumber());
					if(stringOk==true) {
						user.setVatNumber(updateUser.getVatNumber());
					}
					else {
						user.setVatNumber(user.getVatNumber());
					}
					
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getNrOnrc());
					if(stringOk==true) {
						user.setNrOnrc(updateUser.getNrOnrc());
					}
					else {
						user.setNrOnrc(user.getNrOnrc());
					}
					
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getCompanyAdress());
					if(stringOk==true) {
						user.setCompanyAdress(updateUser.getCompanyAdress());
					}
					else {
						user.setCompanyAdress(user.getCompanyAdress());
					}
					if(updateUser.getStatute1()==null)
					user.setStatute1(user.getStatute1());
					else
						user.setStatute1(updateUser.getStatute1());
					if(updateUser.getRole1()==null)
					user.setRole1(user.getRole1());
					else
						user.setRole1(updateUser.getRole1());
					udao.updateUser(user, getMyUserName());
					model.addAttribute("user", user);
					model.addAttribute("fullName", getMyUserName());
					 return new ModelAndView("WEB-INF/Home/myacount.jsp","model",model);
					}
					else {
						isLoginSuperAdmin = false;
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				//vizualizare anunturi VanzareUser
				@RequestMapping(value="view-sale.htm")
				public ModelAndView viewAnnoncementUserSale() throws SQLException {
					ModelMap model = new ModelMap();
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null))	{
						SaleDAO sdao = new SaleDAO();
						UserDAO udao = new UserDAO();
						User user = new User();
						user = udao.getOneUser(getMyUserName());
						ArrayList<Annoncement> listAnunt = new ArrayList<Annoncement>();
						listAnunt = sdao.getAllAnuncementUser(getMyUserName());
						model.addAttribute("user",user);
						model.addAttribute("listAnunt", listAnunt);
					return new ModelAndView("WEB-INF/Home/view-sale.jsp","model",model);
					}
					else {
						isLoginSuperAdmin = false;
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				
				//vizualizare anunturi VanzareUser
				@RequestMapping(value="add-sale.htm")
				public ModelAndView addAnnoncementUserSale() throws SQLException {
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null))	{	
					return new ModelAndView("WEB-INF/Home/addannoncementsale.jsp");
					}
					else {
						isLoginSuperAdmin = false;
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				
		} 

