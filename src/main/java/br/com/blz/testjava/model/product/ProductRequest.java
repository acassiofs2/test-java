package br.com.blz.testjava.model.product;

import br.com.blz.testjava.model.inventory.InventoryRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest {
    @JsonProperty("sku")
    private Integer sku;

    @JsonProperty("name")
    private String name;

    @JsonProperty("inventory")
    private InventoryRequest inventory;

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

    public InventoryRequest getInventory() {
        return inventory;
    }

    public void setInventory(InventoryRequest inventory) {
        this.inventory = inventory;
    }
}
