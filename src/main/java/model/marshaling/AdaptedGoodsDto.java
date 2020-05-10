package model.marshaling;

/**
 * @author Fedor Zholud
 *
 */

public class AdaptedGoodsDto {

    private long id;
    private String name;
    private double price;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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
