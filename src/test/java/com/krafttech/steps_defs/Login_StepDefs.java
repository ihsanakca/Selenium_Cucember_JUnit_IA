package com.krafttech.steps_defs;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Login_StepDefs {
   // WebDriver driver=Driver.get();
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
       // System.out.println("navigate to login page");
       Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user type in Selim's credentials")
    public void the_user_type_in_selim_s_credentials() {
      loginPage.loginMtd();
    }


    @When("The user type in valid credentials: {string} and {string}")
    public void theUserTypeInValidCredentialsAnd(String userEmail, String password) {
        loginPage.loginWithCredentialsMtd(userEmail, password);
    }


    @Then("The user type in valid credentials via map and verify success login")
    public void theUserTypeInValidCredentialsViaMapAndVerifySuccessLogin(Map<String,String> userInfo) {
        loginPage.loginWithCredentialsMtd(userInfo.get("userMail"),userInfo.get("pass"));
        Assert.assertEquals(userInfo.get("name"),dashboardPage.userName.getText());
    }

    @Then("The user type in valid credentials via list and verify success login")
    public void theUserTypeInValidCredentialsViaListAndVerifySuccessLogin(List<String> userInfo) {
        loginPage.loginWithCredentialsMtd(userInfo.get(0),userInfo.get(1));
        Assert.assertEquals(userInfo.get(2),dashboardPage.userName.getText());
    }
}
