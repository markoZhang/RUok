package com.example.latte.ec.main.sort.content;

/**
 * @author Marko
 * @date 2019/1/25
 */

public class SectionContentItemEntity {

    private int goodsId = 0;
    private String goodsName = null;
    //缩略图
    private String goodsThumb = null;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsThumb() {
        return goodsThumb;
    }

    public void setGoodsThumb(String goodsThumb) {
        this.goodsThumb = goodsThumb;
    }
}
