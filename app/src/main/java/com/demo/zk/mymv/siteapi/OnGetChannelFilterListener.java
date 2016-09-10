package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCAlbums;
import com.demo.zk.mymv.model.SCChannelFilter;
import com.demo.zk.mymv.model.SCFailLog;

/**
 * Created by fire3 on 2014/12/26.
 */
public interface OnGetChannelFilterListener {
    public void onGetChannelFilterSuccess(SCChannelFilter filter);
    public void onGetChannelFilterFailed(SCFailLog failReason);
}
