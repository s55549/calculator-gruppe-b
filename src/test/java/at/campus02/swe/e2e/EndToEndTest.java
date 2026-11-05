package at.campus02.swe.e2e;

import at.campus02.swe.Calculator;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EndToEndTest {

    @Test
    public void firstE2ETest() throws Exception {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        double result = parser.parse(new File("src/test/resources/test04.xml"));

        assertEquals(1, result, 0);
    }

    @Test
    public void secondE2ETest() throws Exception {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        double result = parser.parse(new File("src/test/resources/test05.xml"));

        assertEquals(2, result, 0);
    }

    @Test
    public void testSinZero() throws Exception {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        double result = parser.parse(new File("src/test/resources/sin-zero.xml"));

        assertEquals(0, result, 0);
    }

    @Test
    public void testCosZero() throws Exception {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        double result = parser.parse(new File("src/test/resources/cos-zero.xml"));

        assertEquals(1, result, 0);
    }

    @Test
    public void testDotProduct() throws Exception {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        double result = parser.parse(new File("src/test/resources/dotproduct.xml"));

        assertEquals(14, result, 0);
    }

    @Test
    public void testDotProductIssue() throws Exception {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        double result = parser.parse(new File("src/test/resources/dotproduct-issue.xml"));

        assertEquals(2, result, 0);

    }
}
