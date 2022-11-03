package goit.dev.hw5.model;

public class Order {
    private long id; // integer($int64)
    private long petId; // integer($int64)
    private int quantity;   //  integer($int32)
    private String shipDate;    // string($date-time)
    private String status;  // [ placed, approved, delivered ]
    private boolean complete;   //  boolean

    public Order(long id, long petId, int quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public Order(long petId, int quantity, String shipDate, String status, boolean complete) {
        this(-1, petId, quantity, shipDate, status, complete);
    }
}
