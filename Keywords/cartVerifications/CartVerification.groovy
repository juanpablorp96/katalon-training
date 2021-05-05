package cartVerifications

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class CartVerification {

	private static String productCardTitle;

	public String getElementText(String elementLocator) {
		WebElement element = WebUI.findWebElement(findTestObject(elementLocator),10)
		return element.getText()
	}

	@Keyword
	public void getProductCardTitleText() {
		productCardTitle = getElementText("Page_Amazon.es Accesorios Results Page/ProductResultCardTitle")
	}

	@Keyword
	public void verifyCartProduct() {
		String CartProductTitle = getElementText("Page_Amazon.es Cart Page/ProductTitle")
		assert productCardTitle == CartProductTitle
	}
}
