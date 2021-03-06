package emulation.main.product;

import java.io.IOException;

public abstract class BaseProduct {
    private int id;
    private String name; // brend and model
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public abstract void init() throws IOException;
    public abstract void changeProductAttribute() throws IOException;
}
