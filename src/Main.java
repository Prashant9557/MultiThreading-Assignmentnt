import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n Restaurant Multithreading ");
            System.out.println("1. Why Multithreading? (Single vs. Multi-threaded Orders)");
            System.out.println("2. Create Threads with Runnable (Kitchen Chefs)");
            System.out.println("3. Race Condition in Bill Calculation (No Sync)");
            System.out.println("4. Fix Race Condition with Synchronized Keyword");
            System.out.println("5. Thread Pool vs excessive Threads (Efficiency)");
            System.out.println("6. Thread Pool vs excessive Threads (Efficiency)");
            System.out.println("7. Exit");
            System.out.print("Choose a method (1-7): ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    SingleThread.main(args); // Runs single vs. multi-threaded order processing
                    break;
                case 2:
                    MultiThreaded.main(args); // Creates threads using Runnable
                    break;
                case 3:
                    WithoutSync.main(args); // Demonstrates race condition
                    break;
                case 4:
                    WithSync.main(args); // Fixes with synchronized keyword
                    break;
                case 5:
                    Excessive.main(args); // Compares thread pool vs. 100 threads
                    break;
                case 6:
                    ThreadPool.main(args); // Compares thread pool vs. 100 threads
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);
        
        scanner.close();
    }
}
