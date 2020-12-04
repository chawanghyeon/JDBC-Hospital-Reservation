package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import model.domain.PatientDTO;
import util.DBUtil;

public class PatientDAO {

	static Properties sqlAll = DBUtil.getSqlAll();

	private static PatientDAO instance = new PatientDAO();

	private PatientDAO() {
	}

	public static PatientDAO getInstance() {
		return instance;
	}

	// 환자 등록
	public boolean addPatient(PatientDTO patient) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("patient.insert"));
			pstmt.setString(1, patient.getPatientId());
			pstmt.setInt(2, patient.getDateOfBirth());
			pstmt.setString(3, patient.getPatientName());
			pstmt.setString(4, patient.getGender());
			pstmt.setString(5, patient.getTelecomNumber());
			pstmt.setString(6, patient.getCity());
			pstmt.setString(7, patient.getReservationDate());
			pstmt.setString(8, patient.getReservationTime());
			pstmt.setInt(9, patient.getMedicalLicenseID());

			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정 - 환자id로 예약날짜, 예약시간 변경
	public boolean updatePatient(String patientId, String reservationdate, String reservationtime) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("patient.update"));
			pstmt.setString(1, reservationdate);
			pstmt.setString(2, reservationtime);
			pstmt.setString(3, patientId);

			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 삭제
	public boolean deletePatient(String patientId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("patient.delete"));
			pstmt.setString(1, patientId);

			if (pstmt.executeUpdate() != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 환자의 모든 정보 반환
	public PatientDTO getPatient(String patientId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("patient.getPatient"));
			pstmt.setString(1, patientId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				return new PatientDTO(rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getInt(9));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return null;
	}

	// 모든 환자 검색해서 반환
	public ArrayList<PatientDTO> getAllPatients() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<PatientDTO> list = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlAll.getProperty("patientAll"));
			list = new ArrayList<PatientDTO>();

			while (rset.next()) {
				list.add(new PatientDTO(rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getInt(9)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return list;
	}
}
