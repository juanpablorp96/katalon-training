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

WebUI.waitForElementVisible(findTestObject('Page_Amazon.es home/SearchBox'), GlobalVariable.timeOut)

WebUI.sendKeys(findTestObject('Page_Amazon.es home/SearchBox'), product)

WebUI.click(findTestObject('Page_Amazon.es home/SearchSubmitButton'))

WebUI.scrollToElement(findTestObject('Page_Amazon.es tablet results/MinPrice'), GlobalVariable.timeOut)

WebUI.sendKeys(findTestObject('Page_Amazon.es tablet results/MinPrice'), GlobalVariable.minPrice)

WebUI.sendKeys(findTestObject('Page_Amazon.es tablet results/MaxPrice'), GlobalVariable.maxPrice)

WebUI.click(findTestObject('Page_Amazon.es tablet results/PriceRangeGoButton'))

WebUI.waitForElementClickable(findTestObject('Page_Amazon.es tablet results/SortByDropdown'), GlobalVariable.timeOut)

WebUI.click(findTestObject('Page_Amazon.es tablet results/SortByDropdown'))

WebUI.waitForElementVisible(findTestObject('Page_Amazon.es tablet results/HighestToLowestOption'), GlobalVariable.timeOut)

WebUI.click(findTestObject('Page_Amazon.es tablet results/HighestToLowestOption'))

WebUI.scrollToElement(findTestObject('Page_Amazon.es tablet results/ResultPrice'), GlobalVariable.timeOut, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'priceVerifications.priceVerification.verifyPricesInRange'()

CustomKeywords.'priceVerifications.priceVerification.verifyPricesSortedHighestToLowest'()

