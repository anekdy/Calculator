package au.com.calculator.utils;

import java.util.regex.Pattern;

import au.com.calculator.common.Constants;
import au.com.calculator.exceptions.ValidationException;
import au.com.calculator.model.Expression;

public class Parser
{
    private final static Pattern VALID_EXPRESSION = Pattern.compile("([0-9]+\\.?[0-9]*[\\+\\-\\*\\/])+([0-9]+\\.?[0-9]*)+");
 
    
    public static Expression<String> parseExpression(String input) throws ValidationException
    {
        if(input == null || input.trim().equals("")) 
        {
            throw new ValidationException("No input found.");
        }
        
        //Remove all spaces before validation
        input = input.replaceAll(" ", "");
        if (!VALID_EXPRESSION.matcher(input).matches())
        {
            throw new ValidationException("Invalid Expression.");
        }
        Expression<String> expressions = new Expression<String>();

        String tempStr;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) 
        {
            //TODO: To support other operators like LOG,SIN,et.al.
            //need to adjust the substring and index.
            tempStr = input.substring(i, i + 1);
            if(Constants.VALID_OPERATORS.contains(tempStr))
            {
                expressions.add(sb.toString());
                expressions.add(tempStr);
                sb = new StringBuilder();
            }
            else
            {
                //constructs the operands
                sb.append(tempStr);
            }
            
            if(i == input.length() - 1) 
            {
                expressions.add(sb.toString());
            }
        }

        return expressions; 
    }
}
