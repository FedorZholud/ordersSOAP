package model.marshaling;

/**
 * @author Fedor Zholud
 *
 */

public class AdaptedGoodsDto {

    private int id;
    private String name;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
