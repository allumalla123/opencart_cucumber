package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ShoppingCartPage;
import pageObjects.Ssearchpage;


public class Search {
	WebDriver d;
	HomePage hp;
	LoginPage lp;
	Ssearchpage sp;
	ShoppingCartPage cp;
	
	@Given("I should login with vaild email as {string}  and password as {string}  first")
	public void i_should_login_with_vaild_email_as_and_password_as_first(String email, String pwd) throws InterruptedException {
		hp=new HomePage(BaseClass.getDriver());
		lp=new LoginPage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
		Thread.sleep(3000);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();	
	}

	@When("I need to search as {string} in searchbox and click")
	public void i_need_to_search_as_in_searchbox_and_click(String srch) {
		sp=new Ssearchpage(BaseClass.getDriver());
		sp.product(srch);
		sp.pclick();
		
	    
	}

	@When("should add product to cart")
	public void should_add_product_to_cart() throws InterruptedException {
		sp.cclick();
		sp.checkConfMsg();
		Thread.sleep(3000);
	}

	@When("I should click on shopping cart")
	public void i_should_click_on_shopping_cart() throws InterruptedException {
		Thread.sleep(3000);
	    cp=new ShoppingCartPage(BaseClass.getDriver());
	    cp.clickItemsToNavigateToCart();
	    cp.clickViewCart();
	}

	@Then("I should able to see product added to cart")
	public void i_should_able_to_see_product_added_to_cart() {
		//boolean targetpage=cp.isShoppingCartPageExit();
				
		//Assert.assertEquals(targetpage, true);
	   cp.clickOnCheckout();
	}

}
