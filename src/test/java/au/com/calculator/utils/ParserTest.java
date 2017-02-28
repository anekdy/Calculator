package au.com.calculator.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import au.com.calculator.exceptions.ValidationException;

public class ParserTest
{
    
    @Test
    public void testPerformOperation() throws ValidationException
    {
        ArrayList<String> inputLists = new ArrayList<String>();
        inputLists.add("13.34 + 789.290"); // multiple digits with dot
        inputLists.add("1 * 3"); //1 digit test
        
        ArrayList<String> outputList1 = new ArrayList<String>();
        outputList1.add("13.34");
        outputList1.add("+");
        outputList1.add("789.290");
        
        ArrayList<String> outputList2 = new ArrayList<String>();
        outputList2.add("1");
        outputList2.add("*");
        outputList2.add("3");
        
        
        ArrayList<ArrayList<String>> outputLists = new ArrayList<ArrayList<String>>();
        outputLists.add(outputList1);
        outputLists.add(outputList2);
                
        for (int i=0; i< inputLists.size(); i++)
        {
            assertEquals(outputLists.get(i), Parser.parseExpression(inputLists.get(i)).getExprItems());
        }
    }

}
