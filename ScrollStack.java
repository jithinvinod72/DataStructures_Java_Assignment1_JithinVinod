import java.util.Scanner;
import java.util.Stack;

public class ScrollStack {
    private Stack<String> stackOfScrolls;

    
    public ScrollStack() {
        stackOfScrolls = new Stack<>();
    }

    public void pushScroll(String scrollTitle) {
        stackOfScrolls.push(scrollTitle);
        System.out.println("Scroll added: " + scrollTitle);
    }

    public String popScroll() {
        if (stackOfScrolls.isEmpty()) {
            System.out.println("No scrolls to remove. The stack is empty.");
            return null;
        }
        String removedScroll = stackOfScrolls.pop();
        System.out.println("Scroll removed: " + removedScroll);
        return removedScroll;
    }

    public String peekScroll() {
        if (stackOfScrolls.isEmpty()) {
            System.out.println("No scrolls to peek at. The stack is empty.");
            return null;
        }
        return stackOfScrolls.peek();
    }

    public boolean containsScroll(String scrollTitle) {
        return stackOfScrolls.contains(scrollTitle);
    }

    public static void main(String[] args) {
        ScrollStack ancientTexts = new ScrollStack();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display menu options
            System.out.println("\nScroll Stack Menu:");
            System.out.println("1. Add a new scroll");
            System.out.println("2. Remove the top scroll");
            System.out.println("3. Peek at the top scroll");
            System.out.println("4. Check if a scroll exists");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the scroll to add: ");
                    String newScroll = scanner.nextLine();
                    ancientTexts.pushScroll(newScroll);
                    break;

                case 2:
                    ancientTexts.popScroll();
                    break;

                case 3:
                    String topScroll = ancientTexts.peekScroll();
                    if (topScroll != null) {
                        System.out.println("The top scroll is: " + topScroll);
                    }
                    break;

                case 4:
                    System.out.print("Enter the title of the scroll to search for: ");
                    String searchScroll = scanner.nextLine();
                    if (ancientTexts.containsScroll(searchScroll)) {
                        System.out.println(searchScroll + " is in the stack.");
                    } else {
                        System.out.println(searchScroll + " is not in the stack.");
                    }
                    break;

                case 5:
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
