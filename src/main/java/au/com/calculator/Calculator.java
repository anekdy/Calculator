package au.com.calculator;

import java.math.BigDecimal;

import au.com.calculator.common.Constants;
import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.DoubleValueOperand;
import au.com.calculator.model.Expression;
import au.com.calculator.operation.AddOperator;
import au.com.calculator.operation.DivideOperator;
import au.com.calculator.operation.MultiplyOperator;
import au.com.calculator.operation.Operator;
import au.com.calculator.operation.SubtractOperator;
import au.com.calculator.utils.Parser;

/**
 * This class performs basic arithmetic operations based on the arguments passed.
 * Format supported is: operand operator operand
 * 
 * Limitations:
 * - does not follow MDAS rule
 * - does not support groupings e.g. (operand operator (operand operator operand))
 */
public class Calculator
{
    
    public static void main(String args[])
    {
        try
        {
            if (args.length != 1)
            {
                throw new ValidationException("Invalid Number of Arguments.");
            }

            Calculator calc = new Calculator();
            BigDecimal result = calc.execute(args[0]);
            
            System.out.println("Result: " + result);

        }
        catch (ValidationException ve)
        {
            System.out.println("Error :" + ve.getMessage());
        }
    }
  
    
    public BigDecimal execute(String input) throws ValidationException 
    {
        DoubleValueOperand<BigDecimal> operand = new DoubleValueOperand<BigDecimal>();
        Operator<DoubleValueOperand<BigDecimal>> operator = null;
        String curOperator = null;
        BigDecimal result = BigDecimal.ZERO;
        
        Expression<String> parsedExpression  = Parser.parseExpression(input);
        int exprSize = parsedExpression.getSize();
        int exprCtr = 0;
        
        for(String expr : parsedExpression.getExprItems())
        {
            exprCtr++;
            if(Constants.VALID_OPERATORS.contains(expr))
            {
                curOperator = expr;
            }
            else
            {
                if(curOperator != null)
                {   
                    
                    if(operand.getOperand1() == null) 
                    {
                        operand.setOperand1(result);
                    }
                    
                    operand.setOperand2(new BigDecimal(expr));
                    
                    //perform operation
                    switch(curOperator) 
                    {
                        case Constants.PLUS:
                            operator = new AddOperator();
                            break;
                        case Constants.MINUS:
                            operator = new SubtractOperator();
                            break;
                        case Constants.DIVIDE:
                            operator = new DivideOperator();
                            break;
                        case Constants.MULTIPLY:
                            operator = new MultiplyOperator();
                            break;
                    }
                    
                    operator.setValue(operand);
                    result = operator.performOperation();
                    
                    //if not last index create new instance
                    if(exprCtr < exprSize)
                    {
                        operand = new DoubleValueOperand<BigDecimal>();
                    }
                }
                else 
                {
                    operand.setOperand1(new BigDecimal(expr));
                }
            }

        }
        
        return result;
    }
    
    

}
