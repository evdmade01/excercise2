package nl.interaccess.cucumber.ex2;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;

public class BrowserSteps {
	private String baseUrl = "http://www.potenca.nl/webshop/dnvvwdxhgasap4j3";


	@Als("^ik Potencashop open$")
	public void ik_Potencashop_open() throws Throwable {
		BrowserUtils.getWebDriver().get(baseUrl);
	}

	@Als("^email \"([^\"]*)\" intyp$")
	public void email_intyp(String email) throws Throwable {
		BrowserUtils.getWebDriver().findElement(By.id("email")).clear();
		BrowserUtils.getWebDriver().findElement(By.id("email")).sendKeys(email);
	}

	@Als("^password \"([^\"]*)\" intyp$")
	public void password_intyp(String password) throws Throwable {
		BrowserUtils.getWebDriver().findElement(By.id("passwd")).clear();
		BrowserUtils.getWebDriver().findElement(By.id("passwd")).sendKeys(password);
	}

	@Als("^op de inloggenbutton klik$")
	public void op_de_inloggenbutton_klik() throws Throwable {
		BrowserUtils.getWebDriver().findElement(By.name("submitLogin")).click();
	}

	@Dan("^is adminpagina zichtbaar$")
	public void is_adminpagina_zichtbaar() throws Throwable {
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("a.employee_name.dropdown-toggle > span.string-long"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	}
	
	private boolean isElementPresent(By by) {
	    try {
	      BrowserUtils.getWebDriver().findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

}
	
/*	Archief!
 * @Als("^als zoekterm \"([^\"]*)\" intyp$")
public void als_zoekterm_intyp(String zoekterm) throws Throwable {
	BrowserUtils.getWebDriver().findElement(By.name("q")).sendKeys(zoekterm);
}

@Als("^op de zoekbutton klik$")
public void op_de_zoekbutton_klik() throws Throwable {
	BrowserUtils.getWebDriver().findElement(By.name("btnG")).click();
}	

@Dan("^is het linkje van het eerste zoekresultaat \"([^\"]*)\"$")
public void is_het_linkje_van_het_eerste_zoekresultaat(String link) throws Throwable {
	List<WebElement> resultLinks = BrowserUtils.getWebDriver().findElements(By.cssSelector("h3.r > a"));
	Assert.assertEquals(link, resultLinks.get(0).getAttribute("href"));
}*/
