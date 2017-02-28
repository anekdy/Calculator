package au.com.calculator.model;

/**
 * Future support for operators that accepts single
 * operand. Eg. Log, Sin, Cos, Tan, et. al. 
 */
public class SingleValueOperand<T>
{
    private T operand;
    
    public SingleValueOperand()
    {
        
    }

    public SingleValueOperand(T operand1)
    {
        this.operand = operand1;
    }
    
    public T getOperand1()
    {
        return  operand;
    } 
    public void setOperand1(T operand1)
    {
        this.operand = operand1;
    }
}
