package au.com.calculator.operation;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;

public class DivideOperatorTest
{

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testPerformOperation()
    {
        DoubleValueOperand<BigDecimal> operand = new DoubleValueOperand<BigDecimal>(new BigDecimal(12),
                new BigDecimal(4.5));
        DivideOperator divideOperator = new DivideOperator(operand);

        try
        {
            MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
            BigDecimal value = new BigDecimal(2.666666667, mc);
            assertEquals(value, divideOperator.performOperation());
        }
        catch (ValidationException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testPerformOperationWithZeroOperand()
    {
        DoubleValueOperand<BigDecimal> operand = new DoubleValueOperand<BigDecimal>(new BigDecimal(12),
                BigDecimal.ZERO);
        DivideOperator divideOperator = new DivideOperator(operand);

        try
        {
            divideOperator.performOperation();
        }
        catch (ValidationException e)
        {
            assertEquals("Division by Zero", e.getMessage());
        }
    }
}
