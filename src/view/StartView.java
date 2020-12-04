package view;

import controller.HospitalReservationController;
import model.domain.PatientDTO;
import model.domain.ProblemDTO;

public class StartView {

	public static void main(String[] args) {
		HospitalReservationController controller = HospitalReservationController.getInstance();

		System.out.println("-----환자 Id로 환자 검색-----");
		controller.getPatient("pt014"); // 실패 출력되어야 함

		System.out.println("-----모든 의료기관 검색-----");
		controller.getAllInfromationRecipient();

		System.out.println("-----모든 의사 검색-----");
		controller.getAllCustodian();

//		System.out.println("-----특정 의사 선택해서 예약-----");
//		controller.addPatient(new PatientDTO("pt016", 19980907, "박현진", "Male", "010-1234-5678", "수원시", "2020-12-04", "14:00:00", 11120));
//
//		System.out.println("-----환자 Id로 예약 정보 확인-----");
		controller.getPatient("pt014");

//		System.out.println("-----진료 완료 후 진단 내역 생성-----");
//		controller.addProblem(new ProblemDTO("A0012", 20201204, "pt014", "앞트임"));

		System.out.println("-----진단 내역 출력 후 다음 단계 출력-----");
		controller.getProblem("A0010");

	}

}