class AddExpression extends BinaryExpression
{

   public AddExpression(final Expression lft, final Expression rht)
   {
      super("+",lft,rht);
   }

   @Override
   public double _applyOperator(double a,double b) {
      return a+b;
   }
}
