class KitchenStaff implements Runnable {
    private String order;
    // Constructor to initialize the order
    KitchenStaff(String order){
        this.order = order;
    }
    @Override //run is built in method
    public void run(){
        System.out.println("Cooking " + order); // Log that cooking has started
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(order + " served!"); // Log that order is ready
    }
}

public class Restaurant {
    public static void main(String[] args){
        // Creating threads for two chefs with different orders
          Thread chef1 = new Thread(new KitchenStaff("chole bhature"));
          Thread chef2 = new Thread(new KitchenStaff("French fries"));

          // Starting both chef threads to prepare orders in parallel
          chef1.start();
          chef2.start();
    }
}
