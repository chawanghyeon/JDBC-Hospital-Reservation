package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDTO {
	String ProblemCode; // "M8416" , "B019"
	int StartDate; // "20160201", "20160201"
	String ProblemName; // "골절의 불유합","합병증이 없는 수두"
	String PatientId; // 환자 아이디
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProblemDTO [ProblemCode=");
		builder.append(ProblemCode);
		builder.append(", StartDate=");
		builder.append(StartDate);
		builder.append(", ProblemName=");
		builder.append(ProblemName);
		builder.append(", PatientId=");
		builder.append(PatientId);
		builder.append("]");
		return builder.toString();
	}
}

