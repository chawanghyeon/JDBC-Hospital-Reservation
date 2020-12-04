package controller;

import java.sql.SQLException;
import model.HospitalReservationService;
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
	
	static HospitalReservationService service = HospitalReservationService.getInstance();
	
	// 환자 Id로 환자 검색 ,환자 Id로 예약 정보 확인
	public void getPatient(String patientId) {
		try {
			EndView.patientView(service.getPatient(patientId));
		} catch(Exception e){
			e.printStackTrace();
			EndView.showError("환자 id로 해당 환자 검색 오류");
		}
	}
	
	// 모든 의료기관 검색
	public void getAllInfromationRecipient() {
		try{
			EndView.informationRecipientListView(service.getAllInformationRecipients());
		}catch(Exception s) {
			s.printStackTrace();
			EndView.showError("모든 의료기관 검색시 에러 발생");
		}
	}
	
	// 모든 의사 검색
	public void getAllCustodian() {
		try{
			EndView.custodianListView(service.getAllCustodians());
		}catch(Exception s) {
			s.printStackTrace();
			EndView.showError("모든 의사 검색시 에러 발생");
		}
	}
	
	// 특정 의사 선택해서 예약
	public void addPatient(PatientDTO patient) {
		try {
			 if(service.addPatient(patient) == true) {
				 EndView.showMessage("환자 기록이 저장되었습니다.");
			 }else {
				 EndView.showError("환자 기록 저장 오류 : 환자 작성 내역을 확인해주세요.");
			 }
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("환자 기록 저장시 에러 발생");
		}
	}
	
	// 진료 완료 후 진단 내역 생성
	public void addProblem(ProblemDTO problem) {
		try {
			if(service.addProblem(problem) == true) {
				EndView.showMessage("환자의 진료 기록이 저장되었습니다.");
			}else {
				EndView.showError("진료서 저장 오류 : 진료 작성 내역을 확인해주세요.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("진료 내역 저장시 에러 발생");
		}
	}
	
	// 진단 내역 출력 후 다음 단계 출력
	public void getProblem(String ProblemCode) {
		try {
			EndView.problemView(service.getProblem(ProblemCode));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("진단코드로 해당 진단 검색 오류");
		}
	}
}
