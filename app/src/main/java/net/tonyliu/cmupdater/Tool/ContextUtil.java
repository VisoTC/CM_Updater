package net.tonyliu.cmupdater.Tool;

/**
 * Created by szlyt on 2016/4/16 0016.
 * <p/>
 * 在类中获取Context
 */

import android.app.Application;

public class ContextUtil extends Application {
    private static ContextUtil instance;

    public static ContextUtil getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
    }
}