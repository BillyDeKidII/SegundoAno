
/**
 * Write a description of class TempoExecucao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempoExecucao
{
   public static int soma3 (int a, int b , int c)
   {
     int res = a + b;
     res = res + c;
     return res;
   }
   
   public static int somaTodos (int[] vals)
   {
     int res = 0;
     for(int i = 0;i < vals.length; i++)
     {
       res = res + vals[i];   
     }
     return res;
   }
}
