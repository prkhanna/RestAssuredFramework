package qa.auto.rest.specs;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import qa.auto.rest.tests.BaseTest;
import qa.auto.rest.util.PropertyReader;

public class SpecificationFactory extends BaseTest {
	
	public static PropertyReader propReader;
	
	public static synchronized ResponseSpecification getGenericResponseSpec() {
		
		
		ResponseSpecification responseSpecification;
		
		ResponseSpecBuilder responseSpecBuilder;
		
		responseSpecBuilder =  new ResponseSpecBuilder();
		responseSpecBuilder.expectHeader("Content-Type", "application/json;charset=utf-8");
		responseSpecBuilder.expectResponseTime(lessThan(20L), TimeUnit.SECONDS);
		
		responseSpecification = responseSpecBuilder.build();
		
		return responseSpecification ;
		
	}

	
	/**
	 * This method will use to log the reponse info in allure report
	 * @return
	 */
	public static synchronized RequestSpecification loadPayloadResponseInfo() {

		RequestSpecification requestSpecification;
		
		RequestSpecBuilder requestSpecBuilder;
		requestSpecBuilder =  new RequestSpecBuilder();
		
		requestSpecBuilder.addFilter(new AllureRestAssured());
	
		requestSpecification =  requestSpecBuilder.build();
		
		return requestSpecification;
		
	}

}
