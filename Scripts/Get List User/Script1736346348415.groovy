import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject

//define new request object
RequestObject request = new RequestObject()

//set the rest url and method
request.setRestUrl('https://reqres.in/api/users?per_page=12')
request.setRestRequestMethod("GET")

//send the request
ResponseObject response = WS.sendRequest(request)

// Parse JSON response
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

//assert response status
println(response.getStatusCode())
assert response.getStatusCode() == 200 : "Status Code Expected 200 and Actuals ${response.getStatusCode()} "

// Define the JSON schema
String schema = 
'''
{
	"\$schema": "https://json-schema.org/draft/2020-12/schema",
    "type": "object",
    "properties": {
		"page": { "type": "number" },
		"per_page": { "type": "number" },
		"total": { "type": "number" },
		"total_pages": { "type": "number" },
        "data": {
            "type": "array",
            "properties": {
                "id": { "type": "number" },
                "email": { "type": "string", "format": "email" },
                "first_name": { "type": "string" },
                "last_name": { "type": "string" },
                "avatar": { "type": "string", "format": "uri" }
            },
            "required": ["id", "email", "first_name", "last_name", "avatar"],
            "additionalProperties": false
        },
        "support": {
            "type": "object",
            "properties": {
                "url": {
                    "type": "string",
                    "format": "uri"
                },
                "text": { "type": "string" }
            },
            "required": ["url", "text"],
            "additionalProperties": false
        }
    },
    "required": ["data", "support"],
    "additionalProperties": false
}
'''
//validate json schema
def isValid = WS.validateJsonAgainstSchema(response,schema)

println("Response Body: " + response.getResponseText())

//assert size response
assert jsonResponse.data.size() > 5
assert jsonResponse.support.size() == 2
assert jsonResponse.data.id.size() == 12
assert jsonResponse.data.email.size() == 12

//assert the response body have property
assert jsonResponse.containsKey("data") : "Response does not contain 'data' property"
assert jsonResponse.data != null : "Missing data"
assert jsonResponse.containsKey("support") : "Response does not contain 'support' property"
assert jsonResponse.support != null : "Missing support"


