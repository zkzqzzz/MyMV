package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCAlbum;
import com.demo.zk.mymv.model.SCFailLog;

/**
 * Created by fire3 on 2014/12/27.
 */
public interface OnGetAlbumDescListener {
    public void onGetAlbumDescSuccess(SCAlbum album);
    public void onGetAlbumDescFailed(SCFailLog failReason);
}
