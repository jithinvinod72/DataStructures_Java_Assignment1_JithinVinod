import java.util.Scanner;

public class ClueTree {

    static class Node {
        String clue;
        Node left, right;

        public Node(String clue) {
            this.clue = clue;
            left = right = null;
        }
    }

    private Node root;

    public ClueTree() {
        root = null;
    }

    public void insert(String clue) {
        root = insertRec(root, clue);
        System.out.println("Clue \"" + clue + "\" added to the tree.");
    }

    private Node insertRec(Node root, String clue) {
        if (root == null) {
            root = new Node(clue);
            return root;
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRec(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRec(root.right, clue);
        }
        return root;
    }

    public void inorderTraversal() {
        System.out.print("In-order traversal: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.clue + " ");
            inorderRec(root.right);
        }
    }

    public void preorderTraversal() {
        System.out.print("Pre-order traversal: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorderTraversal() {
        System.out.print("Post-order traversal: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    public boolean searchClue(String clue) {
        return searchRec(root, clue);
    }

    private boolean searchRec(Node root, String clue) {
        if (root == null) {
            return false;
        }
        if (clue.equals(root.clue)) {
            return true;
        }
        if (clue.compareTo(root.clue) < 0) {
            return searchRec(root.left, clue);
        } else {
            return searchRec(root.right, clue);
        }
    }

    public int countClues() {
        return countRec(root);
    }

    private int countRec(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + countRec(root.left) + countRec(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClueTree clueTree = new ClueTree();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nClue Tree Menu:");
            System.out.println("1. Insert a new clue");
            System.out.println("2. In-order traversal");
            System.out.println("3. Pre-order traversal");
            System.out.println("4. Post-order traversal");
            System.out.println("5. Search for a specific clue");
            System.out.println("6. Count total number of clues");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter clue to insert: ");
                    String clue = scanner.nextLine();
                    clueTree.insert(clue);
                    break;

                case 2:
                    clueTree.inorderTraversal();
                    break;

                case 3:
                    clueTree.preorderTraversal();
                    break;

                case 4:
                    clueTree.postorderTraversal();
                    break;

                case 5:
                    System.out.print("Enter the clue to search for: ");
                    String searchClue = scanner.nextLine();
                    if (clueTree.searchClue(searchClue)) {
                        System.out.println("Clue \"" + searchClue + "\" found in the tree.");
                    } else {
                        System.out.println("Clue \"" + searchClue + "\" not found in the tree.");
                    }
                    break;

                case 6:
                    int count = clueTree.countClues();
                    System.out.println("Total number of clues in the tree: " + count);
                    break;

                case 7:
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
