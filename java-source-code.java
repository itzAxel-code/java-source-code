package activity;

import java.util.Scanner;

public class Activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner input = new Scanner(System.in);

		        int option;
		        do {
		            System.out.println("\n=== Data Structures Menu ===");
		            System.out.println("1. Stack");
		            System.out.println("2. Queue");
		            System.out.println("3. Linked List");
		            System.out.println("4. Circular Linked List");
		            System.out.println("5. Exit");
		            System.out.print("Select an option: ");
		            option = input.nextInt();

		            switch (option) {
		                case 1 -> stackMenu(input);
		                case 2 -> queueMenu(input);
		                case 3 -> linkedListMenu(input);
		                case 4 -> circularListMenu(input);
		                case 5 -> System.out.println("Program terminated.");
		                default -> System.out.println("Invalid input, please try again.");
		            }
		        } while (option != 5);

		        input.close();
		    }

		    // ---------------- Stack ----------------
		    static class Stack {
		        private final int[] data;
		        private int topIndex;

		        public Stack(int capacity) {
		            data = new int[capacity];
		            topIndex = -1;
		        }

		        public void push(int value) {
		            if (topIndex == data.length - 1) {
		                System.out.println("Stack is full.");
		                return;
		            }
		            data[++topIndex] = value;
		            System.out.println(value + " added to stack.");
		        }

		        public void pop() {
		            if (topIndex == -1) {
		                System.out.println("Stack is empty.");
		                return;
		            }
		            System.out.println("Removed: " + data[topIndex--]);
		        }

		        public void show() {
		            if (topIndex == -1) {
		                System.out.println("Stack has no elements.");
		                return;
		            }
		            System.out.print("Stack: ");
		            for (int i = topIndex; i >= 0; i--) {
		                System.out.print(data[i] + " ");
		            }
		            System.out.println();
		        }
		    }

		    // ---------------- Queue ----------------
		    static class Queue {
		        private final int[] data;
		        private int front, rear, size;

		        public Queue(int capacity) {
		            data = new int[capacity];
		            front = 0;
		            rear = -1;
		            size = 0;
		        }

		        public void enqueue(int value) {
		            if (size == data.length) {
		                System.out.println("Queue is full.");
		                return;
		            }
		            rear = (rear + 1) % data.length;
		            data[rear] = value;
		            size++;
		            System.out.println(value + " inserted to queue.");
		        }

		        public void dequeue() {
		            if (size == 0) {
		                System.out.println("Queue is empty.");
		                return;
		            }
		            System.out.println("Removed: " + data[front]);
		            front = (front + 1) % data.length;
		            size--;
		        }

		        public void show() {
		            if (size == 0) {
		                System.out.println("Queue has no elements.");
		                return;
		            }
		            System.out.print("Queue: ");
		            for (int i = 0; i < size; i++) {
		                int idx = (front + i) % data.length;
		                System.out.print(data[idx] + " ");
		            }
		            System.out.println();
		        }
		    }

		    // ---------------- Linked List ----------------
		    static class LinkedList {
		        static class Node {
		            int val;
		            Node next;
		            Node(int v) { val = v; }
		        }
		        private Node head;

		        public void insertEnd(int v) {
		            Node n = new Node(v);
		            if (head == null) {
		                head = n;
		            } else {
		                Node cur = head;
		                while (cur.next != null) cur = cur.next;
		                cur.next = n;
		            }
		            System.out.println(v + " added to linked list.");
		        }

		        public void deleteFront() {
		            if (head == null) {
		                System.out.println("List is empty.");
		                return;
		            }
		            System.out.println("Deleted: " + head.val);
		            head = head.next;
		        }

		        public void show() {
		            if (head == null) {
		                System.out.println("Linked list is empty.");
		                return;
		            }
		            System.out.print("Linked List: ");
		            Node cur = head;
		            while (cur != null) {
		                System.out.print(cur.val + " ");
		                cur = cur.next;
		            }
		            System.out.println();
		        }
		    }

		    // ---------------- Circular Linked List ----------------
		    static class CircularLinkedList {
		        static class Node {
		            int val;
		            Node next;
		            Node(int v) { val = v; }
		        }
		        private Node tail;

		        public void insert(int v) {
		            Node n = new Node(v);
		            if (tail == null) {
		                tail = n;
		                n.next = n;
		            } else {
		                n.next = tail.next;
		                tail.next = n;
		                tail = n;
		            }
		            System.out.println(v + " added to circular list.");
		        }

		        public void delete() {
		            if (tail == null) {
		                System.out.println("Circular list is empty.");
		                return;
		            }
		            Node head = tail.next;
		            if (head == tail) {
		                System.out.println("Deleted: " + head.val);
		                tail = null;
		            } else {
		                System.out.println("Deleted: " + head.val);
		                tail.next = head.next;
		            }
		        }

		        public void show() {
		            if (tail == null) {
		                System.out.println("Circular list is empty.");
		                return;
		            }
		            System.out.print("Circular List: ");
		            Node cur = tail.next;
		            do {
		                System.out.print(cur.val + " ");
		                cur = cur.next;
		            } while (cur != tail.next);
		            System.out.println();
		        }
		    }

		    // ---------------- Menus ----------------
		    static void stackMenu(Scanner sc) {
		        Stack st = new Stack(50);
		        int ch;
		        do {
		            System.out.println("\n--- Stack Menu ---");
		            System.out.println("1. Push");
		            System.out.println("2. Pop");
		            System.out.println("3. Display");
		            System.out.println("4. Back");
		            System.out.print("Enter: ");
		            ch = sc.nextInt();
		            switch (ch) {
		                case 1 -> { System.out.print("Enter value: "); st.push(sc.nextInt()); }
		                case 2 -> st.pop();
		                case 3 -> st.show();
		                case 4 -> {}
		                default -> System.out.println("Invalid choice.");
		            }
		        } while (ch != 4);
		    }

		    static void queueMenu(Scanner sc) {
		        Queue q = new Queue(50);
		        int ch;
		        do {
		            System.out.println("\n--- Queue Menu ---");
		            System.out.println("1. Enqueue");
		            System.out.println("2. Dequeue");
		            System.out.println("3. Display");
		            System.out.println("4. Back");
		            System.out.print("Enter: ");
		            ch = sc.nextInt();
		            switch (ch) {
		                case 1 -> { System.out.print("Enter value: "); q.enqueue(sc.nextInt()); }
		                case 2 -> q.dequeue();
		                case 3 -> q.show();
		                case 4 -> {}
		                default -> System.out.println("Invalid choice.");
		            }
		        } while (ch != 4);
		    }

		    static void linkedListMenu(Scanner sc) {
		        LinkedList list = new LinkedList();
		        int ch;
		        do {
		            System.out.println("\n--- Linked List Menu ---");
		            System.out.println("1. Insert End");
		            System.out.println("2. Delete Front");
		            System.out.println("3. Display");
		            System.out.println("4. Back");
		            System.out.print("Enter: ");
		            ch = sc.nextInt();
		            switch (ch) {
		                case 1 -> { System.out.print("Enter value: "); list.insertEnd(sc.nextInt()); }
		                case 2 -> list.deleteFront();
		                case 3 -> list.show();
		                case 4 -> {}
		                default -> System.out.println("Invalid choice.");
		            }
		        } while (ch != 4);
		    }

		    static void circularListMenu(Scanner sc) {
		        CircularLinkedList cl = new CircularLinkedList();
		        int ch;
		        do {
		            System.out.println("\n--- Circular List Menu ---");
		            System.out.println("1. Insert");
		            System.out.println("2. Delete");
		            System.out.println("3. Display");
		            System.out.println("4. Back");
		            System.out.print("Enter: ");
		            ch = sc.nextInt();
		            switch (ch) {
		                case 1 -> { System.out.print("Enter value: "); cl.insert(sc.nextInt()); }
		                case 2 -> cl.delete();
		                case 3 -> cl.show();
		                case 4 -> {}
		                default -> System.out.println("Invalid choice.");
		            }
		        } while (ch != 4);
		    }
		
	}
