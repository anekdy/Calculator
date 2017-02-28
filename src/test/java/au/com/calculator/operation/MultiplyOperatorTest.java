package au.com.calculator.operation;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Test;

import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;

public class MultiplyOperatorTest
{
    @Test
    public void testPerformOperation()
    {
        DoubleValueOperand<BigDecimal> operands = new DoubleValueOperand<BigDecimal>(new BigDecimal(46.11), 
                                                                                     new BigDecimal(125.25));
        MultiplyOperator multiplyOperator = new MultiplyOperator(operands);
        
        try
        {
            MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
            BigDecimal value = new BigDecimal(5775.2775,mc);
            assertEquals(value, multiplyOperator.performOperation());
        }
        catch (ValidationException e)
        {
            e.printStackTrace();
        }
    }
}
