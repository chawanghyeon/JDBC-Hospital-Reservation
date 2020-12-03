package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustodianDTO {
	private int MedicalLicenseID; // "00000"
	private String CustodianName; // "A 병원"
	private String TelecomNumber; // ""010-0000-0000"
	private int OID; // "991001281" //981012801
	private String DoctorName; // "이순신"
	private String DoctorTelecomNumber; // "010-0000-0000"
	private int DepartmentCode; // "1400"
	private String DepartmentName; // "피부과"
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustodianDTO [MedicalLicenseID=");
		builder.append(MedicalLicenseID);
		builder.append(", CustodianName=");
		builder.append(CustodianName);
		builder.append(", TelecomNumber=");
		builder.append(TelecomNumber);
		builder.append(", OID=");
		builder.append(OID);
		builder.append(", DoctorName=");
		builder.append(DoctorName);
		builder.append(", DoctorTelecomNumber=");
		builder.append(DoctorTelecomNumber);
		builder.append(", DepartmentCode=");
		builder.append(DepartmentCode);
		builder.append(", DepartmentName=");
		builder.append(DepartmentName);
		builder.append("]");
		return builder.toString();
	}
}
