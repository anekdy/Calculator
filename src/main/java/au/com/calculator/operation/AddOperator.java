package au.com.calculator.operation;

import java.math.BigDecimal;

import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;

public class AddOperator implements Operator<DoubleValueOperand<BigDecimal>>
{
    private BigDecimal result = BigDecimal.ZERO;
    private DoubleValueOperand<BigDecimal> operand = null;
    
    public AddOperator()
    {
        
    }
    
    public AddOperator(DoubleValueOperand<BigDecimal> operand)
    {
      this.operand = operand;
    }
    
    @Override
    public BigDecimal performOperation() throws ValidationException
    {
        if (operand != null)
        {
           result = operand.getOperand1().add(operand.getOperand2());
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
