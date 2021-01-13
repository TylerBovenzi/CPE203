class BetterLoop
{
   public static boolean contains(int [] values, int v) {
      for (int val : values) if (val == v) return true;
      return false;
   }
}
