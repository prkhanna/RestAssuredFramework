package qa.auto.rest.dataObject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDetails {

	private Integer id;
	private String employee_name;
	private Integer employee_salary;
	private Integer employee_age;
	private String profile_image;
}
