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
	String PatientId; // 환자 아이디
	int StartDate; // "20160201", "20160201"
	String ProblemCode; // "M8416" , "B019"
	String ProblemName; // "골절의 불유합","합병증이 없는 수두"
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProblemDTO [StartDate=");
		builder.append(StartDate);
		builder.append(", ProblemCode=");
		builder.append(ProblemCode);
		builder.append(", ProblemName=");
		builder.append(ProblemName);
		builder.append(", PatientId=");
		builder.append(PatientId);
		builder.append("]");
		return builder.toString();
	}
	

}

