package priceVerifications

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

public class priceVerification {

	private static List priceValues = []

	@Keyword
	public void verifyPricesInRange() {
		String priceLocator = "Page_Amazon.es tablet results/resultPrice"
		List priceElements = (WebUI.findWebElements(findTestObject(priceLocator),10)).subList(0,5)

		for(WebElement priceElement in priceElements) {
			String priceElementSanizated = priceElement.getText().replaceAll(",", ".")
			Float price = Float.parseFloat(priceElementSanizated)
			priceValues.add(price)
			if (price < GlobalVariable.minPrice.toInteger() || price > GlobalVariable.maxPrice.toInteger()) {
				KeywordUtil.markFailed("Price " + price + " is not in range")
			}
		}
	}

	@Keyword
	public void verifyPricesSortedHighestToLowest() {
		assert priceValues == priceValues.sort(false).reverse()
	}
}
