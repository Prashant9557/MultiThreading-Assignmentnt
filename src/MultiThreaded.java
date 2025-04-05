// MultiThreaded class demonstrates handling multiple orders in parallel using threads
public class MultiThreaded {
	public static void main(String[] args){
        // Creating and starting a new thread for "order 1"
		new Thread(() -> processOrder("order 1")).start();
		new Thread(() -> processOrder("Order 2")).start();
		new Thread(() -> processOrder("Order 3")).start();
	}

    
    // Method to simulate processing an order
	static void processOrder(String order){
		try{
			Thread.sleep(2000); // Simulate time taken to prepare the order (2 seconds)
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		System.out.println(order + " ready!");
        
    }
   
}

