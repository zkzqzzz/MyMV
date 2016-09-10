package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCBanners;
import com.demo.zk.mymv.model.SCFailLog;

/**
 * Created by fire3 on 15-1-28.
 */
public interface OnGetBannersListener {
    public void onGetBannersSuccess(SCBanners banners);
    public void onGetBannersFailed(SCFailLog failReason);
}
