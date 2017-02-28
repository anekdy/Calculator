package au.com.calculator.operation;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;

public class SubtractOperatorTest
{

    @Test
    public void testPerformOperation()
    {
        DoubleValueOperand<BigDecimal> operands = new DoubleValueOperand<BigDecimal>(new BigDecimal(56), 
                                                                                     new BigDecimal(145));
        SubtractOperator subtractOperator = new SubtractOperator(operands);
        
        try
        {
            assertEquals(new BigDecimal(-89), subtractOperator.performOperation());
        }
        catch (ValidationException e)
        {
            e.printStackTrace();
        }
    }
}
