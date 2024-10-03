Name : Jithin Vinod 
ID : C0914450 
Group : 2


Here’s a simplified version of your descriptions:

1. **Array Artifact**:
I built a class called `ArtifactVault` that stores artifacts in a fixed-size array. It lets you add artifacts to the first available spot, remove artifacts by setting their position to `null`, and search for artifacts in two ways: linear search and binary search. For binary search, I made sure to filter out `null` entries before sorting. The program has a menu that lets users easily add, remove, search, or display the artifacts.

2. **Linked List Labyrinth**:
For this task, I created a class called `LabyrinthPath` using a singly linked list to track locations visited in a labyrinth. You can add new locations, remove the last one visited, and check for loops or traps using Floyd’s cycle detection algorithm. The class also has a feature to print the full path from the start to the current location.

3. **Stack of Ancient Texts**:
I implemented a `ScrollStack` class to manage ancient scrolls using a stack (Last In, First Out). You can add a scroll to the top, remove the top scroll, view the top scroll without removing it, and search for a particular scroll. The stack grows as you add more scrolls and follows typical stack operations.

4. **Queue of Explorers**:
I created an `ExplorerQueue` class using a circular queue to manage explorers waiting to enter a temple. Explorers are added at the end and removed from the front, and the queue wraps around when it reaches the end. It allows you to check if the queue is full or empty and view the next explorer without removing them.

5. **Binary Tree of Clues**:
I built a `ClueTree` class that organizes clues using a binary search tree. You can insert new clues, search for clues, and traverse the tree in different ways (in-order, pre-order, post-order). There’s also a function to count the total number of clues. The binary tree structure makes searching and inserting clues efficient.

All five programs use a simple menu system, making them easy to navigate and use.