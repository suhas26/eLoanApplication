package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;

public class ConnectionDao {
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	public  Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	
	//add new user
	public boolean addUserRecord (User user) throws ClassNotFoundException, SQLException {
		String sql = "insert into user(username,password) values(?,?)";
		this.connect();
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		
		int n = pstmt.executeUpdate();
		pstmt.close();
		
		this.disconnect();
		
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//validate user record
	public boolean validateUserRecord (User user) throws ClassNotFoundException, SQLException {
		String sql = "select * from user where username = '"+user.getUsername()+"'";
		boolean flag = false;
		this.connect();
		
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs =  stmt.executeQuery(sql);

		if(rs.next()) {
			String dbPassword = rs.getString(2);
			if (dbPassword.equals(user.getPassword())) 
				flag=true;
			else
				flag=false;
		} else
			flag = false;
		
		rs.close();
		stmt.close();
		this.disconnect();
		return flag;
	}
	
	//place loan
	public boolean placeLoan(LoanInfo loanInfo) throws ClassNotFoundException, SQLException {
		String sql = "insert into loaninfo(purpose, amtrequest, doa, bstructure," + 
				"bindicator,address, email, mobile, status) values(?,?,?,?,?,?,?,?,?)";
		this.connect();
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		
		pstmt.setString(1, loanInfo.getPurpose());
		pstmt.setInt(2, loanInfo.getAmtrequest());
		pstmt.setString(3, loanInfo.getDoa());
		pstmt.setString(4, loanInfo.getBstructure());
		pstmt.setString(5, loanInfo.getBindicator());
		pstmt.setString(6, loanInfo.getAddress());
		pstmt.setString(7, loanInfo.getEmail());
		pstmt.setString(8, loanInfo.getMobile());
		pstmt.setString(9, "Submitted");
		
		int n = pstmt.executeUpdate();
		pstmt.close();
		
		this.disconnect();
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//return the application number
	public String getApplicationNumber() throws ClassNotFoundException, SQLException {
		String sql = "select * from loaninfo";
		String applicationNo="";
		this.connect();
		
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs =  stmt.executeQuery(sql);

		if(rs.last()) {
			applicationNo = rs.getString(1);
		}else {
			applicationNo="false";
		}
		
		rs.close();
		stmt.close();
		this.disconnect();
		return applicationNo;
	}
	
	//get Loan Details with application Number
	public LoanInfo getLoanDetails(LoanInfo loanInfo) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM loaninfo where applno = "+loanInfo.getApplno();
		this.connect();
		boolean flag = false;
		
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs =  stmt.executeQuery(sql);

		if(rs.next()) {
			loanInfo.setPurpose(rs.getString("purpose"));
			loanInfo.setAmtrequest(rs.getInt("amtrequest"));
			loanInfo.setDoa(rs.getString("doa"));
			loanInfo.setBstructure(rs.getString("bstructure"));
			loanInfo.setBindicator(rs.getString("bindicator"));
			loanInfo.setAddress(rs.getString("address"));
			loanInfo.setMobile(rs.getString("mobile"));
			loanInfo.setEmail(rs.getString("email"));
			loanInfo.setStatus(rs.getString("status"));
			
			flag = true;
		}
		
		rs.close();
		stmt.close();
		this.disconnect();
		
		if (flag)
			return loanInfo;
		else
			return null;
	}
	
	//edit loan application
	public boolean editLoan(LoanInfo loanInfo) throws ClassNotFoundException, SQLException {
		String sql = "update loaninfo set purpose = ?, amtrequest = ?, doa = ?, bstructure = ?," + 
				"bindicator = ?,address = ?, email = ?, mobile = ?, status = ? where applno = "+loanInfo.getApplno();
		this.connect();
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		
		pstmt.setString(1, loanInfo.getPurpose());
		pstmt.setInt(2, loanInfo.getAmtrequest());
		pstmt.setString(3, loanInfo.getDoa());
		pstmt.setString(4, loanInfo.getBstructure());
		pstmt.setString(5, loanInfo.getBindicator());
		pstmt.setString(6, loanInfo.getAddress());
		pstmt.setString(7, loanInfo.getEmail());
		pstmt.setString(8, loanInfo.getMobile());
		pstmt.setString(9, loanInfo.getStatus());
		
		int n = pstmt.executeUpdate();
		pstmt.close();
		
		this.disconnect();
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//Get All Loan Details
	public ArrayList<LoanInfo> listAllLoans() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM loaninfo";
		this.connect();
		ArrayList<LoanInfo> allLoanInfo = new ArrayList<LoanInfo>();
		LoanInfo dbLoanInfo = new LoanInfo();
		
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs =  stmt.executeQuery(sql);
		int i = 0;
		while(rs.next()) {
			dbLoanInfo.setApplno(rs.getInt("applno"));
			dbLoanInfo.setPurpose(rs.getString("purpose"));
			dbLoanInfo.setAmtrequest(rs.getInt("amtrequest"));
			dbLoanInfo.setDoa(rs.getString("doa"));
			dbLoanInfo.setBstructure(rs.getString("bstructure"));
			dbLoanInfo.setBindicator(rs.getString("bindicator"));
			dbLoanInfo.setAddress(rs.getString("address"));
			dbLoanInfo.setMobile(rs.getString("mobile"));
			dbLoanInfo.setEmail(rs.getString("email"));
			dbLoanInfo.setStatus(rs.getString("status"));
			
			allLoanInfo.add(i,dbLoanInfo);
			i++;
		}
		
		rs.close();
		stmt.close();
		this.disconnect();
		
		return allLoanInfo;
	}
	
	//approve loan
	public boolean approveloan(LoanDto loanDto) throws ClassNotFoundException, SQLException {
		String sql = "insert into approvedloan(applno, amountsanctioned, loanterm, psd," + 
				"lcd,emi) values(?,?,?,?,?,?)";
		this.connect();
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		
		pstmt.setInt(1, loanDto.getApplno());
		pstmt.setInt(2, loanDto.getAmtSanctioned());
		pstmt.setInt(3, loanDto.getTerm());
		pstmt.setString(4, loanDto.getStartDate());
		pstmt.setString(5, loanDto.getEndDate());
		pstmt.setInt(6, loanDto.getEmi());
		
		int n = pstmt.executeUpdate();
		pstmt.close();
		
		this.disconnect();
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//Change the Status of the application through application number
	public boolean updateStatus(int applicationNumber) throws ClassNotFoundException, SQLException {
		String sql = "update loaninfo set status = 'Approved' where applno = "+applicationNumber;
		boolean flag = false;
		this.connect();
		
		Statement stmt = this.jdbcConnection.createStatement();
		int rs =  stmt.executeUpdate(sql);

		if(rs>0) {
			flag = true;
		}else {
			flag = false;
		}
		
		stmt.close();
		this.disconnect();
		return flag;
	}
	
	// put the relevant DAO methods here..
}
