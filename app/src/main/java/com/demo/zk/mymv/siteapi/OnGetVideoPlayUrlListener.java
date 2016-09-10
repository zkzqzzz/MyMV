package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCFailLog;
import com.demo.zk.mymv.model.SCVideo;

/**
 * Created by fire3 on 14-12-29.
 */
public interface OnGetVideoPlayUrlListener {
    void onGetVideoPlayUrlNormal(SCVideo v, String urlNormal);
    void onGetVideoPlayUrlHigh(SCVideo v, String urlHigh);
    void onGetVideoPlayUrlSuper(SCVideo v, String urlSuper);
    void onGetVideoPlayUrlFailed(SCFailLog reason);
}
