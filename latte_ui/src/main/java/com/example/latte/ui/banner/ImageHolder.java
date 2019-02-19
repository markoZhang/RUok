package com.example.latte.ui.banner;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.latte.R;
import com.example.latte.app.Latte;

/**
 * @author Marko
 * @date 2019/1/16
 */

public class ImageHolder extends Holder<String> {

    private AppCompatImageView mImageView;

    public ImageHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        mImageView = itemView.findViewById(R.id.banner_item_img);
    }

    @Override
    public void updateUI(String data) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .dontAnimate();
        Glide.with(Latte.getApplicationContext())
                .load(data)
                .apply(options)
                .into(mImageView);
    }
}
