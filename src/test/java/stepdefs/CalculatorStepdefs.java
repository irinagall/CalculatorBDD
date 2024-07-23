package stepdefs;

import idg.Calculator;
import idg.DivideByZeroException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class CalculatorStepdefs {
    private Calculator calculator;
    private Integer actual;
    private Exception thrownException;

    @Given("I have a calculator")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }
    @And("I enter {int} and {int} into the calculator")
    public void iEnterAndIntoTheCalculator(int num1, int num2) {
        calculator.setNum1(num1);
        calculator.setNum2(num2);

    }


    @When("I press add")
    public void iPressAdd() {
        actual = calculator.add();
    }

    @When("I press subtract")
    public void iPressSubtract() {
        actual = calculator.subtract();
    }

    @When("I press multiply")
    public void iPressMultiply() {
        actual = calculator.multiply();
    }

    @When("I press divide")
    public void iPressDivide() {
        try {
            actual = calculator.divide();
        } catch (DivideByZeroException e) {
            thrownException = e;
        }
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer expected) {
        Assertions.assertEquals(expected, actual);
    }


    @Then("a DivideByZeroException should be thrown")
    public void aDivideByZeroExceptionShouldBeThrown() {
        Assertions.assertNotNull(thrownException);
        Assertions.assertTrue(thrownException instanceof DivideByZeroException);
    }

    @And("the exception should have the message {string}")
    public void theExceptionShouldHaveTheMessage(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, thrownException.getMessage());
    }

    @And("I enter the numbers below to a list")
    public void iEnterTheNumbersBelowToAList(DataTable dataTable) {
        List<Integer> numbers = dataTable.asList(Integer.class);
        calculator.setNumbers(numbers);
    }

    @When("I iterate through the list to add all the even numbers")
    public void iIterateThroughTheListToAddAllTheEvenNumbers() {
        actual = calculator.sumEvenNumbers();
    }

}
