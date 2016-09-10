package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCAlbum;
import com.demo.zk.mymv.model.SCFailLog;
import com.demo.zk.mymv.model.SCVideos;

/**
 * Created by fire3 on 2014/12/26.
 */
public interface OnGetVideosListener {
    public void onGetVideosSuccess(SCVideos videos);
    public void onGetVideosFailed(SCFailLog failReason);
}
