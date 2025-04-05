// Class representing a shared resource for billing
class Bill {
    static int amount = 0; // Shared static variable to hold the total amount

// Method to add item price to the total amount (not synchronized, leads to race condition)
    static void addItem(int Price) {
        amount += Price;
    }
}

public class WithoutSync {
    public static void main(String[] args) throws InterruptedException {
        // Thread waiter1 adds 100 items of $10 each to the bill
        Thread waiter1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Bill.addItem(10); // Shared resource access
            }
        });

// Thread waiter2 adds 150 items of $10 each to the bill
        Thread waiter2 = new Thread(() -> {
            for (int i = 0; i < 150; i++) {
                Bill.addItem(10); // Shared resource access
            }
        });

        // Start both waiter threads (they run concurrently)

        waiter1.start();
        waiter2.start();

         // Wait for both threads to finish execution
        waiter1.join();
        waiter2.join();

        // Print the final bill amount (may be inconsistent due to lack of synchronization)

        System.out.println("Total bill : $" + Bill.amount);
    }
}
