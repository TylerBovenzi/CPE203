class SubtractExpression extends BinaryExpression
{
   public SubtractExpression(final Expression lft, final Expression rht)
   {
      super("-",lft,rht);
   }

   @Override
   public double _applyOperator(double a,double b) {
      return a-b;
   }
}

