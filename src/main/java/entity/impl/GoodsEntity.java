package entity.impl;

import entity.JpaBaseEntity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Fedor Zholud
 *
 */

@Entity
@NamedQuery(name = "entity.impl.GoodsEntity.findAll", query = "select g from GoodsEntity g")
@Table(name = "goods")
public class GoodsEntity extends JpaBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public long getId() {
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