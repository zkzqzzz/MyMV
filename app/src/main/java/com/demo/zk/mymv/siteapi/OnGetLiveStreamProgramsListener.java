package com.demo.zk.mymv.siteapi;

import com.demo.zk.mymv.model.SCFailLog;
import com.demo.zk.mymv.model.SCLiveStream;
import com.demo.zk.mymv.model.SCLiveStreamPrograms;

/**
 * Created by fire3 on 15-3-11.
 */
public interface OnGetLiveStreamProgramsListener {
    void onGetLiveStreamProgramsSuccess(SCLiveStream stream, SCLiveStreamPrograms programs);
    void onGetLiveStreamProgramsFailed(SCFailLog reason);
}
