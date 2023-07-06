package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.drivermanager.BaseClass;

public class orderflow extends BaseClass {

	public orderflow() {
		PageFactory.initElements(driver, this);
	}
	public By searchbox = By.xpath("//input[@id='twotabsearchtextbox']");
	public By searchbutton = By.id("nav-search-submit-button");
	public By logo = By.id("nav-logo");
	public By locationchange = By.xpath("(//span[@class='a-button-inner'])[1]");
	public By product = By.xpath("(//img[@src='https://m.media-amazon.com/images/I/618Bb+QzCmL._AC_UY218_.jpg'])[1]");
	public By addcart = By.cssSelector("input[id='add-to-cart-button']");
	public By cart = By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']");	
}
