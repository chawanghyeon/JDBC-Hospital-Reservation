package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationRecipientDTO {
	int OID; //981012801
	String OrganizationName; // "B 병원"
	String DoctorName; // "김의사"
	String TelecomNumber; //000-0000-0000"
	String City; //"서울시"
	String DepartmentName; // "가정의학과"
	int DepartmentCode; // "2300"

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InformationRecipientDTO [OID=");
		builder.append(OID);
		builder.append(", OrganizationName=");
		builder.append(OrganizationName);
		builder.append(", DoctorName=");
		builder.append(DoctorName);
		builder.append(", TelecomNumber=");
		builder.append(TelecomNumber);
		builder.append(", City=");
		builder.append(City);
		builder.append(", DepartmentName=");
		builder.append(DepartmentName);
		builder.append(", DepartmentCode=");
		builder.append(DepartmentCode);
		builder.append("]");
		return builder.toString();
	}
}

