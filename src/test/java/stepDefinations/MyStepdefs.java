package stepDefinations;

import featureCode.registration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs extends registration {


    @Given("User generator to generate an user")
    public void user_generator_to_generate_an_user() {
    }
    @When("Hit the user generator {string} to get the user")
    public void hit_the_user_generator_to_get_the_user(String api) {
        getData(api);

    }
    @Then("use those user details to register on the {string}")
    public void use_those_user_details_to_register_on_the(String url) {
        navigeteToUrl(url);
        registerUser();
        implicitwaits(3000);
        verifyTheAccountCreation();

    }
    @Then("Purchase the product")
    public void purchase_the_product() throws InterruptedException {
        buyProduct();
    }
    @Then("Verify the purchase")
    public void verify_the_purchase() {
        validatePurchase();
        tearDown();
    }


}
