package com.example.latte.ec.main.sort.content;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.latte.ec.R;

import java.util.List;

/**
 * @author Marko
 * @date 2019/1/25
 */

public class SectionAdapter extends BaseSectionQuickAdapter<SectionBean,BaseViewHolder> {

    private static RequestOptions requestOptions = RequestOptions
            .diskCacheStrategyOf(DiskCacheStrategy.ALL)
            .dontAnimate();

    public SectionAdapter(int layoutResId, int sectionHeadResId, List<SectionBean> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder holder, SectionBean item) {
        holder.setText(R.id.item_section_content_header,item.header);
        holder.setVisible(R.id.item_section_content_more,item.getIsMore());
        holder.addOnClickListener(R.id.item_section_content_more);
    }

    @Override
    protected void convert(BaseViewHolder holder, SectionBean item) {
        //item.t返回的是SectionContentItemEntity类型
        final String thumb = item.t.getGoodsThumb();
        final String name = item.t.getGoodsName();
        final int goodsId = item.t.getGoodsId();
        final SectionContentItemEntity entity = item.t;
        holder.setText(R.id.item_section_content_tv,name);
        final AppCompatImageView goodsImg =holder.getView(R.id.item_section_content_iv);
        Glide.with(mContext)
                .load(thumb)
                .into(goodsImg);
    }
}
