package qa.auto.rest.tests;



import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.javafaker.Faker;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import qa.auto.rest.helper.RequestFactory;
import qa.auto.rest.specs.SpecificationFactory;
import qa.auto.rest.tags.Regression;
import qa.auto.rest.tags.Smoke;


@Story("This is CRUD story")
public class CrudTest extends BaseTest{
	
	RequestFactory reqFact = new RequestFactory();
	//http://dummy.restapiexample.com/api/v1/employees
	
	@Category(value = { Smoke.class })
	@Test
	@DisplayName("Test to get all Employee")
	@Feature("Get Employee Feature")
	@Tag("SmokeTest")
	public void getAllEmployee() {
		
		reqFact.getAllEmployees()
		.then()
		//this is a generic method created which can be checked for each test case
		.spec(SpecificationFactory.getGenericResponseSpec())
		.log()
		.body()
		.statusCode(200);
	}

	//http://dummy.restapiexample.com/api/v1/employee/1
	@Category(value = { Regression.class })
	@Test
	@DisplayName("Test to get an Employee")
	@Feature("Get Employee Feature")
	public void getSingleEmployee() {
		
		reqFact.getSingleEmployees(5)
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	
	//http://dummy.restapiexample.com/api/v1/create
	//@Test
	@DisplayName("Test to add an Employee")
	@Feature("Add Employee Feature")
	public void postEmployee() {
		
		Faker fakeDate =  new Faker();
		 String Name = fakeDate.name().fullName();
		  int Salary = fakeDate.number().randomDigit();
		  
		reqFact.addEmployee(999,Name,Salary,25,"")
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	
	
	//http://dummy.restapiexample.com/api/v1/update/21
	//@Test
	@DisplayName("Test to update a single an Employee")
	@Feature("Update single Employee  Feature")
	public void updateEmployee() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reqFact.updateEmployee(5, "Deepa", 5000, 29, "")
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	
	
	@Category(value = { Regression.class,Smoke.class })
	@Test
	@DisplayName("Test to delete a single Employee")
	@Feature("Delete single Employee  Feature")
	@Tag("SmokeTest,Regression")
	public void deleteEmployee() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reqFact.deleteSingleEmployee(3)
		.then()
		.log()
		.body()
		.statusCode(200);
	}
}
