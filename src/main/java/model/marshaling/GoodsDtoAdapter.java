package model.marshaling;

/**
 * @author Fedor Zholud
 *
 */

import model.impl.GoodsDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class GoodsDtoAdapter extends XmlAdapter<AdaptedGoodsDto, GoodsDto> {

    @Override
    public GoodsDto unmarshal(AdaptedGoodsDto adaptedGoodsDto) throws Exception {
        return GoodsDto.builder()
                .setId(adaptedGoodsDto.getId())
                .setName(adaptedGoodsDto.getName())
                .setPrice(adaptedGoodsDto.getPrice())
                .build();
    }

    @Override
    public AdaptedGoodsDto marshal(GoodsDto goodsDto) throws Exception {
        AdaptedGoodsDto adaptedGoodsDto = new AdaptedGoodsDto();
        adaptedGoodsDto.setId(goodsDto.getId());
        adaptedGoodsDto.setName(goodsDto.getName());
        adaptedGoodsDto.setPrice(goodsDto.getPrice());
        return adaptedGoodsDto;
    }
}
