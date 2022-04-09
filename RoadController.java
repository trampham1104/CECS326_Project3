/**
 * RoadController.java
 *
 *
 */

import java.util.concurrent.Semaphore;


public class RoadController extends Thread{
   // Creating a road which 1 person crossing max
   static Semaphore road = new Semaphore(1);

   String name = "";
   String waiting = "";

   //need the change for the villagers
   RoadController(West_village Village) {
      this.name = Village.name;
      this.waiting = Village.action();
   }

   RoadController(East_village Village) {
      this.name = Village.name;
      this.waiting = Village.action();
   }

   public void run(){

      try {
         System.out.println(name + " : is trying to cross the road...");
         System.out.println("Is road available: " + road.availablePermits());


         road.acquire();

         //Critical Section
         try {
            System.out.println(name + " : can cross the road!");
            System.out.println(waiting);
            System.out.println("Is road available: " + road.availablePermits());

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
      RoadController East1 = new RoadController(west_villager);
      RoadController West1 = new RoadController(east_villager);
      RoadController East2 = new RoadController(west_villager);
      RoadController West2 = new RoadController(east_villager);

      East1.start();
      West1.start();
      East2.start();
      West2.start();
   }
}