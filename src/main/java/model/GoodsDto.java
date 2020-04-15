package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoodsDto {

//    private final int id;
//    private final String name;
//    private final double price;

    private int id;
    private String name;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    private GoodsDto(int id, String name, double price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }

//    private GoodsDto() {
//
//    }

//    public static class GoodsDtoBuilder {
//        private int id;
//        private String name;
//        private double price;
//
//
//        public GoodsDtoBuilder(int id) {
//            this.id = id;
//        }
//
////        public GoodsDtoBuilder setId(int id) {
////            this.id = id;
////
////            return this;
////        }
//
//        public GoodsDtoBuilder setName(String name) {
//            this.name = name;
//
//            return this;
//        }
//
//        public GoodsDtoBuilder setPrice(double price) {
//            this.price = price;
//
//            return this;
//        }
//
//        public GoodsDto build() {
//            return new GoodsDto(this.id, this.name, this.price);
//
//        }
//    }
}
