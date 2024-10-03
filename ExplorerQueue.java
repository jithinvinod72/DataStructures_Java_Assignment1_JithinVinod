import java.util.Scanner;

public class ExplorerQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("The queue is full. No more explorers can be added.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = explorer;
        size++;
        System.out.println("Explorer " + explorer + " added to the queue.");
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorers to dequeue.");
            return null;
        }
        String explorer = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Explorer " + explorer + " has entered the temple.");
        return explorer;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorers in line.");
            return null;
        }
        return queue[front];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the explorer queue: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); 

        ExplorerQueue explorerQueue = new ExplorerQueue(capacity);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nExplorer Queue Menu:");
            System.out.println("1. Add a new explorer to the queue");
            System.out.println("2. Dequeue an explorer (enter the temple)");
            System.out.println("3. Display the next explorer in line");
            System.out.println("4. Check if the queue is full");
            System.out.println("5. Check if the queue is empty");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the explorer: ");
                    String explorer = scanner.nextLine();
                    explorerQueue.enqueue(explorer);
                    break;

                case 2:
                    explorerQueue.dequeue();
                    break;

                case 3:
                    String nextExplorer = explorerQueue.peek();
                    if (nextExplorer != null) {
                        System.out.println("The next explorer in line is: " + nextExplorer);
                    }
                    break;

                case 4:
                    if (explorerQueue.isFull()) {
                        System.out.println("The queue is full.");
                    } else {
                        System.out.println("The queue is not full.");
                    }
                    break;

                case 5:
                    if (explorerQueue.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("The queue is not empty.");
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
