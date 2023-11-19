class Node {

    private String data;
    private Node next;
    private Node prev;

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

class DoubleLinkedList {

    private Node head;
    private Node tail;
    private Node cursor;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        cursor = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getCursor() {
        return cursor;
    }

    public void setCursor(Node cursor) {
        this.cursor = cursor;
    }

    public void add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            cursor = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }
    
    public void readNext() {
        if (cursor != null && cursor.getNext() != null) {
            // Move the cursor to the next node
            cursor = cursor.getNext();
            System.out.println(cursor.getData());
        } else {
            System.out.println("No next node available or cursor is null.");
        }
    }

    public void readPrevious() {
        if (cursor != null && cursor.getPrev() != null) {
            // Move the cursor to the previous node
            cursor = cursor.getPrev();
            System.out.println(cursor.getData());
        } else {
            System.out.println("No previous node available or cursor is null.");
        }
    }
    
    public void printCurrent() {
        if (cursor != null) {
            System.out.println(cursor.getData());
        } else {
            System.out.println("Cursor is null.");
        }
    }

    public void printNext() {
        if (cursor != null && cursor.getNext() != null) {
            System.out.println(cursor.getNext().getData());
        } else {
            System.out.println("No next node available or cursor is null.");
        }
    }

    public void printPrevious() {
        if (cursor != null && cursor.getPrev() != null) {
            System.out.println(cursor.getPrev().getData());
        } else {
            System.out.println("No previous node available or cursor is null.");
        }
    }

    public void listAll() {
        cursor = head;
        while (cursor != null) {
            System.out.println(cursor.getData());
            cursor = cursor.getNext();
        }
    }

    public void listAllBackward() {
        Node currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getPrev();
        }
    }
}

public class DDL {
    
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add("1");
        doubleLinkedList.add("2");
        doubleLinkedList.add("3");

        System.out.println("Print current node: ");
        doubleLinkedList.printCurrent();
        
        System.out.println("\nPrint next node: ");
        doubleLinkedList.printNext();
        
        System.out.println("\nPrint previous node: ");
        doubleLinkedList.printPrevious();
        
        System.out.println("\nMove to next node and print the node: ");
        doubleLinkedList.readNext();
        
        System.out.println("\nMove to next previous and print the node: ");
        doubleLinkedList.readPrevious();
        
        System.out.println("\nPrint Double Linked List from head:");
        doubleLinkedList.listAll();

        System.out.println("\nPrint Double Linked List from tail:");
        doubleLinkedList.listAllBackward();
    }
}
