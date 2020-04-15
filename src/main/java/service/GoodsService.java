package service;

import entity.GoodsEntity;
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

//    private GoodsDto entityToDto(GoodsEntity goodsEntity) {
//        return new GoodsDto.GoodsDtoBuilder(goodsEntity.getId())
//                .setName(goodsEntity.getName())
//                .setPrice(goodsEntity.getPrice())
//                .build();
//    }

    private GoodsDto entityToDto(GoodsEntity goodsEntity) {
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setId(goodsEntity.getId());
        goodsDto.setName(goodsEntity.getName());
        goodsDto.setPrice(goodsEntity.getPrice());

        return goodsDto;
    }

    public List<GoodsDto> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();
        List<GoodsDto> goodsDtoList = new ArrayList<GoodsDto>();

        for (GoodsEntity goodsEntity: goodsEntities) {
            GoodsDto goodsDto = entityToDto(goodsEntity);

            goodsDtoList.add(goodsDto);
        }

        return goodsDtoList;
    }

    public GoodsDto getGoodsById(int id) {
        GoodsEntity goodsEntity = goodsRepository.read(id);

        return entityToDto(goodsEntity);
    }
}