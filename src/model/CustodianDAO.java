package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import model.domain.CustodianDTO;
import util.DBUtil;

public class CustodianDAO {

	static Properties sqlAll = DBUtil.getSqlAll();
	
	//의료진 등록
	public static boolean addCustodian(CustodianDTO custodian) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("custodian.insert"));
			pstmt.setInt(1, custodian.getMedicalLicenseID());
			pstmt.setString(2, custodian.getCustodianName());
			pstmt.setString(3, custodian.getTelecomNumber());
			pstmt.setInt(4, custodian.getOID());
			pstmt.setString(5, custodian.getDoctorName());
			pstmt.setString(6, custodian.getDoctorTelecomNumber());
			pstmt.setInt(7, custodian.getDepartmentCode());
			pstmt.setString(8, custodian.getDepartmentName());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 수정 - 의료진id로  의사 이름과 진료과코드, 진료과명 변경
		public static boolean updateCustodian(int medicallicenseID, String doctorname, String doctortelecomNumber, int departmentcode, String departmentname) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
		
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sqlAll.getProperty("patient.update"));
				pstmt.setString(1, doctorname);
				pstmt.setString(2, doctortelecomNumber);
				pstmt.setInt(3, departmentcode);
				pstmt.setString(4, departmentname);
				pstmt.setInt(5, medicallicenseID);
				
				int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
			}finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		
	// 삭제
	public static boolean deleteCustodian(String medicallicenseid) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("custodian.delete"));
			
			pstmt.setString(1, medicallicenseid);
			
			int result = pstmt.executeUpdate();
			if(result != 0) {
				return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 의료진의 모든 정보 반환
		public static CustodianDTO getCustodian(String medicallicenseid) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			CustodianDTO custodian = null;
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sqlAll.getProperty("custodian.getCustodian"));
				pstmt.setString(1, medicallicenseid);
				rset = pstmt.executeQuery();
			
				if(rset.next()) {
					custodian = new CustodianDTO(rset.getInt(1),
												rset.getString(2),
												rset.getString(3),
												rset.getInt(4),
												rset.getString(5),
												rset.getString(6),
												rset.getInt(7),
												rset.getString(8));
				}
			}finally {
				DBUtil.close(con, pstmt);
			}
			return custodian;
		}
		
		// 모든 의료진 검색해서 반환
		public static ArrayList<CustodianDTO> getAllCustodians() throws SQLException{
			Connection con = null;
			Statement stmt = null;
			ResultSet rset = null;
			ArrayList<CustodianDTO> list = null;
			
			try {
				con = DBUtil.getConnection();
				stmt = con.createStatement();
				rset = stmt.executeQuery(sqlAll.getProperty("custodianAll"));
				list = new ArrayList<CustodianDTO>();
				while(rset.next()) {
					list.add(new CustodianDTO(rset.getInt(1),
												rset.getString(2),
												rset.getString(3),
												rset.getInt(4),
												rset.getString(5),
												rset.getString(6),
												rset.getInt(7),
												rset.getString(8)));
				}
			}catch (SQLException s) {
				s.printStackTrace();
				throw s;
			}finally {
				DBUtil.close(con, stmt, rset);
			}
			return list;
		}

}
