package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.domain.CustodianDTO;
import model.domain.InformationRecipientDTO;
import model.domain.PatientDTO;
import model.domain.ProblemDTO;

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

	// CustodianDAO CRUD
	public void notExistCustodian(int medicallicenseid) throws NotExistException, SQLException {
		CustodianDTO custodian = custodianDAO.getCustodian(medicallicenseid);
		if (custodian == null) {
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
		}
	}

	public ArrayList<CustodianDTO> getAllCustodians() throws SQLException {
		return custodianDAO.getAllCustodians();
	}

	public CustodianDTO getCustodian(int medicallicenseid) throws SQLException, NotExistException {
		CustodianDTO custodian = custodianDAO.getCustodian(medicallicenseid);
		if (custodian == null) {
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
		return custodian;
	}

	public boolean addCustodian(CustodianDTO custodian) throws SQLException {
		return custodianDAO.addCustodian(custodian);
	}

	public boolean updateCustodian(int medicallicenseid, String doctorname, String doctortelecomNumber,
			int departmentcode, String departmentname) throws SQLException, NotExistException {
		notExistCustodian(medicallicenseid);
		return custodianDAO.updateCustodian(medicallicenseid, doctorname, doctortelecomNumber, departmentcode,
				departmentname);
	}

	public boolean deleteCustodian(int medicallicenseid) throws SQLException, NotExistException {
		notExistCustodian(medicallicenseid);
		return custodianDAO.deleteCustodian(medicallicenseid);
	}

	// InformationRecipientDAO CRUD
	public void notExistInformationRecipient(int OID) throws NotExistException, SQLException {
		InformationRecipientDTO informationRecipient = informationRecipientDAO.getInformationRecipient(OID);
		if (informationRecipient == null) {
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
		}
	}

	public ArrayList<InformationRecipientDTO> getAllInformationRecipients() throws SQLException {
		return informationRecipientDAO.getAllInformationRecipients();
	}

	public InformationRecipientDTO getInformationRecipient(int OID) throws SQLException, NotExistException {
		InformationRecipientDTO informationRecipient = informationRecipientDAO.getInformationRecipient(OID);
		if (informationRecipient == null) {
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
		return informationRecipient;
	}

	public boolean addInformationRecipient(InformationRecipientDTO informationrecipient) throws SQLException {
		return informationRecipientDAO.addInformationRecipient(informationrecipient);
	}

	public boolean updateInformationRecipient(int OID, String doctorname, String telecomnumber)
			throws SQLException, NotExistException {
		notExistInformationRecipient(OID);
		return informationRecipientDAO.updateInformationRecipient(OID, doctorname, telecomnumber);
	}

	public boolean deleteInformationRecipient(int OID) throws SQLException, NotExistException {
		notExistInformationRecipient(OID);
		return informationRecipientDAO.deleteInformationRecipient(OID);
	}

	// PatientDAO CRUD
	public void notExistPatient(String patientId) throws NotExistException, SQLException {
		PatientDTO patient = patientDAO.getPatient(patientId);
		if (patient == null) {
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
		}
	}

	public ArrayList<PatientDTO> getAllPatients() throws SQLException {
		return patientDAO.getAllPatients();
	}

	public PatientDTO getPatient(String patientId) throws SQLException, NotExistException {
		PatientDTO patient = patientDAO.getPatient(patientId);
		if (patient == null) {
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
		return patient;
	}

	public boolean addPatient(PatientDTO patient) throws SQLException {
		return patientDAO.addPatient(patient);
	}

	public boolean updatePatient(String patientId, String reservationdate, String reservationtime)
			throws SQLException, NotExistException {
		notExistPatient(patientId);
		return patientDAO.updatePatient(patientId, reservationdate, reservationtime);
	}

	public boolean deletePatient(String patientId) throws SQLException, NotExistException {
		notExistPatient(patientId);
		return patientDAO.deletePatient(patientId);
	}

	// ProblemDAO CRUD
	public void notExistProblem(String problemcode) throws NotExistException, SQLException {
		ProblemDTO problem = problemDAO.getProblem(problemcode);
		if (problem == null) {
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
		}
	}

	public ArrayList<ProblemDTO> getAllProblems() throws SQLException {
		return problemDAO.getAllProblems();
	}

	public ProblemDTO getProblem(String problemcode) throws SQLException, NotExistException {
		ProblemDTO problem = problemDAO.getProblem(problemcode);
		if (problem == null) {
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
		return problem;
	}

	public boolean addProblem(ProblemDTO problem) throws SQLException {
		return problemDAO.addProblem(problem);
	}

	public boolean updateProblem(String problemCode, String problemName) throws SQLException, NotExistException {
		notExistProblem(problemCode);
		return problemDAO.updateProblem(problemCode, problemName);
	}

	public boolean deleteProblem(String problemCode) throws SQLException, NotExistException {
		notExistProblem(problemCode);
		return problemDAO.deleteProblem(problemCode);
	}

}
