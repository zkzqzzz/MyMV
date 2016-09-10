package com.demo.zk.mymv.model;

import com.demo.zk.mymv.R;
import com.demo.zk.mymv.MyApplication;

/**
 * Created by fire3 on 2014/12/26.
 */
public class SCSite {
    public static int UNKNOWN = -1;
    public static int SOHU = 3;
    public static int YOUKU = 0;
    public static int LETV = 1;
    public static int IQIYI = 2;
    private String mSiteName;

    private int mSiteID;

    public SCSite(int mSiteID) {
        this.mSiteID = mSiteID;
        if(mSiteID == SOHU)
            mSiteName = MyApplication.getResource().getString(R.string.site_sohu);
        if(mSiteID == YOUKU)
            mSiteName = MyApplication.getResource().getString(R.string.site_youku);
        if(mSiteID == IQIYI)
            mSiteName = MyApplication.getResource().getString(R.string.site_iqiyi);
        if(mSiteID == LETV)
            mSiteName = MyApplication.getResource().getString(R.string.site_letv);
        if(mSiteID == UNKNOWN)
            mSiteName = "Unknown";
    }

    public int getSiteID() {
        return mSiteID;
    }
    @Override
    public String toString() {
        return mSiteName;
    }

    public String getSiteName() {
        return mSiteName;
    }

    //增加网站时需要增加该count
    public static int count() {
        return 4;
    }
}
