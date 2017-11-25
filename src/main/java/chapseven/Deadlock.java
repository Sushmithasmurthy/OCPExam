package chapseven;

import chapone.staticaccess.my.sports.Football;

import java.util.concurrent.*;


/**
 * Created by SushmithaShamanth on 9/17/17.
 */
public class Deadlock {
    public void eatAndDrink(Food food,Water water){
        synchronized (food){
            System.out.println("Got Food");
            move();
            synchronized (water){
                System.out.println("Got water");
            }
        }
    }

    public void drinkAndEat(Food food, Water water){
        synchronized (water){
            System.out.println("Got Water!");
            move();
            synchronized (food){
                System.out.println("Got food");
            }
        }
    }

    public void move(){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            //HAndle exception
            e.printStackTrace();
        }
    }

    public static void main(String... args){
        //Create participants and resources
        Deadlock deadlockFoxy = new Deadlock();
        Deadlock deadlockTails = new Deadlock();
        Food food = new Food();
        Water water = new Water();
        ExecutorService service = null;

        try{
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> deadlockFoxy.eatAndDrink(food,water));
            service.submit(() -> deadlockTails.drinkAndEat(food,water));
        }finally {
            if(service!=null)
                service.shutdown();
        }
    }
}
