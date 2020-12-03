package view;

import controller.HospitalReservationController;
import model.domain.PatientDTO;
import model.domain.ProblemDTO;

public class StartView {

	public static void main(String[] args) {
		HospitalReservationController controller = HospitalReservationController.getInstance();

		System.out.println("-----환자 Id로 환자 검색-----");
		controller.getPatient("PatientId"); // 검색 성공 or 실패

		System.out.println("-----모든 의료기관 검색-----");
		controller.getAllInfromationRecipient();

		System.out.println("-----모든 의사 검색-----");
		controller.getAllCustodian();

		System.out.println("-----특정 의사 선택해서 예약-----");
		controller.addPatient(new PatientDTO());

		System.out.println("-----환자 Id로 예약 정보 확인-----");
		controller.getPatient("PatientId");

		System.out.println("-----진료 완료 후 진단 내역 생성-----");
		controller.addProblem(new ProblemDTO());

		System.out.println("-----진단 내역 출력 후 다음 단계 출력-----");
		controller.getProblem("PatientId");

	}

}
