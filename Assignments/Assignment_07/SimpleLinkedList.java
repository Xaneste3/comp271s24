
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    /**Initializes the SimpleLinkedList */
    public SimpleLinkedList() {
    this.head = null;
    this.tail = null;
    }

    /** 
     * 
     * Adds string to the end of the SimpleLinkedList
     * 
     * @param e is the String I use
     * @return will be true if String is added to the end correctly
      */
    public boolean add(String e) {
        Node testNode = new Node(e);

        if(head == null) {
            head = testNode;
            tail = testNode;          
        }
        else {
            tail.setNext(testNode);
            tail = testNode;
        }
        return true;
    }

    /**
     * This method will remove the beginning element in SimpleLinkedList
     * 
     * @return the string that got removed at the beginning or returns null if there is nothing
     */
    public String remove() {
        String deadData = null;
        if (head != null) {
            deadData = head.toString();
            head = head.getNext();
            
            if(head == null) {
                tail = null;
            }
        }
        return deadData;  
    }
    
    public String pull() {
        return remove();
    } 

    /**
     * This method will push(add) a string to the beginning of the SimpleLinkedList
     * 
     * @param e will be the String that gets added
     * @return will be true if the String gets pushed correctly
     */
    public boolean push(String e) {
        Node testNode = new Node(e);
        if(head == null) {
            head = testNode;
            tail = testNode;
        }
        else {
            testNode.setNext(head);
            head = testNode;

        }
        return true;
    }

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

}// class SimpleLinkedList
