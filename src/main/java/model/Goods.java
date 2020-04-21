package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Goods {

    private GoodsDto goodsDto;

    public void setGoodsDto(GoodsDto goodsDto) {
        this.goodsDto = goodsDto;
    }

    public GoodsDto getGoodsDto() {
        return goodsDto;
    }
}
