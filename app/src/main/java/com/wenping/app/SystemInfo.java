package com.wenping.app;

import android.app.ActivityManager;

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

}
