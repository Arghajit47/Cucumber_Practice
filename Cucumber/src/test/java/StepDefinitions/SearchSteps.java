package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import AmazonImplimentation.Product;
import AmazonImplimentation.Search;
import org.junit.jupiter.api.Assertions;


public class SearchSteps {
    Product product;
    Search search;
    @Given("I have a search field on Amazon Page")
    public void i_have_a_search_field_on_amazon_page() {
        System.out.println("Step 1 : I am on Search Page");
    }
    @When("I search for a product with name {string} and price {int}")
    public void i_search_for_a_product_with_name_and_price(String name, Integer price) {
        System.out.println("Step 2 : Search The product with name : " + name + " price : " + price);
        product = new Product(name, price);
    }
    @Then("Product with name {string} should be displayed")
    public void product_with_name_should_be_displayed(String name) {
        System.out.println("Step 3 : product " + name + " is displayed");

        search = new Search();
        String check = search.displayProduct(product);
        System.out.println("The search product is : " + check);
        Assertions.assertEquals(product.getName(), check);
    }
}
