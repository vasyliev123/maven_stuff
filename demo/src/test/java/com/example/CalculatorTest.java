package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    
    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        Assert.assertEquals(result, 5);
    }
    
    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 2);
        Assert.assertEquals(result, 3);
    }
    
    @Test
    public void testMultiply() {
        int result = calculator.multiply(4, 3);
        Assert.assertEquals(result, 12);
    }
    
    @Test
    public void testDivide() {
        int result = calculator.divide(10, 2);
        Assert.assertEquals(result, 5);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
