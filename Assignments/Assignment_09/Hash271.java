public class Hash271 {

    /** This is the default value foe load factor */
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    /** Default size for foundation array */
    private static final int DEFAULT_SIZE = 4;

    /** The actual load factor */
    private double loadFactor;

    /** The amount of nodes that will be displayed through the hash table */
    private int nodeCounter;

    /** Foundation array of node objects */
    Node[] foundation;

    /** Basic constructor */
    public Hash271(int size, double loadFactor) {
        this.foundation = new Node[size];
        this.loadFactor = loadFactor;
        this.nodeCounter = 0;
    } // basic constructor

    /** Default constructor */
    public Hash271() {
        this(DEFAULT_SIZE, DEFAULT_LOAD_FACTOR);
    } // default constructor

    /**
     * Map an integer number to one of the positions of the underlying array. This
     * will come handy we need to find the place to chain a node.
     * 
     * @param value int to map to one of the array positions
     * @return int with the integer division remainder between the input value and
     *         the length of the array
     */
    private int computeArrayPosition(int value) {
        return value % this.foundation.length;
    } // method computeArrayPosition

    /**
     * Chain a node to the underlying array
     * 
     * @param node Node to chain to the underlying array
     */
    public void put(Node node) {
        // Operate only is node is not null
        if (node != null) {
            // Use the node's hashcode to determine is position in
            // the underlying array
            int destination = computeArrayPosition(node.hashCode());
            // If the position in the array is occupied by another node,
            // place that node under the new node we wish to insert
            if (this.foundation[destination] != null) {
                node.setNext(this.foundation[destination]);
            }
            // Put the new node to the array position
            this.foundation[destination] = node;

            updateLoadFactor();
            nodeCounter++;

            /** This will be able to use the rehash method if
             * decided by put method
             */
            if (loadFactor >= loadFactor) {
                rehash();
            }

        }
    } // method put

    /**
     * Wrapper for put(Node). Accepts a string, creates a Node object and passes it
     * to the put(Node) method.
     * 
     * @param string String to create a node for, then chain that node to the
     *               underlying array.
     */
    public void put(String string) {
        if (string != null && string.length() > 0) {
            Node node = new Node(string);
            this.put(node);
        }
    } // method put

    /**
     * This method will update the loadFactor if need be
     * from the put method
     */
    private void updateLoadFactor() {
        this.loadFactor = (double) nodeCounter / this.foundation.length;
    }

    /**
     * This method is in place if the load factor goes over
     * the threshold that was decided. It will cause it to rehash
     * foundation array that was put in earlier
     * 
     * @param rehash will happen if load factor goes over threshold,
     *               changing the foundation array
     */
    private void rehash() {
        
    }

    /** String representation of this object */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.foundation.length; i++) {
            sb.append(String.format("[ %03d ]: ", i));
            Node current = this.foundation[i];
            while (current != null) {
                sb.append(String.format("<%s> ", current.toString()));
                current = current.getNext();
            }
            sb.append("\n");
        }
        return sb.toString();
    } // method toString

    /** Driver code */
    public static void main(String[] args) {
        Hash271 h = new Hash271();
        h.put(new Node("Java"));
        h.put(new Node("Python"));
        h.put(new Node("Lisp"));
        h.put(new Node("Fortran"));
        h.put(new Node("Prolog"));
        h.put(new Node("Cobol"));
        h.put(new Node("C++"));
        h.put(new Node("C"));
        h.put(new Node("C#"));
        System.out.println(h);
    }
}
