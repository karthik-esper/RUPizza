package tests;
import com.rupizza.*;

import static com.rupizza.PizzaMaker.createPizza;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Junit test file for BuildYourOwnPizza price() method
 */
public class BuildYourOwnPizzaTest {
    /**
     * Test case #1: Number of toppings set to 2, which is below the minimum number of
     * required toppings
     */
    @org.junit.Test
    public void testTopsLessThan3() {
        Pizza test = createPizza("byop");
        //test.toppings = new ArrayList<Topping>(Topping.PI,Topping.PE);
    }

}
