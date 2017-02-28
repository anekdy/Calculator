package au.com.calculator.common;

import java.util.Arrays;
import java.util.List;

public class Constants
{
    //Operators
    public static final String PLUS        = "+";
    
    public static final String MINUS       = "-";
    
    public static final String DIVIDE      = "/";
    
    public static final String MULTIPLY    = "*";
    
    
    private final static String[] OPERATORS = new String[] {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY
    };
    
    public static final List<String> VALID_OPERATORS;
    static
    {   
        VALID_OPERATORS = Arrays.asList(OPERATORS);
    }
}
