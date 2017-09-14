com.android.support:design 支持库
描述：  
```
    res/value/style.xml  动画样式
    <style name="AnimBottom" parent="@android:style/Animation">
        <item name="android:windowEnterAnimation">@anim/push_bottom_in</item>
        <item name="android:windowExitAnimation">@anim/push_bottom_out</item>
    </style>
     res/anim/push_bottom_in.xml
    <?xml version="1.0" encoding="utf-8"?>
    <!-- 上下滑入式 -->
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <translate
            android:duration="200"
            android:fromYDelta="100%p"
            android:toYDelta="0" />
        <alpha
            android:duration="200"
            android:fromAlpha="0.0"
            android:toAlpha="1.0" />
    </set>
    res/anim/push_bottom_out.xml
    <?xml version="1.0" encoding="utf-8"?><!-- 上下滑入式 -->
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <translate
            android:duration="200"
            android:fromYDelta="0"
            android:toYDelta="50%p" />
        <alpha
            android:duration="200"
            android:fromAlpha="1.0"
            android:toAlpha="0.0" />
    </set>
    
```


