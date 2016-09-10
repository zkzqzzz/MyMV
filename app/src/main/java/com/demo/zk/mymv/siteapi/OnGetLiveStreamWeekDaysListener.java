package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCFailLog;
import com.demo.zk.mymv.model.SCLiveStream;
import com.demo.zk.mymv.model.SCLiveStreams;

/**
 * Created by fire3 on 15-3-9.
 */
public interface OnGetLiveStreamWeekDaysListener {
    public void onGetLiveStreamWeekDaysSuccess(SCLiveStream stream);
    public void onGetLiveStreamWeekDaysFailed(SCFailLog failReason);
}
