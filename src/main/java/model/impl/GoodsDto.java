package model.impl;

import model.BaseDto;
import model.marshaling.GoodsDtoAdapter;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Fedor Zholud
 *
 */

@XmlRootElement
@XmlJavaTypeAdapter(GoodsDtoAdapter.class)
public class GoodsDto extends BaseDto {

    private final long id;
    private final String name;
    private final double price;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    private GoodsDto() {
        this(0, null, 0);
    }

    private GoodsDto(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static GoodsDtoBuilder builder() {
        return new GoodsDtoBuilder();
    }

    public static class GoodsDtoBuilder {
        private long id;
        private String name;
        private double price;

        private GoodsDtoBuilder() {

        }

        public GoodsDtoBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public GoodsDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public GoodsDtoBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public GoodsDto build() {
            return new GoodsDto(this.id, this.name, this.price);
        }
    }
}