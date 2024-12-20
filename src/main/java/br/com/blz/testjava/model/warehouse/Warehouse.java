package br.com.blz.testjava.model.warehouse;

public class Warehouse {
    private String locality;
    private Integer quantity;
    private WarehouseType type;

    public Warehouse(String locality, Integer quantity, WarehouseType type) {
        this.locality = locality;
        this.quantity = quantity;
        this.type = type;
    }

    public static Warehouse from(WarehouseRequest input) {
        return new Warehouse(input.getLocality(), input.getQuantity(), input.getType());
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public WarehouseType getType() {
        return type;
    }

    public void setType(WarehouseType type) {
        this.type = type;
    }
}
