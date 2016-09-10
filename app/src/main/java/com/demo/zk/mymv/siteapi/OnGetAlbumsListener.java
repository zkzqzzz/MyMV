package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCAlbum;
import com.demo.zk.mymv.model.SCAlbums;
import com.demo.zk.mymv.model.SCFailLog;

import java.util.ArrayList;

/**
 * Created by fire3 on 2014/12/26.
 */
public interface OnGetAlbumsListener {
    public void onGetAlbumsSuccess(SCAlbums albums);
    public void onGetAlbumsFailed(SCFailLog failReason);
}
