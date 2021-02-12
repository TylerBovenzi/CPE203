abstract class BinaryExpression implements Expression{
    private final Expression lft;
    private final Expression rht;
    private final String operator;


    public BinaryExpression(String operator, final Expression lft, final Expression rht)
    {
        this.lft = lft;
        this.rht = rht;
        this.operator = operator;
    }

    @Override
    public String toString()
    {
        return "(" + lft + " + " + rht + ")";
    }

    @Override
    public double evaluate(final Bindings bindings)
    {
        return _applyOperator(lft.evaluate(bindings),rht.evaluate(bindings));
    }

    public abstract double _applyOperator(double a, double b);
}
