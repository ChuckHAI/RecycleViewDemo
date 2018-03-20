package client.mimi.com.mimiclient;

import android.app.Application;

import client.mimi.com.mimiclient.util.MVPConfig;

/**
 * Created by chuck on 2018/3/1.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        MVPConfig.setToolbarDrawable(R.color.colorWhite);
        MVPConfig.setStatusbarDrawable(R.color.colorBlack);
//        MVPConfig.setBackDrawable();
        MVPConfig.setIsStatusBarLight(true);
    }
}
