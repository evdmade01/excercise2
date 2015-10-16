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

public class BAfmeldenPotencaAdmin {

	@Als("^ik op Potencashop pagina ben$")
	public void ik_op_Potencashop_pagina_ben() throws Throwable {
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("a.employee_name.dropdown-toggle > span.string-long"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	}

	@Als("^op de avatar \"([^\"]*)\" klik$")
	public void op_de_avatar_klik(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Als("^op de link \"([^\"]*)\" klik$")
	public void op_de_link_klik(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dan("^kom ik terug op de login pagina$")
	public void kom_ik_terug_op_de_login_pagina() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	private boolean isElementPresent(By by) 
	{
	    try {
	      BrowserUtils.getWebDriver().findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	 }

}
