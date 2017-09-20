###  Calligraphy Fonts
https://github.com/chrisjenx/Calligraphy

#### Usage
1.应用 build.gradle 文件中添加
 ```
dependencies {
    compile 'uk.co.chrisjenx:calligraphy:2.3.0'
}
 ```
2.Application 类
 ```
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                // 设置默认字体(assets 目录下)
                .setDefaultFontPath("fonts/RobotoCondensed-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
 ```
3. layout 中 TextView 
```
    <TextView
            fontPath="fonts/RobotoCondensed-Regular.ttf"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="16dp"
            android:padding="10dp"
            android:text="Custom fonts in Android the easy way..." />
    
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="16dp"
            android:padding="10dp"
            android:text="Custom fonts in Android the easy way..."
            android:textAppearance="@style/TextAppearance.FontPath" />
            
      value/style.xml
      <style name="TextAppearance.FontPath" parent="android:TextAppearance">
            <!-- Custom Attr   assets 目录字体-->
            <item name="fontPath">fonts/RobotoCondensed-Regular.ttf</item>
            <item name="android:textColor">#444</item>
      </style>
```
4.应用中各个显示部分字体样式
```
        <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
            <!--Customize your theme here-->
            <item name="android:textViewStyle">@style/AppTheme.Widget.TextView</item>
            <!--Action Bar Theme-->
            <item name="android:actionBarStyle">@style/AppTheme.ActionBar</item>
        </style>
        
        <!-- AppTheme ActionBar Style -->
        <style name="AppTheme.ActionBar" parent="android:Widget.Holo.Light.ActionBar.Solid.Inverse">
            <item name="android:titleTextStyle">@style/AppTheme.ActionBar.TextAppearance</item>
            <item name="android:subtitleTextStyle">@style/AppTheme.ActionBar.TextAppearance.SubTitle</item>
        </style>
    
        <style name="AppTheme.ActionBar.TextAppearance" parent="TextAppearance.AppCompat.Widget.ActionBar.Title.Inverse">
            <item name="fontPath">fonts/Oswald-Stencbab.ttf</item>
        </style>
    
        <style name="AppTheme.ActionBar.TextAppearance.SubTitle" parent="TextAppearance.AppCompat.Widget.ActionBar.Subtitle.Inverse">
            <item name="fontPath">fonts/gtw.ttf</item>
        </style>
    
    
        <style name="AppTheme.Widget"/>
    
        <style name="TextViewNoStyleParent">
            <item name="android:textColor">@android:color/holo_blue_dark</item>
            <item name="fontPath">fonts/gtw.ttf</item>
        </style>
    
        <style name="AppTheme.Widget.TextView" parent="android:Widget.Holo.Light.TextView">
            <!-- Custom Attr-->
            <item name="fontPath">fonts/RobotoCondensed-Regular.ttf</item>
        </style>
    
        <style name="AppTheme.Widget.TextView.Style">
            <item name="fontPath">fonts/RobotoCondensed-Regular.ttf</item>
        </style>
    
        <style name="AppTheme.Widget.TextViewAppearanceStyle" parent="android:Widget.Holo.Light.TextView">
            <item name="android:textAppearance">@style/TextAppearance.FontPath</item>
        </style>
    
        <style name="TextAppearance.FontPath" parent="android:TextAppearance">
            <!-- Custom Attr-->
            <item name="fontPath">fonts/RobotoCondensed-Regular.ttf</item>
            <item name="android:textColor">#444</item>
        </style>
    
        <style name="TextAppearance.FontPathView" parent="android:TextAppearance">
            <!-- Custom Attr-->
            <item name="fontPath">fonts/Oswald-Stencbab.ttf</item>
            <item name="android:textColor">#444</item>
        </style>
```









