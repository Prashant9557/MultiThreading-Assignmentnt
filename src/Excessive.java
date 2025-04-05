// KitchenStaff class represents a task that processes an order
class KitchenStaff implements Runnable {
    private String order;
//constructor to initialize order
    KitchenStaff(String order){
        this.order = order;
    }
    @Override //run is built in method of runnable interface
    public void run(){
        System.out.println("Cooking " + order);//Log start of cooking
        try{
            Thread.sleep(2000); //simulate time taken to cook the order
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage()); //Handle interruption
        }
        System.out.println(order + " served!");
    }
}

public class Excessive {
    public static void main(String[] args){
        // create and start 100 threads, one for each order
        for(int i=0;i<100;i++){
            new Thread(new KitchenStaff("order" + i)).start(); //start a new thread for each order
        }
    }
}

