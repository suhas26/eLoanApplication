package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
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
		String action =  request.getParameter("action");
		System.out.println(action);
		String viewName = "";
		try {
			switch (action) {
			case "listall" : 
				viewName = listall(request, response);
				break;
			case "process":
				viewName=process(request,response);
				break;
			case "callemi":
				viewName=calemi(request,response);
				break;
			case "updatestatus":
				viewName=updatestatus(request,response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
		
	}

	private String updatestatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code for update status of loan and return to admin home page */
		
		int applicationNumber = Integer.parseInt(request.getParameter("applicationNumber"));
		String purpose = request.getParameter("purpose");
		int amtSanctioned = Integer.parseInt(request.getParameter("amtSanctioned"));
		int term = Integer.parseInt(request.getParameter("term"));
		float interestRate = Float.parseFloat(request.getParameter("interestRate"));
		int emi = Integer.parseInt(request.getParameter("emi"));
		String paymentStartDate = request.getParameter("paymentStartDate");
		String paymentEndDate = request.getParameter("paymentEndDate");
		LoanDto loanDto = new LoanDto(applicationNumber,amtSanctioned,purpose,term,interestRate,emi,paymentStartDate,paymentEndDate,"Approved");
		
			try {
				boolean status = connDao.approveloan(loanDto);
				if (status) {
					boolean flag = connDao.updateStatus(applicationNumber);
					if (flag) {
						return "adminhome1.jsp";
					}else {
						return "errorPage.jsp";
					}
				} else {
					return "errorPage.jsp";
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	private String calemi(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to calculate emi for given applno and display the details */
		int applicationNumber = Integer.parseInt(request.getParameter("applicationNumber"));
		int term = Integer.parseInt(request.getParameter("term"));
		float interestRate = Float.parseFloat(request.getParameter("interestRate"));
		LoanInfo loanInfo = new LoanInfo();
		LoanDto loanDto = new LoanDto();
		loanInfo.setApplno(applicationNumber);
		loanDto.setApplno(applicationNumber);
		loanDto.setTerm(term);
		loanDto.setInterestRate(interestRate);
		
		
		try {
			loanInfo = connDao.getLoanDetails(loanInfo);
			loanDto.setAmtSanctioned(loanInfo.getAmtrequest());
			loanDto.setPurpose(loanInfo.getPurpose());
			loanDto.setStatus(loanInfo.getStatus());

			float requiredAmt = (float) ((loanInfo.getAmtrequest())*(Math.pow((1+interestRate/100),(term))));
			loanDto.setEmi((int) (requiredAmt/term));

			LocalDate d1 = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
			LocalDate d2 = d1.plusMonths(term);
			loanDto.setStartDate(d1.toString());
			loanDto.setEndDate(d2.toString());

			request.setAttribute("loanDto", loanDto);
			return "calemi.jsp";
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
	}
	private String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	/* return to process page */
		return  "process.jsp";
	}
	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
	/* write code to return index page */
		return "index.jsp";
	}

	private String listall(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	/* write the code to display all the loans */
		try {
			ArrayList<LoanInfo> loanInfo = connDao.listAllLoans();
			request.setAttribute("loaninfo", loanInfo);
			
			return "listall.jsp";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "errorPage.jsp";
		}
	}

	
}
