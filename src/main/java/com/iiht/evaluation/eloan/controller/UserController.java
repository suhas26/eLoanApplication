package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
//import com.mysql.cj.xdevapi.Statement;




@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ConnectionDao connDao;
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName=registernewuser(request,response);
				break;
			case "validate":
				viewName=validate(request,response);
				break;
			case "placeloan":
				viewName=placeloan(request,response);
				break;
			case "application1":
				viewName=application1(request,response);
				break;
			case "editLoanProcess"  :
				viewName=editLoanProcess(request,response);
				break;
			case "registeruser":
				viewName=registerUser(request,response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;	
			case  "displaystatus" :
				viewName=displaystatus(request,response);
				break;
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	}
	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if ((username.equals("admin"))&&(password.equals("admin"))){
			return "adminhome1.jsp";
		}
		
		User user = new User(username,password);
		
		try {
			boolean status = connDao.validateUserRecord(user);
			if (status) {
				return "userhome1.jsp";
			}
			else{
				return "errorPage.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
	}
	private String placeloan(HttpServletRequest request, HttpServletResponse response) {
	/* write the code to place the loan information */
		
		String purpose=request.getParameter("purpose");
		Integer amtrequest=Integer.parseInt(request.getParameter("amtrequest"));
		String applicationDate=request.getParameter("applicationDate");
		String businessStructure=request.getParameter("businessStructure");
		String billingIndicator=request.getParameter("billingIndicator");
		String contactAddress=request.getParameter("contactAddress");
		String mobileNumber=request.getParameter("mobileNumber");
		String emailAddress=request.getParameter("emailAddress");
		int applicationNumber = 0;
		String applicationStatus = "";
		
		LoanInfo loanInfo = new LoanInfo(applicationNumber, purpose, amtrequest, applicationDate, businessStructure, 
				billingIndicator,contactAddress, emailAddress, mobileNumber,applicationStatus);
		
		try {
			//PrintWriter out = response.getWriter();
			boolean status = connDao.placeLoan(loanInfo);
			if (status) {
				String applicationNo = connDao.getApplicationNumber();
				request.setAttribute("message","Application submitted successfully");
				request.setAttribute("applicationNumber","Application Number : "+applicationNo);
				return "application.jsp";
			}
			else{
				return "application.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
		
	}
	private String application1(HttpServletRequest request, HttpServletResponse response) {
	/* write the code to display the loan application page */
		
		return "editloan.jsp";
	}
	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to edit the loan info */
		int applicationNumber=Integer.parseInt(request.getParameter("applicationNo"));
		String purpose=request.getParameter("purpose");
		int amtrequest=Integer.parseInt(request.getParameter("amtrequest"));
		String applicationDate=request.getParameter("applicationDate");
		String businessStructure=request.getParameter("businessStructure");
		String billingIndicator=request.getParameter("billingIndicator");
		String contactAddress=request.getParameter("contactAddress");
		String mobileNumber=request.getParameter("mobileNumber");
		String emailAddress=request.getParameter("emailAddress");
		String applicationStatus = "Modified";
		
		LoanInfo loanInfo = new LoanInfo(applicationNumber, purpose, amtrequest, applicationDate, businessStructure, 
				billingIndicator,contactAddress, emailAddress, mobileNumber,applicationStatus);
		
		try {
			//PrintWriter out = response.getWriter();
			boolean status = connDao.editLoan(loanInfo);
			if (status) {
				//String applicationNo = connDao.getApplicationNumber();
				return "userhome1.jsp";
			}else {
				return "editloanui.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
	}
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to redirect page to read the user details */
		return "newuserui.jsp";
	}
	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User user = new User(username,password);
		
		try {
			boolean status = connDao.addUserRecord(user);
			if (status) {
				return "index.jsp";
			}
			else{
				return "errorPage.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		/* write the code to redirect to register page */
		
		return null;
	}
	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code the display the loan status based on the given application
		   number 
		*/
		int applno = Integer.parseInt(request.getParameter("applicationNumber"));
		LoanInfo loanInfo = new LoanInfo();
		loanInfo.setApplno(applno);
		
		try {
			loanInfo = connDao.getLoanDetails(loanInfo);
			request.setAttribute("loaninfo", loanInfo);
			return "loanDetails.jsp";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
	/* write a code to return to editloan page */
		
		int applno = Integer.parseInt(request.getParameter("applicationNumber"));
		LoanInfo loanInfo = new LoanInfo();
		loanInfo.setApplno(applno);
		
		try {
			loanInfo = connDao.getLoanDetails(loanInfo);
			if(!(loanInfo.getStatus().equalsIgnoreCase("Approved"))){
				request.setAttribute("loaninfo", loanInfo);
				return "editloanui.jsp";
			} else {
				request.setAttribute("message", "Cannot edit Approved Loans");
				return "editloan.jsp";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
	/* write a code to return to trackloan page */
		
		return "trackloan.jsp";
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
	/* write a code to return to trackloan page */
		return "application.jsp";
	}
}