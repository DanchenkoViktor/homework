package ru.edu;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateExpressionsTests {

    private final ExpressionCalculator calculator = new ExpressionCalculator();

    @Test
    public void test() {

        double delta = 0.00001;

        Assert.assertEquals(5.0, calculator.calculate("2+3"), 0);
        Assert.assertEquals(14.0, calculator.calculate("2+3 * 4"), 0);
        Assert.assertEquals(2.5, calculator.calculate("1 + 3 / 2"), 0);
        Assert.assertEquals(2, calculator.calculate("(1 + 3) / (2 + 0)"), 0);
        Assert.assertEquals(0.0, calculator.calculate("1+2-3"), 0);
        Assert.assertEquals(20, calculator.calculate("((2) + 3) * 4"), 0);
        Assert.assertEquals(3.5, calculator.calculate("2 + 3 * sin(0.523599)"), delta);

        Assert.assertEquals(-0.404239, calculator.calculate("sin cos 2"), delta);
        Assert.assertEquals(0.95905, calculator.calculate("sin(1+ cos(2 + 3))"), delta);

        Assert.assertEquals(28, calculator.calculate("1 + КУБ(1+ 2)"), 0);
        Assert.assertEquals(512, calculator.calculate("КУБ(КУБ(2))"), 0);
        Assert.assertEquals(0.5, calculator.calculate("sin(3.14159/6)"), delta);

        Assert.assertEquals(91, calculator.calculate("КУБ(1) + КУБ2(1,2) * 10"), 0);
        Assert.assertEquals(36, calculator.calculate("1 + КУБ2(1+2,2 + 0* 1*2*3/1000) + КУБ(КУБ(КУБ(1+1-1-1)))"), 0);
    }

    @Test
    public void stressTest() {

        List<String> dataLhs = new ArrayList<>();
        List<String> dataRhs = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            dataLhs.add("КУБ(" + i + ")");
        }
        for (int i = 0; i < 10; ++i) {
            dataLhs.add("КУБ(" + 2 * i + ")");
        }
        for (int i = 0; i < 10; ++i) {
            dataRhs.add("КУБ2(" + i * 2 + " , " + i + ")");
        }

        String actualResult = String.join("+", dataLhs);
        String expectedResult = String.join("+", dataRhs);
        Assert.assertEquals(calculator.calculate(expectedResult), calculator.calculate(actualResult), 0);
        Assert.assertEquals(18225, calculator.calculate(expectedResult), 0);
    }
}
