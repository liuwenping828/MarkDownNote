package com.wenping.app;

import android.app.ActivityManager;
import android.os.IBinder;

/**
 * Created by Administrator on 2017/8/23.
 */

public class SystemInfo {


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
     *  Android  ServiceManager.java
     * @param name
     * @param service
     */
    public static void addService(String name, IBinder service){
        //通过详细地类名获取到指定的类
        try {
            Class<?> psirClass = Class.forName("android.os.ServiceManager");
            //通过方法名，传入参数获取指定方法
            java.lang.reflect.Method method = psirClass.getMethod("addService", String.class, IBinder.class);
            method.invoke(psirClass.newInstance(),name,service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  Android  ServiceManager.java
     * @param name
     */
    public static IBinder getService(String name){
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
