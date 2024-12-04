package rs.edu.kg.asss.itemflow.model;

import java.util.Objects;

public class InventoryItem {
    private String name;
    private String location;
    private int quantity;
    public InventoryItem() {
    }
    public InventoryItem(String name, String location) {
        this(name, location, 0);
    }

    public InventoryItem(String name, String location, int quantity) {
        this.name = name;
        this.location = location;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem that = (InventoryItem) o;
        return quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, quantity);
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
