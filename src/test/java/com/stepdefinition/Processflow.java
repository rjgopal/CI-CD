package com.stepdefinition;

import com.drivermanager.BaseClass;
import com.drivermanager.BrowserLaunch;
//import com.genreports.Reports;
import com.pages.orderflow;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class Processflow extends BaseClass {
	
	orderflow ow = new orderflow();

	@Given("User should launch the web url and homepage")
	public void user_should_launch_the_web_url_and_homepage() throws Throwable {
//    try {			
//			Reports.Report();
//			Reports.ReportCreateFeatureTest("Process.feature");
//			Reports.ReportCreateScenarioTest("Ordering and validating the product price and quantity");
			BrowserLaunch launch = new BrowserLaunch();
			launch.selectBrowser();
			waitUntil(500);
			IsElementDisplayed(ow.logo);
//			Reports.Givenlogpass("user_should_launch_the_web_url_and_homepage","Url and Homepage sucessfully launched");
			
//		} catch (Exception e) {
			
//			Reports.Givenlogfail("user_should_launch_the_web_url_and_homepage","Url and Homepage is not sucessfully launched");
//		}
	}

	@When("User should select and add the first product to cart")
	public void user_should_select_and_add_the_first_product_to_cart() throws Throwable {
		
//		try {
			TypeDataInTheField(ow.searchbox, (PropertyFile("Product", TestData)));
			Click(ow.searchbutton);
			Click(ow.product);
			SwitchWindow();
			ScrollDownToElement(ow.addcart);
			Click(ow.addcart);
			waitUntil(500);
			//IsElementDisplayed(ow.cart);
			waitUntil(500);
//			Reports.Whenlogpass("user_should_select_and_add_the_first_product_to_cart",
//					"Product added to cart sucessfully");
			
//		} catch (Exception e) {
			
//			Reports.Whenlogfail("user_should_select_and_add_the_first_product_to_cart",
//					"Product not added to cart sucessfully");
//		}
//		Reports.ReportCooldown();
		driver.quit();
	}

//	@Then("User should open the cart and validate the order details of first product")
//	public void user_should_open_the_cart_and_validate_the_order_details_of_first_product() throws Throwable {
//		
//		try {
//			
//			System.out.println("success");
//			
//		} catch (Exception e) {
//			
//			Reports.Thenlogfail("User_should_open_the_cart_and_validate_the_order_details_of_first_product",
//					"Totalprice and Quantity not validated sucessfully");
//		}
//	}
//
//	@Then("User should select and add the second product to cart")
//	public void user_should_select_and_add_the_second_product_to_cart() throws Throwable {
//		
//		try {
//			
//			System.out.println("success");
//			Reports.Thenlogpass("the_user_should_select_and_add_the_second_product_to_cart",
//					"Totalprice and Quantity validated sucessfully");
//			
//		} catch (Exception e) {
//			
//			Reports.Thenlogfail("the_user_should_select_and_add_the_second_product_to_cart",
//					"Totalprice and Quantity not validated sucessfully");
//		}
//
//	}
//
//	@Then("User should open the cart and validate the order details of second product")
//	public void user_should_open_the_cart_and_validate_the_order_details_of_second_product() throws Throwable {
//		
//		try {
//			
//			System.out.println("success");
//			Reports.Thenlogpass("user_should_open_the_cart_and_validate_the_order_details_of_second_product",
//					"Totalprice and Quantity validated sucessfully");
//			
//		} catch (Exception e) {
//			
//			Reports.Thenlogfail("user_should_open_the_cart_and_validate_the_order_details_of_second_product",
//					"Totalprice and Quantity not validated sucessfully");
//		}
//	}
//
//	@Then("User should change the quantity of first selected product")
//	public void user_should_change_the_quantity_of_first_selected_product() throws Throwable {
//		
//		try {
//			
//			System.out.println("success");
//			
//		} catch (Exception e) {
//			
//			Reports.Thenlogfail("user_should_change_the_quantity_of_first_selected_product",
//					"Quantity of first product not changed sucessfully");
//		}
//
//	}
//
//	@Then("User should validate the total price")
//	public void user_should_validate_the_total_price_and_quantity() throws Throwable {
//		
//		try {
//			
//			System.out.println("success");
//			Reports.Thenlogpass("user_should_validate_the_total_price", "Total cart price validated sucessfully");
//			
//		} catch (Exception e) {
//		    Reports.Thenlogfail("user_should_validate_the_total_price", "Total cart price not validated sucessfully");
//		    Reports.ReportCooldown();
//	}
//driver.quit();
	}

