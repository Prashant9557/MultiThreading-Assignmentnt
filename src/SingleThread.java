// This class demonstrates a single-threaded approach to processing orders

public class SingleThread {
	public static void main(String[] args){
        // Processing orders one after another in a sequential manner
		processOrder("order 1");
		processOrder("order 2");
		processOrder("order 3");
	}

    // Method to simulate order processing
	static void processOrder(String order){
		try{
			Thread.sleep(2000); // Simulate a delay of 2 seconds for each order
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage()); // Handle any interruption during sleep
		}
		System.out.println(order + "ready!");
	}
}
