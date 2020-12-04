package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.domain.ProblemDTO;
import util.DBUtil;

public class ProblemDAO {

	static Properties sqlAll = DBUtil.getSqlAll();

	private static ProblemDAO instance = new ProblemDAO();

	private ProblemDAO() {
	}

	public static ProblemDAO getInstance() {
		return instance;
	}

	// 저장
	public boolean addProblem(ProblemDTO problem) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("problem.insert"));
			pstmt.setString(1, problem.getPatientId());
			pstmt.setInt(2, problem.getStartDate());
			pstmt.setString(3, problem.getProblemCode());
			pstmt.setString(4, problem.getProblemName());

			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	public boolean updateProblem(String problemCode, String problemName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("problem.update"));
			pstmt.setString(1, problemName);
			pstmt.setString(2, problemCode);

			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 삭제
	public boolean deleteProblem(String problemCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("problem.delete"));
			pstmt.setString(1, problemCode);

			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ProblemCode로 해당 Problem 모든 정보 검색
	public ProblemDTO getProblem(String problemcode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("problem.getProblem"));
			pstmt.setString(1, problemcode);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				return new ProblemDTO(rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return null;
	}

	// 모든 problem 검색
	public ArrayList<ProblemDTO> getAllProblems() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProblemDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("problemAll"));
			rset = pstmt.executeQuery();
			list = new ArrayList<ProblemDTO>();

			while (rset.next()) {
				list.add(new ProblemDTO(rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
