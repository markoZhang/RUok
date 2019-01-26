package com.example.latte.ec.main.sort.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.ISuccess;

import java.util.List;

import butterknife.BindView;

/**
 * @author Marko
 * @date 2019/1/18
 */

public class ContentDelegate extends LatteDelegate {

    @BindView(R2.id.rv_list_content)
    RecyclerView mRecyclerView;

    private static final String ARG_CONTENT_ID = "CONTENT_ID";
    private int mContentId = -1;
    private List<SectionBean> mData = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            mContentId = args.getInt(ARG_CONTENT_ID);
        }
    }

    /**
     * 实例化自定义Fragment时，
     * 官方推荐Fragment.setArguments(Bundle bundle)这种方式来传递参数，而不推荐通过构造方法直接来传递参数
     * 因为setArguments可以保证传入的数据不丢失
     *
     * @param contentId
     * @return
     */
    public static ContentDelegate newInstance(int contentId) {
        final Bundle args = new Bundle();
        args.putInt(ARG_CONTENT_ID, contentId);
        final ContentDelegate contentDelegate = new ContentDelegate();
        contentDelegate.setArguments(args);
        return contentDelegate;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_list_content;
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        initData();
    }

    private void initData() {
        RestClient.builder()
                .url("sort_content_" + mContentId + ".json")
                .success(new ISuccess() {
                    @Override
                    public void success(String response) {
                        mData = new SectionDataConverter().convert(response);
                        final SectionAdapter adapter =
                                new SectionAdapter(R.layout.item_section_content,
                                        R.layout.item_section_header, mData);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .build()
                .get();
    }
}
