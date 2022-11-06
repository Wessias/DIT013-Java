package ex3static.s2variable;

/*
     One of (the few) usages for static variables. Dubious...
 */
public class S2Order {

    public enum Status {
        RECEIVED,
        ACCEPTED,
        // Etc
    }

    private static int orderNumberCounter;  // Class variable shared by all instances
    private final int orderNumber;          // Instance variable
    private Status status;

    public S2Order() {                            // Constructor
        this.orderNumber = orderNumberCounter; // This order will get the current shared order number
        this.status = Status.RECEIVED;
        orderNumberCounter++;                  // Next order will get next number
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", status=" + status +
                '}';
    }
}
