
import java.util.Random;

public class East_village extends Thread 
{
   int bound = 3;
   String name ="";

   East_village(String name) {
      this.name = name;
   }

   public String action(){
      Random rand = new Random();
      String action = "";
      int int_random = rand.nextInt(bound);

      switch (int_random){
         case 0:
            action = name + " is eating a double double";

         case 1:
            action = name + " is eating some curly fries";

         case 2:
            action = name + " is drinking their milkshake";
      }

      return action;
   }
   
}
