/**
 * RoadController.java
 *
 *
 */

import java.util.concurrent.Semaphore;


public class RoadController{  
   // Creating a road which 1 person crossing max
   static Semaphore road = new Semaphore(1);
   String name = "";

   RoadController(East_village east){
      this.name = "East Villager";
   }

   RoadController(West_village west){
      this.name = "West Villager";
   }

   public void run(){

      try {
         System.out.println(name + " : is trying to cross the road...");
         System.out.println("Is road available: " + road.availablePermits());

         road.acquire();
         System.out.println(name + " : can cross the road!");

         try {
            System.out.println(name + " : is crossing the road");

            //sleep for 1 seconds as in walking
            Thread.sleep(1000);

         
      } finally {

         //Realeasing after successful crossing the road
         System.out.println(name + " : finish crossing the road...");
         road.release();
         System.out.println("Is road available: " + road.availablePermits());
        }

      } catch (Exception e){
         e.printStackTrace();
        }
      }

   
   public static void main(String[] a){
      System.out.println("Is road available: " + road.availablePermits());

      // Create villager
      East_village east_villager = new East_village("East Villager");
      West_village west_villager = new West_village("West Villager");


      //RoadController t1 = new RoadController(east_villager);
      east_villager.start();
      west_villager.start();
   }


}
