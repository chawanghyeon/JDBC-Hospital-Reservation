package controller;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import model.HospitalReservationService;
import model.domain.PatientDTO;
import model.domain.ProblemDTO;
import view.EndView;

@Slf4j
public class HospitalReservationController {
	private static HospitalReservationController instance = new HospitalReservationController();

	private HospitalReservationController() {
	}

	public static HospitalReservationController getInstance() {
		return instance;
	}
	//인스턴스가 절대적으로 한개만 존재하는 것을 보증하고 싶을 경우 사용

	//두 번째 이용시부터는 객체 로딩 시간이 현저하게 줄어 성능이 좋아지는 장점

	//멀티 스레드 환경에서 사용시 설계 주의
	static HospitalReservationService service = HospitalReservationService.getInstance();

	// 환자 Id로 환자 검색 ,환자 Id로 예약 정보 확인
	public void getPatient(String patientId) {
		try {
			EndView.patientView(service.getPatient(patientId));
			log.info(patientId + "로 예약정보확인이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("환자 id로 해당 환자 검색 오류");
			log.info(patientId + "로  해당 환자 검색이 오류가 났습니다.");
		}
	}

	// 모든 의료기관 검색
	public void getAllInfromationRecipient() {
		try {
			EndView.informationRecipientListView(service.getAllInformationRecipients());
			log.info("모든 의료기관 검색이 완료되었습니다.");
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("모든 의료기관 검색시 에러 발생");
			log.info("모든 의료기관 검색 도중 에러가 발생했습니다.");
		}
	}

	// 모든 의사 검색
	public void getAllCustodian() {
		try {
			EndView.custodianListView(service.getAllCustodians());
			log.info("모든 의사 검색이 완료되었습니다.");
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("모든 의사 검색시 에러 발생");
			log.info("모든 의사 검색 도중 에러가 발생했습니다.");
		}
	}

	// 특정 의사 선택해서 예약
	public void addPatient(PatientDTO patient) {
		try {
			if (service.addPatient(patient) == true) {
				EndView.showMessage("환자 기록이 저장되었습니다.");
				log.info("환자 기록이 저장 되었습니다: " + patient);
			} else {
				EndView.showError("환자 기록 저장 오류 : 환자 작성 내역을 확인해주세요");
				log.info("환자 기록 저장 오류로 인해 환자 작성 내역 확인 권고: " + patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("환자 기록 저장시 에러 발생");
			log.info("환자 기록 저장 도중 에러가 발생했습니다: " + patient);
		}
	}

	// 진료 완료 후 진단 내역 생성
	public void addProblem(ProblemDTO problem) {
		try {
			if (service.addProblem(problem) == true) {
				EndView.showMessage("환자의 진료 기록이 저장되었습니다.");
				log.info("환자 진료기록이 저장되었습니다: " + problem);
			} else {
				EndView.showError("진료서 저장 오류 : 진료 작성 내역을 확인해주세요.");
				log.info("진료서 저장 오류로 인해 진료작성 내역 확인 권고: " + problem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("진료 내역 저장시 에러 발생: ");
			log.info("진료 내역 저장시 에러 발생: " + problem);
		}
	}

	// 진단 내역 출력 후 다음 단계 출력
	public void getProblem(String ProblemCode) {
		try {
			EndView.problemView(service.getProblem(ProblemCode));
			log.info("진단 내역 출력 했습니다: " + ProblemCode);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("진단코드로 해당 진단 검색 오류: " + ProblemCode);
			log.info("진단 내역 검색 도중 오류가 나타났습니다: " + ProblemCode);
		}
	}
}