package com.wenping.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;

import java.io.File;

/**
 * Created by Administrator on 2017/8/23.
 */

public class SystemInfo {

    // 打开系统设置更多应用
    public static void openAllApplication(Context context){
        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
        context.startActivity(intent);
    }

    // 打开系统设置开发者选项
    public static void openDeveloperSettings(Context context){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
        context.startActivity(intent);
    }

    // 通过包名启动应用
    public static void launchAppForPackageName(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent intent = manager.getLaunchIntentForPackage(packageName);
        if (intent != null) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        }
    }

    // 打开应用详情设置
    public static void openAppDetailsSettings(Context context, String packageName) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", packageName, null);
        intent.setData(uri);
        context.startActivity(intent);
    }

    // 安装应用
    public static void installApk(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(apkFile);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }


    // 检查设备是否Root
    public static boolean checkRooted() {
        boolean result = false;
        try {
            result = new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static long GetAvailableMemory(ActivityManager manager) {
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(info);
        return info.availMem;
    }

    public static long GetTotalMemory(ActivityManager manager) {
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(info);
        return info.totalMem;
    }

    /***
     *  Android SystemProperties.java
     * @param prop
     * @param defVal
     * @return
     */
    public static String systemPropertiesGet(String prop, String defVal) {
        try {
            //通过详细地类名获取到指定的类
            Class<?> psirClass = Class.forName("android.os.SystemProperties");
            //通过方法名，传入参数获取指定方法
            java.lang.reflect.Method method = psirClass.getMethod("get", String.class, String.class);
            String ret = (String) method.invoke(psirClass.newInstance(), prop, defVal);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defVal;
    }

    /**
     * Android  ServiceManager.java
     *
     * @param name
     * @param service
     */
    public static void addService(String name, IBinder service) {
        //通过详细地类名获取到指定的类
        try {
            Class<?> psirClass = Class.forName("android.os.ServiceManager");
            //通过方法名，传入参数获取指定方法
            java.lang.reflect.Method method = psirClass.getMethod("addService", String.class, IBinder.class);
            method.invoke(psirClass.newInstance(), name, service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Android  ServiceManager.java
     *
     * @param name
     */
    public static IBinder getService(String name) {
        //通过详细地类名获取到指定的类
        try {
            Class<?> psirClass = Class.forName("android.os.ServiceManager");
            //通过方法名，传入参数获取指定方法
            java.lang.reflect.Method method = psirClass.getMethod("getService", String.class);
            IBinder binder = (IBinder) method.invoke(psirClass.newInstance(), name);
            return binder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
