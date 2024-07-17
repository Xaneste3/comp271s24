
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    public static void main(String[] args) {
        SimpleLinkedList demoQueue = new SimpleLinkedList();
        SimpleLinkedList demoStack = new SimpleLinkedList();

        demoQueue.add("A");
        demoQueue.add("B");
        demoQueue.add("C");

        boolean queueWorks = demoQueue.remove().equals("A") &&
                demoQueue.remove().equals("B") &&
                demoQueue.remove().equals("C") &&
                demoQueue.remove() == null;

        demoStack.push("A");
        demoStack.push("B");
        demoStack.push("C");

        boolean stackWorks = demoStack.pull().equals("C") &&
                demoStack.pull().equals("B") &&
                demoStack.pull().equals("A") &&
                demoStack.pull() == null;

        System.out.println(queueWorks);
        System.out.println(stackWorks);
    }
    
    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    private int usage;

    public SimpleLinkedList() {
    this.head = null;
    this.tail = null;
    this.usage = 0;
    }

    public boolean add(String e) {
        Node testNode = new Node(e);

        if(head.equals(null)) {
            head = testNode;
            tail = testNode;          
        }
        else {
            tail.setNext(testNode);
            tail = testNode;
        }
        usage++;
        return true;
    }

    public String remove() {
        String deadData = null;
        if (head != null) {
            deadData = head.toString();
            head = head.getNext();
            
            if(head.equals(null)) {
                tail = null;
            }
            usage--;
        }
        return deadData;  
    }
    

}// class SimpleLinkedList
