package net.tonyliu.cmupdater;

import android.content.Context;
import android.content.SharedPreferences;

import net.tonyliu.cmupdater.Tool.ContextUtil;
/**
 * Created by szlyt on 2016/4/16 0016.
 * 本地数据操作类
 * 用于保存与读取本地保存数据
 */
public class LocalData {
    private LocalData() {

    }

    public static void set(String root, String key, String val) {//String
        SharedPreferences sharedPreferences = ContextUtil.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        editor.putString(key, val);
        editor.commit();
    }

    public static void set(String root, String key, int val) {  //int
        SharedPreferences sharedPreferences = ContextUtil.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        editor.putInt(key, val);
        editor.commit();
    }

    public static void set(String root, String key, long val) {  //long
        SharedPreferences sharedPreferences = ContextUtil.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        editor.putLong(key, val);
        editor.commit();
    }

    public static String getString(String root, String key) {
        SharedPreferences sharedPreferences = ContextUtil.getInstance().getSharedPreferences(root, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public static int getInt(String root, String key) {
        SharedPreferences sharedPreferences = ContextUtil.getInstance().getSharedPreferences(root, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    public static long getLong(String root, String key) {
        SharedPreferences sharedPreferences = ContextUtil.getInstance().getSharedPreferences(root, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, 0);
    }

    //=============快速实现
    //=============config
    public static void setConfig(String key, String val) {
        set("config", key, val);
    }

    public static void setConfig(String key, int val) {
        set("config", key, val);
    }

    public static String getConfigString(String key) {
        return getString("config", key);
    }

    public static int getConfigInt(String key) {
        return getInt("config", key);
    }
}
