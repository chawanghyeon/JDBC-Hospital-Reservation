package view;

import java.util.ArrayList;

import model.domain.CustodianDTO;
import model.domain.InformationRecipientDTO;
import model.domain.PatientDTO;
import model.domain.ProblemDTO;

public class EndView {

	// 환자 id로 환자 검색
	public static void patientView(PatientDTO patient) {
		System.out.println(patient);
	}
		
	// 모든 의료기관 검색
	public static void informationRecipientListView(ArrayList<InformationRecipientDTO> allInformationRecipient) {
		int length = allInformationRecipient.size();
		
		if(length != 0) {
			for(int index = 0; index < length; index++) {
				System.out.println("의료기관 정보 검색" + (index+1) + "-" + allInformationRecipient.get(index));
			}
		}else {
			System.out.println("검색된 정보가 존재하지 않습니다.");
		}
	}

	// 모든 의사 검색
	public static void custodianListView(ArrayList<CustodianDTO> allCustodian) {
		int length = allCustodian.size();
		
		if(length != 0) {
			for(int index = 0; index < length; index++) {
				System.out.println("의료진 정보 검색" + (index+1) + "-" + allCustodian.get(index));
			}
		}else {
			System.out.println("검색된 정보가 존재하지 않습니다.");
		}
	}
	
	// 진단 내역 출력 후 다음 단계 출력
	public static void problemView(ProblemDTO problem) {
		System.out.println(problem);
	}
		
	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
	}
	
	// 정보 확인 메세지 출력
	public static void showMessage(String message) {
		System.out.println(message);
	}
}
