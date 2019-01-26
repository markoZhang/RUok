package com.example.latte.ec.main.sort.content;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko
 * @date 2019/1/25
 */

public class SectionDataConverter {

    public final List<SectionBean> convert(String json) {
        final List<SectionBean> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON.parseObject(json).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final int sectionId = data.getInteger("id");
            final String sectionName = data.getString("section");
            //添加title
            final SectionBean sectionTitleBean = new SectionBean(true,sectionName);
            sectionTitleBean.setSetionId(sectionId);
            sectionTitleBean.setIsMore(true);
            dataList.add(sectionTitleBean);

            final JSONArray goodsArray = data.getJSONArray("goods");
            //商品内容循环
            final int goodsSize = goodsArray.size();
            for (int j = 0;j<goodsSize;j++){
                final JSONObject contentItem = goodsArray.getJSONObject(j);
                final int goodsId = contentItem.getInteger("goods_id");
                final String goodsThumb = contentItem.getString("goods_thumb");
                final String goodsName = contentItem.getString("goods_name");

                final SectionContentItemEntity sectionContentItemEntity = new SectionContentItemEntity();
                //获取内容
                sectionContentItemEntity.setGoodsId(goodsId);
                sectionContentItemEntity.setGoodsName(goodsName);
                sectionContentItemEntity.setGoodsThumb(goodsThumb);
                //添加内容
                dataList.add(new SectionBean(sectionContentItemEntity));
            }
            //商品内容循环结束
        }
        //section循环结束

        return dataList;
    }
}
