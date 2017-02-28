package au.com.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import au.com.calculator.exceptions.ValidationException;

public class CalculatorTest
{
    
    @Test
    public void testPerformOperation() throws ValidationException
    {
        List<String> args = new ArrayList<String>();
        args.add("35 + 24");
        args.add("12.13 + 34.5");
        args.add("9 * 34");
        args.add("156 / 2");
        
        List<BigDecimal> results = new ArrayList<BigDecimal>();
        results.add(new BigDecimal("59"));
        results.add(new BigDecimal("46.63"));
        results.add(new BigDecimal("306"));
        results.add(new BigDecimal("78"));
        
        
        for (int i=0; i < args.size(); i++)
        {
            Calculator calculator = new Calculator();
            assertEquals(results.get(i), calculator.execute(args.get(i)));
        }
    }

}
