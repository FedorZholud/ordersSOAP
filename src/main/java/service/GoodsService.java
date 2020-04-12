package service;

import entity.GoodsEntity;
import model.Goods;
import repository.GoodsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GoodsService {

    int id;
    String name;
    double price;

    @EJB
    GoodsRepository goodsRepository;
//    @EJB
//    GoodsRepositoryImpl goodsRepository;

    public String writeSomething(int id) {
        GoodsEntity goods = goodsRepository.read(id);

        this.id = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();

        String string = "Goods: id-" + this.id + " name-" + this.name + " price-" + this.price;

        return string;
    }

    public String writeSomethingNew() {
        List<GoodsEntity> goods = goodsRepository.findAll();

        String string = "";

        for (int i = 0; i < goods.size(); i++) {
            this.id = goods.get(i).getId();
            this.name = goods.get(i).getName();
            this.price = goods.get(i).getPrice();

            string += "Goods: id-" + this.id + " name-" + this.name + " price-" + this.price;

            if (i < goods.size() - 1) {
                string += "\n";
            }
        }

        return string;
    }

    public List<Goods> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();
        List<Goods> goodsList = new ArrayList<Goods>();

        for (int i = 0; i < goodsEntities.size(); i++) {
            this.id = goodsEntities.get(i).getId();
            this.name = goodsEntities.get(i).getName();
            this.price = goodsEntities.get(i).getPrice();

            Goods goods = new Goods();
            goods.setId(this.id);
            goods.setName(this.name);
            goods.setPrice(this.price);

            goodsList.add(goods);
        }

        return goodsList;
    }

    public Goods getGoodsById(int id) {
        GoodsEntity goodsEntity = goodsRepository.read(id);
        this.id = goodsEntity.getId();
        this.name = goodsEntity.getName();
        this.price = goodsEntity.getPrice();

        Goods goods = new Goods();
        goods.setId(this.id);
        goods.setName(this.name);
        goods.setPrice(this.price);

        return goods;
    }
}