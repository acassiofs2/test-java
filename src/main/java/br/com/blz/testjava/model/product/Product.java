package br.com.blz.testjava.model.product;

import br.com.blz.testjava.model.inventory.Inventory;

import java.util.Objects;

public class Product {
    private Integer sku;
    private String name;
    private Inventory inventory;
    private Boolean isMarketable;

    public Product() {}

    public Product(Integer sku, String name) {
        this.sku = sku;
        this.name = name;
        this.isMarketable = false;
    }

    public static Product from(ProductRequest request) {
        if (request == null) return null;
        return new Product(request.getSku(), request.getName());
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Boolean getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(Boolean isMarketable) {
        this.isMarketable = isMarketable;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getSku(), product.getSku());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSku());
    }
}
