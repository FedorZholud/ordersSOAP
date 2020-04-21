package model.marshaling;


import javax.xml.bind.annotation.XmlElement;

public class AdaptedGoodsDto {

    private int id;
    private String name;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }
}
