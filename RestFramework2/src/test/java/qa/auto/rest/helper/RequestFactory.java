package qa.auto.rest.helper;

import java.util.concurrent.TimeUnit;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import qa.auto.rest.dataObject.EmployeeDetails;
import qa.auto.rest.tests.BaseTest;

public class RequestFactory extends BaseTest {

	FunctionLibrary  fl = new FunctionLibrary();
	
	@Step("Getting all the employees from rest")
	public Response getAllEmployees() {
		
		Response response = fl.doGetRequest("/employees");
		
		return response;
		
	}
	
	@Step("Getting single  employees from rest")
	public Response getSingleEmployees(Integer id) {
		
		Response response = fl.doGetSingleRequest("/employee/" + id);
		return response;
		
	}
	@Step("This will add new employee: {0}, {1},{2},{3},{4}")
	public Response addEmployee(Integer id, String name, Integer salary, Integer age, String profileImg) {
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setId(id);
		empDetails.setEmployee_name(name);
		empDetails.setEmployee_salary(salary);
		empDetails.setProfile_image(profileImg);
		empDetails.setEmployee_age(age);
		Response response = fl.doPostRequest("/create", empDetails, ContentType.JSON);
		
		return response;
		
	}
	
	@Step("Updating a single employee : {0}, {1},{2},{3},{4} ")
	public Response updateEmployee(Integer id,String name, Integer salary,Integer age, String profileImg) {
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setId(id);
		empDetails.setEmployee_name(name);
		empDetails.setEmployee_salary(salary);
		empDetails.setProfile_image(profileImg);
		empDetails.setEmployee_age(age);
	
    Response response = fl.doPutRequestWithParamater("/update/"+ id,empDetails, ContentType.JSON);
		
		return response;
	}
	
	@Step("Getting single  employees from rest")
	public Response deleteSingleEmployee(Integer id) {
		
		Response response = fl.doDeleteRequest("/delete/" + id);
		return response;
		
	}
}
