package qa.auto.rest.helper;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import qa.auto.rest.specs.SpecificationFactory;
import qa.auto.rest.tests.BaseTest;

public class FunctionLibrary extends BaseTest {

	/**
	 * Generic method for get request
	 * 
	 * @param endPoint
	 * @return
	 */
	public Response doGetRequest(String endPoint) {

		Response response = given().when().get(endPoint);

		return response;

	}
	/**
	 * Generic method for get request
	 * 
	 * @param endPoint
	 * @return
	 */
	public Response doGetSingleRequest(String endPoint) {

		Response response = given().when().get(endPoint);

		return response;

	}

	/**
	 * 
	 * Generic method for get request with Query Parameter
	 * 
	 * @param res
	 * @param params
	 * @return
	 */
	public Response doGetRequestWithQueryParam(String endPoint, Map<String, String> params) {

		Response response = RestAssured.given().queryParams(params).when().get(endPoint);

		return response;

	}

	/**
	 * Generic method for get request with Header
	 * 
	 * @param res
	 * @param headers
	 * @return
	 */
	public Response doGetRequestWithHeader(String res, Map<String, String> headers) {

		Response response = given().headers(headers).when().get(res);

		return response;

	}

	/**
	 * Generic method for Post request
	 * 
	 * @param endpoint
	 * @param body
	 * @param contentType
	 * @return
	 */
	public Response doPostRequest(String endpoint, Object body, ContentType contentType) {

		Response response = given().when().contentType(contentType).spec(SpecificationFactory.loadPayloadResponseInfo()).body(body).post(endpoint);
		return response;

	}

	/**
	 * Generic method for Put request
	 * 
	 * @param endPoint
	 * @param body
	 * @param contentType
	 * @return
	 */
	public Response doPutRequest(String endPoint, Object body, ContentType contentType) {
		Response response = RestAssured.given().when().contentType(contentType).body(body).put(endPoint);
		return response;
	}

	
	/**
	 * Generic method for Put request
	 * 
	 * @param endPoint
	 * @param body
	 * @param contentType
	 * @return
	 */
	public Response doPutRequestWithParamater(String endPoint, Object body, ContentType contentType) {
		Response response = given().when().contentType(contentType).body(body).put(endPoint);
		return response;
	}

	/**
	 * Generic method for Delete request
	 * 
	 * @param endPoint
	 * @param body
	 * @param contentType
	 * @return
	 */
	public Response doDeleteRequest(String endPoint) {
		return given().when().delete(endPoint);

	}

	/**
	 * Generic method for patch request
	 * 
	 * @param res
	 * @param body
	 * @return
	 */
	public Response doPatchRequest(String endPoint, Object body) {

		Response response = given().when().body(body).patch(endPoint);

		return response;

	}

}
