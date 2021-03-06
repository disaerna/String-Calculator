package is.ru.stringCalculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.add(""));
    }
    @Test
    public void testOneNumber(){
        assertEquals(1, Calculator.add("1"));
    }
    @Test
    public void testTwoNumbers(){
        assertEquals(3, Calculator.add("1,2"));
    }
    @Test
    public void testMultipleNumbers(){
        assertEquals(6, Calculator.add("1,2,3"));
    }
    @Test
    public void testNewLine(){
        assertEquals(6, Calculator.add("1\n2,3"));
    }
    @Test
    public void testNegativeNumbers(){
        try{
            Calculator.add("-3,5\n2,-5");
            fail("testNegativeNumbers failed");            
        }
        catch(IllegalArgumentException e){
            assertEquals("Negatives not allowed: -3,-5", e.getMessage());
        }
    }
    @Test
    public void testOneNegativeNumber(){
        try{
            Calculator.add("-2");
            fail("testOneNegativeNumber failed");
        }
        catch(IllegalArgumentException e){
            assertEquals("Negatives not allowed: -2", e.getMessage());
        }
    }
    @Test
    public void testNumbersLargerThan1000Ignored(){
        assertEquals(2, Calculator.add("1001,2"));
    }
    @Test
    public void testOneNumberLargerThan1000(){
        try{
            Calculator.add("1001");
            fail("testOneNumberLargerThan1000 failed");
        }
        catch(IllegalArgumentException e){
            assertEquals("Numbers bigger than 1000 are ignored", e.getMessage());
        }
    }
    @Test
    public void testDifferentDelimeter(){
        assertEquals(3, Calculator.add("//;\n1;2"));
    }
}