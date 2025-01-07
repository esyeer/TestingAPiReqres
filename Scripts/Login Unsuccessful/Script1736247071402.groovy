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

//Define base uRL
def baseUrl = findTestObject('Object Repository/Login User')

// Define the request body
String requestBody = '''
{
    "email": "eve.holt@reqres.in",
    "password": ""
}
'''

// Set the request body
baseUrl.setBodyContent(new HttpTextBodyContent(requestBody))

//send the request
def response = WS.sendRequest(baseUrl)

// Parse JSON response
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

//assert response status
println(response.getStatusCode())
assert response.getStatusCode() == 400 : "Status Code Expected 400 and Actuals ${response.getStatusCode()}"

//assert the response body have token and value
assert !response.getResponseText().contains("token") : "Response does contain 'token' property"
assert jsonResponse.error != "" : "missing error message"
assert jsonResponse.error == "Missing password" : "Expected Value 'Missing password' but actuals ${jsonResponse.error}"
//WS.verifyElementPropertyValue(response, 'token', jsonResponse.token)

println("Response Body: " + response.getResponseText())
println("get respon token : " + jsonResponse.token)
