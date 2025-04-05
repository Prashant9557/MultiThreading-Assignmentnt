// Class representing a shared billing system

class Bill {
    static int amount = 0; // Shared variable to store the total bill amount

    // Synchronized method to ensure only one thread modifies 'amount' at a time
    static synchronized void addItem(int Price) {
        amount += Price; // Critical section: shared resource being updated
    }
}

public class WithSync {
    public static void main(String[] args) throws InterruptedException {
        // Thread waiter1 adds 100 items of $10 each to the bill
        Thread waiter1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Bill.addItem(10); // Accessing synchronized method
            }
        });

        // Thread waiter2 adds 150 items of $10 each to the bill

        Thread waiter2 = new Thread(() -> {
            for (int i = 0; i < 150; i++) {
                Bill.addItem(10); // Accessing synchronized method
            }
        });

        // Start both threads they will execute concurrently
        waiter1.start();
        waiter2.start();

         // Wait for both threads to complete execution
        waiter1.join();
        waiter2.join();

        // Output the final total bill (now consistent due to synchronization)
        System.out.println("Total bill : $" + Bill.amount);
    }
}
