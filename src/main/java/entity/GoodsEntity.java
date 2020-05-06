package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fedor Zholud
 *
 */

@Entity
@NamedQuery(name = "entity.GoodsEntity.findAll", query = "select g from GoodsEntity g")
@Table(name = "goods")
public class GoodsEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}