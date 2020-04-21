package service;


import entity.GoodsEntity;
import model.Goods;
import model.GoodsDto;
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

    private GoodsDto entityToDto(GoodsEntity goodsEntity) {
        return GoodsDto.builder()
                .setId(goodsEntity.getId())
                .setName(goodsEntity.getName())
                .setPrice(goodsEntity.getPrice())
                .build();
    }

    public List<Goods> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();
        //Logger.INFO(goodsEntities);
        List<Goods> goodsList = new ArrayList<Goods>();

        for (GoodsEntity goodsEntity: goodsEntities) {
            GoodsDto goodsDto = entityToDto(goodsEntity);
            Goods goods = new Goods();
            goods.setGoodsDto(goodsDto);

            goodsList.add(goods);
        }

        return goodsList;

//        return goodsEntities.stream()
//                .map(goodsEntity -> entityToDto(goodsEntity));
    }

    public Goods getGoodsById(int id) {
        GoodsEntity goodsEntity = goodsRepository.read(id);
        Goods goods = new Goods();
        goods.setGoodsDto(entityToDto(goodsEntity));

        return goods;
    }
}