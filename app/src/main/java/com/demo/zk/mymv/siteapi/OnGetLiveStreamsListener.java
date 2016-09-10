package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCFailLog;
import com.demo.zk.mymv.model.SCLiveStreams;

/**
 * Created by fire3 on 15-3-9.
 */
public interface OnGetLiveStreamsListener {
    public void onGetLiveStreamsSuccess(SCLiveStreams streams);
    public void onGetLiveStreamsFailed(SCFailLog failReason);
}
