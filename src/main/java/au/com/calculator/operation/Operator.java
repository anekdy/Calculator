package au.com.calculator.operation;

import java.math.BigDecimal;

import au.com.calculator.exceptions.ValidationException;

public interface Operator<T>
{
    public BigDecimal performOperation() throws ValidationException;
    
    public BigDecimal getResult();
    
    public void setValue(T val);

}
    