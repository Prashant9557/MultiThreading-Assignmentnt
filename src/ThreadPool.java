import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class KitchenStaff implements Runnable {
    private String order; // Holds the order name

    KitchenStaff(String order){
        this.order = order;
    }
    @Override //run is built in method
    public void run(){
        System.out.println("Cooking " + order);
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(order + " served!");
    }
}

public class ThreadPool {
    public static void main(String[] args){
        // Creating a thread pool with 4 threads
        ExecutorService executer = Executors.newFixedThreadPool(4);
        // Submitting 20 tasks (orders) to the thread pool for execution
        for(int i=0;i<100;i++){
            executer.execute(new KitchenStaff("Order " + i));
        }
        // Initiates an orderly shutdown after previously submitted tasks are executed
        executer.shutdown();
    }
}

