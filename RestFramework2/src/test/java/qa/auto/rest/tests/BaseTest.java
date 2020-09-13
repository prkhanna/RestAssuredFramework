package qa.auto.rest.tests;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import qa.auto.rest.util.PropertyReader;

public class BaseTest {
	
	public static PropertyReader propReader;
	
	@BeforeClass
	public static void setup() {
		
		propReader = PropertyReader.getInstance();
	//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.baseURI = propReader.getPropertyDetails("BaseURL");
	}
}
