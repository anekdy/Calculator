package au.com.calculator.operation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;

public class DivideOperator implements Operator<DoubleValueOperand<BigDecimal>>
{
    private BigDecimal result = BigDecimal.ZERO;
    private DoubleValueOperand<BigDecimal> operand = null;
    
    public DivideOperator()
    {
       
    }
    
    public DivideOperator(DoubleValueOperand<BigDecimal> operand)
    {
      this.operand = operand;
    }
    
    @Override
    public BigDecimal performOperation() throws ValidationException
    {
        if (operand != null)
        {
            if(BigDecimal.ZERO.equals(operand.getOperand2()))
            {
                throw new ValidationException("Division by Zero");
            }
            //Max of 9 decimals. 10th Decimal rounded half up 
            MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
            result = operand.getOperand1().divide(operand.getOperand2(),mc);
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
