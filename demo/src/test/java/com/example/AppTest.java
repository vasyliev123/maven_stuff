package com.example;

// import static org.junit.Assert.assertTrue;
import org.testng.annotations.*;
// import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    // @Test
    // public void shouldAnswerWithTrue()
    // {
    //     assertTrue( true );
    // }

    // @Test
    // public void shouldAnswerWithFalse()
    // {
    //     assertTrue( false );
    // }
    @BeforeClass
    public void setUp() {
      // code that will be invoked when this test is instantiated
    }
    
    @Test(groups = { "fast" })
    public void aFastTest() {
      System.out.println("Fast test");
    }
    
    @Test(groups = { "slow" })
    public void aSlowTest() {
       System.out.println("Slow test");
    }
}
