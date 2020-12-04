package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import model.domain.InformationRecipientDTO;
import util.DBUtil;

public class InformationRecipientDAO {

	static Properties sqlAll = DBUtil.getSqlAll();

	private static InformationRecipientDAO instance = new InformationRecipientDAO();

	private InformationRecipientDAO() {
	}

	public static InformationRecipientDAO getInstance() {
		return instance;
	}

	// 병원기관 등록
	public boolean addInformationRecipient(InformationRecipientDTO informationrecipient) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("informationrecipient.insert"));
			pstmt.setInt(1, informationrecipient.getOID());
			pstmt.setString(2, informationrecipient.getOrganizationName());
			pstmt.setString(3, informationrecipient.getDoctorName());
			pstmt.setString(4, informationrecipient.getTelecomNumber());
			pstmt.setString(5, informationrecipient.getCity());
			pstmt.setString(6, informationrecipient.getDepartmentName());
			pstmt.setInt(7, informationrecipient.getDepartmentCode());

			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정 - 병원기관id로 원장이름과 원장 핸드폰번호 변경
	public boolean updateInformationRecipient(int OID, String doctorname, String telecomnumber) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("informationrecipient.update"));
			pstmt.setString(1, doctorname);
			pstmt.setString(2, telecomnumber);
			pstmt.setInt(3, OID);

			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 삭제
	public boolean deleteInformationRecipient(int OID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("informationrecipient.delete"));
			pstmt.setInt(1, OID);

			if (pstmt.executeUpdate() != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 병원기관의 모든 정보 반환
	public InformationRecipientDTO getInformationRecipient(int OID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("informationrecipient.getInformationRecipient"));
			pstmt.setInt(1, OID);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				return new InformationRecipientDTO(rset.getInt(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7));
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return null;
	}

	// 모든 병원기관 검색해서 반환
	public ArrayList<InformationRecipientDTO> getAllInformationRecipients() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<InformationRecipientDTO> list = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlAll.getProperty("informationrecipientAll"));
			list = new ArrayList<InformationRecipientDTO>();

			while (rset.next()) {
				list.add(new InformationRecipientDTO(rset.getInt(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return list;
	}
}
