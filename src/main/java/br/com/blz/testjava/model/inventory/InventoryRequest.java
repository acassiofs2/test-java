package br.com.blz.testjava.model.inventory;

import br.com.blz.testjava.model.warehouse.WarehouseRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryRequest {

    @JsonProperty("warehouses")
    private List<WarehouseRequest> warehouses;

    public List<WarehouseRequest> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehouseRequest> warehouses) {
        this.warehouses = warehouses;
    }
}
