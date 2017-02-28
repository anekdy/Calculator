package au.com.calculator.model;


public class DoubleValueOperand<T>
{
    private T operand1;
    private T operand2;
    
    public DoubleValueOperand()
    {
        
    }

    public DoubleValueOperand(T operand1, T operand2)
    {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
    
    public T getOperand1()
    {
        return  operand1;
    } 
    public void setOperand1(T operand1)
    {
        this.operand1 = operand1;
    }
    public T getOperand2()
    {
        return operand2;
    }
    public void setOperand2(T operand2)
    {
        this.operand2 = operand2;
    }

}
