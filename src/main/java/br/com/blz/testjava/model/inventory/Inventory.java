package br.com.blz.testjava.model.inventory;

import br.com.blz.testjava.model.warehouse.Warehouse;
import br.com.blz.testjava.model.warehouse.WarehouseRequest;

import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private Integer quantity;
    private List<Warehouse> warehouses;

    public Inventory(Integer quantity, List<WarehouseRequest> warehouses) {
        this.quantity = quantity;
        this.warehouses = warehouses.stream().map(Warehouse::from).collect(Collectors.toList());
    }

    public static Inventory from(InventoryRequest input) {
        return new Inventory(0, input.getWarehouses());
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
