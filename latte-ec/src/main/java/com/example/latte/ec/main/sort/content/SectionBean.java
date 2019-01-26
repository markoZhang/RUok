package com.example.latte.ec.main.sort.content;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * @author Marko
 * @date 2019/1/25
 */

public class SectionBean extends SectionEntity<SectionContentItemEntity> {
    private boolean mIsMore = false;
    private int mSectionId = -1;
    public SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public SectionBean(SectionContentItemEntity sectionContentItemEntity) {
        super(sectionContentItemEntity);
    }

    public boolean getIsMore() {
        return mIsMore;
    }

    public void setIsMore(boolean isMore) {
        this.mIsMore = isMore;
    }

    public int getSectionId() {
        return mSectionId;
    }

    public void setSetionId(int sectionId) {
        this.mSectionId = sectionId;
    }
}
