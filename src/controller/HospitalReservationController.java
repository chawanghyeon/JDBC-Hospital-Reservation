package controller;

import model.domain.PatientDTO;
import model.domain.ProblemDTO;

public class HospitalReservationController {
	private static HospitalReservationController instance = new HospitalReservationController();

	private HospitalReservationController() {
	}

	public static HospitalReservationController getInstance() {
		return instance;
	}

	public void getPatient(String patientId) {

	}

	public void getAllInfromationRecipient() {

	}

	public void getAllCustodian() {

	}

	public void addPatient(PatientDTO patient) {

	}

	public void addProblem(ProblemDTO problem) {

	}

	public void getProblem(String patientId) {

	}
}
