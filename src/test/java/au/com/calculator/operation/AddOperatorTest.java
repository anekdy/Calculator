package au.com.calculator.operation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;

public class AddOperatorTest
{

    @Test
    public void testPerformOperation()
    {
        DoubleValueOperand<BigDecimal> operands = new DoubleValueOperand<BigDecimal>(new BigDecimal(5), 
                                                                                     new BigDecimal(7));
        AddOperator addOperator = new AddOperator(operands);
        
        try
        {
            assertEquals(new BigDecimal(12), addOperator.performOperation());
        }
        catch (ValidationException e)
        {
            e.printStackTrace();
        }
        
        
        
    }

}
