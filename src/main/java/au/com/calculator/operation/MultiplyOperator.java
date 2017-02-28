package au.com.calculator.operation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;

public class MultiplyOperator implements Operator<DoubleValueOperand<BigDecimal>>
{
    private BigDecimal result = BigDecimal.ZERO;
    private DoubleValueOperand<BigDecimal> operand = null;
    
    public MultiplyOperator()
    {
       
    }
    
    public MultiplyOperator(DoubleValueOperand<BigDecimal> operand)
    {
      this.operand = operand;
    }
    
    @Override
    public BigDecimal performOperation() throws ValidationException
    {
        if (operand != null)
        {
           MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
           result = operand.getOperand1().multiply(operand.getOperand2(), mc);
        }
        
        return result;
    }
    
    @Override
    public void setValue(DoubleValueOperand<BigDecimal> operand)
    {
        this.operand = operand;
    }
    
    @Override
    public BigDecimal getResult()
    {
        return result;
    }
}
