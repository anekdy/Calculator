package au.com.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Expression<T>
{
    private List<T> exprItems = new ArrayList<T>();

    public Expression()
    {

    }

    public Expression(List<T> exprItems)
    {
        this.exprItems = exprItems;
    }

    public void add(T value)
    {
        exprItems.add(value);
    }

    public T get(int index)
    {
        return exprItems.get(index);
    }

    public void remove(int index)
    {
        exprItems.remove(index);
    }

    public List<T> getExprItems()
    {
        return exprItems;
    }

    public int getSize()
    {
        return exprItems.size();
    }

    public void setExprItems(List<T> exprItems)
    {
        this.exprItems = exprItems;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (exprItems != null && exprItems.size() > 0)
        {
            for (T expr : exprItems)
            {
                sb.append(expr);
            }
        }

        return sb.toString();
    }
}
