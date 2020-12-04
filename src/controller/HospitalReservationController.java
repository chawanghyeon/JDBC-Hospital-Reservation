package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.CustodianDAO;
import model.InformationRecipientDAO;
import model.PatientDAO;
import model.ProblemDAO;
import model.domain.CustodianDTO;
import model.domain.InformationRecipientDTO;
import model.domain.PatientDTO;
import model.domain.ProblemDTO;
import view.EndView;

public class HospitalReservationController {
	private static HospitalReservationController instance = new HospitalReservationController();

	private HospitalReservationController() {
	}

	public static HospitalReservationController getInstance() {
		return instance;
	}
	
	// 환자 Id로 환자 검색 ,환자 Id로 예약 정보 확인
	public static PatientDTO getPatient(String patientId) {
		PatientDTO patient = null;
		try {
			patient = PatientDAO.getPatient(patientId);
		} catch(SQLException e){
			e.printStackTrace();
			EndView.showError("환자 id로 해당 환자 검색 오류");
		}
		return patient;
	}
	
	// 모든 의료기관 검색
	public static ArrayList<InformationRecipientDTO> getAllInfromationRecipient() {
		ArrayList<InformationRecipientDTO> allInformationRecipient = null;
		try{
			allInformationRecipient = InformationRecipientDAO.getAllInformationRecipients();
		}catch(SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 의료기관 검색시 에러 발생");
		}
		return allInformationRecipient;
	}
	
	// 모든 의사 검색
	public static ArrayList<CustodianDTO> getAllCustodian() {
		ArrayList<CustodianDTO> allCustodian = null;
		try{
			allCustodian = CustodianDAO.getAllCustodians();
		}catch(SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 의사 검색시 에러 발생");
		}
		return allCustodian;
	}
	
	// 특정 의사 선택해서 예약
	public void addPatient(PatientDTO patient) {

	}
	
	// 진료 완료 후 진단 내역 생성
	public void addProblem(ProblemDTO problem) {

	}
	// 진단 내역 출력 후 다음 단계 출력
	public static ProblemDTO getProblem(String patientId) {
		ProblemDTO problem = null;
		try {
			problem = ProblemDAO.getProblem(problemcode)
		}catch() {
			
		}
	}

}
