package model;

import java.sql.SQLException;
import java.util.ArrayList;

import probono.exception.NotExistException;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.dto.RecipientDTO;

public class HospitalReservationService {

	private static HospitalReservationService instance = new HospitalReservationService();

	private HospitalReservationService() {
	}

	public static HospitalReservationService getInstance() {
		return instance;
	}

	private static CustodianDAO custodianDAO = CustodianDAO.getInstance();
	private static InformationRecipientDAO informationRecipientDAO = InformationRecipientDAO.getInstance();
	private static PatientDAO patientDAO = PatientDAO.getInstance();
	private static ProblemDAO problemDAO = ProblemDAO.getInstance();

}
