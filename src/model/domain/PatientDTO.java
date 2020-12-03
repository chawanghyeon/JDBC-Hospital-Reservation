package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
	private String PatientId; // "pt001"
	private int DateOfBirth; // "19880101"
	private String PatientName; // "홍길동"
	private String Gender; // "Male/Female"
	private String TelecomNumber; // "010-0000-0000"
	private String City; // "성남시"
	private String ReservationDate; // "2020-11-30"
	private String ReservationTime; // "09:20:00"
	private int MedicalLicenseID; // 의사 ID
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientDTO [LocalId=");
		builder.append(PatientId);
		builder.append(", DateOfBirth=");
		builder.append(DateOfBirth);
		builder.append(", PatientName=");
		builder.append(PatientName);
		builder.append(", Gender=");
		builder.append(Gender);
		builder.append(", TelecomNumber=");
		builder.append(TelecomNumber);
		builder.append(", City=");
		builder.append(City);
		builder.append(", ReservationDate=");
		builder.append(ReservationDate);
		builder.append(", ReservationTime=");
		builder.append(ReservationTime);
		builder.append("]");
		return builder.toString();
	}
}
