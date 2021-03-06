package com.demo.zk.mymv;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.demo.zk.mymv.controller.upnp.IUpnpServiceController;
import com.demo.zk.mymv.model.upnp.IFactory;
import com.demo.zk.mymv.utils.M3UServer;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Cache;
import java.io.File;
import java.io.IOException;
import android.support.multidex.MultiDex;

import cn.vbyte.p2p.VbyteP2PModule;

/**
 * ClassName:com.demo.zk.mymv
 * Author: zk<p>.
 * time: 2016/9/10 9:47.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class MyApplication extends Application {
    private static Context mContext;
    private static OkHttpClient mHttpClient;
    private static Gson mGson;
    private static String FLV_API = "http://api.flvxz.com/token/9058e263a95c0dfbc1bdac83f4132822";
    private static final long SIZE_OF_HTTP_CACHE = 10 * 1024 * 1024;

    public static IUpnpServiceController upnpServiceController = null;
    public static IFactory factory = null;
    public static M3UServer m3userver;


    // 初始化VbyteP2PModule的相关变量，这是Android sample的样例
    final String APP_ID = "57d3c04bdc82e0f10e4502a4";
    final String APP_KEY = "8i10Evtd3uXtSCsL";
    final String APP_SECRET = "0PwFrv4OT77TNDRyjRyu5dkDNQEdmQ8I";


    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mHttpClient = new OkHttpClient();
        mGson = new Gson();
        initHttpClient(mHttpClient,mContext);
        // Use cling factory
        if (factory == null)
            factory = new com.demo.zk.mymv.controller.cling.Factory();

        // Upnp service
        if (upnpServiceController == null)
            upnpServiceController = factory.createUpnpServiceController(this);

        try {
            // 初始化P2P模块
           VbyteP2PModule.create(this.getBaseContext(), APP_ID, APP_KEY, APP_SECRET);

            m3userver = new M3UServer();
            m3userver.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    private void initHttpClient(OkHttpClient client, Context context) {

        File httpCacheDirectory = context.getCacheDir();
        Cache httpResponseCache = null;
        try {
            httpResponseCache = new Cache(httpCacheDirectory, SIZE_OF_HTTP_CACHE);
        } catch (IOException e) {
            Log.e("Retrofit", "Could not create http cache", e);
        }
        client.setCache(httpResponseCache);
    }

    public static Resources getResource() {
        return mContext.getResources();
    }


    public static Context getContext() {
        return mContext;
    }

    public static OkHttpClient getHttpClient() {
        return mHttpClient;
    }

    public static Gson getGson() {
        return mGson;
    }

    public static String getIMEI()
    {
        try
        {
            TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
            String IMEI_Number = telephonyManager.getDeviceId();
            if ((IMEI_Number != null) && (IMEI_Number.length() > 0))
            {
                return IMEI_Number;
            }
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return null;
    }


    public static boolean checkPermission(Context paramContext, String paramString)
    {
        return paramContext.checkCallingOrSelfPermission(paramString) == PackageManager.PERMISSION_GRANTED;
    }

    public static String getMacAddress()
    {
        try
        {
            WifiManager localWifiManager = (WifiManager)mContext.getSystemService(Context.WIFI_SERVICE);
            if (checkPermission(mContext, "android.permission.ACCESS_WIFI_STATE")) {
                return localWifiManager.getConnectionInfo().getMacAddress();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "00:11:22:33:44:55";
    }


    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isNetworkMobile() {

        ConnectivityManager conMan = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(conMan.getNetworkInfo(0) != null) {
            final NetworkInfo.State mobile = conMan.getNetworkInfo(0).getState();

            if (mobile == NetworkInfo.State.CONNECTED || mobile == NetworkInfo.State.CONNECTING)
                return true;
            else
                return false;
        } else
            return false;
    }

    public static boolean isNetworkWifi() {
        ConnectivityManager conMan = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(conMan.getNetworkInfo(1) != null) {
            final NetworkInfo.State wifi = conMan.getNetworkInfo(1).getState();
            if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING)
                return true;
            else
                return false;
        } else
            return false;
    }


    /**
     * 读取application 节点  meta-data 信息
     */
    public static String buildChannel() {
        try {
            ApplicationInfo appInfo = mContext.getPackageManager()
                    .getApplicationInfo(mContext.getPackageName(),
                            PackageManager.GET_META_DATA);
            String mTag = appInfo.metaData.getString("UMENG_CHANNEL");
            return mTag;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}

