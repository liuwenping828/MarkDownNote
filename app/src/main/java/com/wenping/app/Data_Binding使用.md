### 配置
1.1应用模块(build.gradle)文件配置
```groovy
    android{
        dataBinding {
                enabled = true
         }
    }
``` 
### layout 文件
1.1 原Layout
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:card_view="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:bind="http://schemas.android.com/tools">
    <data>
        <variable
            name="user"
            type="com.wenping.binding.User" />
        <variable
            name="clickListener"
            type="android.view.View.OnClickListener"/>
    </data>
    <android.support.v7.widget.CardView
        card_view:cardUseCompatPadding="true"
        card_view:contentPadding="8dp"
        android:orientation="horizontal"
        android:layout_width="wrap_content"
        android:id="@+id/root"
        android:focusable="true"
        android:gravity="center_vertical"
        bind:onClickListener="@{clickListener}"
        android:layout_height="match_parent">
        <ImageView
            android:id="@+id/user_photo"
            android:backgroundResource="@{user.photoResource}"
            android:scaleType="fitCenter"
            android:layout_width="@dimen/user_photo"
            android:layout_height="@dimen/user_photo" />
        <TextView
            android:layout_marginLeft="@dimen/user_name_margin_left"
            android:id="@+id/fullname"
            android:gravity="center"
            android:text='@{user.name.substring(0,1).toUpperCase() + "." + user.lastName}'
            android:layout_width="wrap_content"
            android:layout_height="match_parent" />
    </android.support.v7.widget.CardView>
</layout>
```

1.2 生成Layout  \build\intermediates\data-binding-info\debug
```xml
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<Layout absoluteFilePath="E:\liuwenping_download_file\github-android\ExpandableCardViewList\binding\src\main\res\layout\list_item.xml" 
    directory="layout"
    isMerge="false"
    layout="list_item" modulePackage="com.wenping.binding">
    <Variables name="user" declared="true" type="com.wenping.binding.User">
        <location endLine="8" endOffset="45" startLine="6" startOffset="8" />
    </Variables>
    <Variables name="clickListener" declared="true" type="android.view.View.OnClickListener">
        <location endLine="11" endOffset="53" startLine="9" startOffset="8" />
    </Variables>
    <Targets>
        <Target id="@+id/root" tag="layout/list_item_0" view="android.support.v7.widget.CardView">
            <Expressions>
                <Expression attribute="bind:onClickListener" text="clickListener">
                    <Location endLine="23" endOffset="46" startLine="23" startOffset="8" />
                    <TwoWay>false</TwoWay>
                    <ValueLocation endLine="23" endOffset="44" startLine="23" startOffset="32" />
                </Expression>
            </Expressions>
            <location endLine="39" endOffset="40" startLine="15" startOffset="4" />
        </Target>
        <Target id="@+id/user_photo" tag="binding_1" view="ImageView">
            <Expressions>
                <Expression attribute="android:backgroundResource" text="user.photoResource">
                    <Location endLine="27" endOffset="61" startLine="27" startOffset="12" />
                    <TwoWay>false</TwoWay>
                    <ValueLocation endLine="27" endOffset="59" startLine="27" startOffset="42" />
                </Expression>
            </Expressions>
            <location endLine="30" endOffset="55" startLine="25" startOffset="8" />
        </Target>
        <Target id="@+id/fullname" tag="binding_2" view="TextView">
            <Expressions>
                <Expression
                    attribute="android:text"
                    text="user.name.substring(0,1).toUpperCase() + &quot;.&quot; + user.lastName">
                    <Location endLine="36" endOffset="89" startLine="36" startOffset="12" />
                    <TwoWay>false</TwoWay>
                    <ValueLocation endLine="36" endOffset="87" startLine="36" startOffset="28" />
                </Expression>
            </Expressions>
            <location endLine="38" endOffset="50" startLine="32" startOffset="8" />
        </Target>
    </Targets>
</Layout>
```

#### Class 
1.DataBindingInfo.java   \build\generated\source\dataBinding\debug\android\databinding\layouts
```java
 @BindingBuildInfo(buildId="022ca2fe-1e4f-44dc-acc1-57b34d28df40")
 public class DataBindingInfo {}
```

2.BR.java     \build\generated\source\apt\debug\com\wenping\binding
2.1  各类中添加注解 @Bindable 字段或方法
2.2  布局文件中 <variable>标签中 name 属性
```java
public class BR {
        public static final int _all = 0;
        public static final int activity = 1;
        public static final int clickListener = 2;
        public static final int favoriteColor = 3;
        public static final int group = 4;
        public static final int itemCount = 5;
        public static final int lastName = 6;
        public static final int name = 7;
        public static final int photoResource = 8;
        public static final int robotAdapter = 9;
        public static final int selected = 10;
        public static final int tkAdapter = 11;
        public static final int user = 12;
        public static final int viewBinder = 13;
}
```

3 DataBinderMapper  \build\generated\source\apt\debug\android\databinding
3.1  getDataBinder方法，根据layoutId 返回对应的 ViewDataBinding 实例
3.2  getLayoutId 方法，根据Tag(生成Targets 标签中的 tag 属性) 查找并返回布局Id
3.3  convertBrIdToString方法,从内部类InnerBrLookup 中根据id 查找对应值 
```java
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 16;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.wenping.binding.R.layout.list_item:
                    return com.wenping.binding.databinding.ListItemBinding.bind(view, bindingComponent);
                case com.wenping.binding.R.layout.activity_main:
                    return com.wenping.binding.databinding.ActivityMainBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -739838624: {
                if(tag.equals("layout/list_item_0")) {
                    return com.wenping.binding.R.layout.list_item;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.wenping.binding.R.layout.activity_main;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"activity"
            ,"clickListener"
            ,"favoriteColor"
            ,"group"
            ,"itemCount"
            ,"lastName"
            ,"name"
            ,"photoResource"
            ,"robotAdapter"
            ,"selected"
            ,"tkAdapter"
            ,"user"
            ,"viewBinder"};
    }
}
```
4 ListItemBinding.java   \build\generated\source\apt\debug\com\wenping\binding\databinding
4.1 继承自 ViewDataBinding
4.2 
```java
package com.wenping.binding.databinding;
import com.wenping.binding.R;
import com.wenping.binding.BR;
import android.view.View;
public class ListItemBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    public final android.widget.TextView fullname;
    public final android.support.v7.widget.CardView root;
    public final android.widget.ImageView userPhoto;
    // variables
    private android.view.View.OnClickListener mClickListener;
    private com.wenping.binding.User mUser;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.fullname = (android.widget.TextView) bindings[2];
        this.fullname.setTag(null);
        this.root = (android.support.v7.widget.CardView) bindings[0];
        this.root.setTag(null);
        this.userPhoto = (android.widget.ImageView) bindings[1];
        this.userPhoto.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.clickListener :
                setClickListener((android.view.View.OnClickListener) variable);
                return true;
            case BR.user :
                setUser((com.wenping.binding.User) variable);
                return true;
        }
        return false;
    }

    public void setClickListener(android.view.View.OnClickListener ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public android.view.View.OnClickListener getClickListener() {
        return mClickListener;
    }
    public void setUser(com.wenping.binding.User User) {
        updateRegistration(0, User);
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    public com.wenping.binding.User getUser() {
        return mUser;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUser((com.wenping.binding.User) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUser(com.wenping.binding.User User, int fieldId) {
        switch (fieldId) {
            case BR.photoResource: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
            case BR.name: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.lastName: {
                synchronized(this) {
                        mDirtyFlags |= 0x10L;
                }
                return true;
            }
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int userPhotoResource = 0;
        java.lang.String userName = null;
        android.view.View.OnClickListener clickListener = mClickListener;
        java.lang.String userNameSubstringInt0Int1ToUpperCaseJavaLangStringUserLastName = null;
        java.lang.String userNameSubstringInt0Int1 = null;
        java.lang.String userNameSubstringInt0Int1ToUpperCase = null;
        com.wenping.binding.User user = mUser;
        java.lang.String userLastName = null;
        java.lang.String userNameSubstringInt0Int1ToUpperCaseJavaLangString = null;

        if ((dirtyFlags & 0x22L) != 0) {
        }
        if ((dirtyFlags & 0x3dL) != 0) {


            if ((dirtyFlags & 0x25L) != 0) {

                    if (user != null) {
                        // read user.photoResource
                        userPhotoResource = user.getPhotoResource();
                    }
            }
            if ((dirtyFlags & 0x39L) != 0) {

                    if (user != null) {
                        // read user.name
                        userName = user.getName();
                        // read user.lastName
                        userLastName = user.getLastName();
                    }


                    if (userName != null) {
                        // read user.name.substring(0, 1)
                        userNameSubstringInt0Int1 = userName.substring(0, 1);
                    }


                    if (userNameSubstringInt0Int1 != null) {
                        // read user.name.substring(0, 1).toUpperCase()
                        userNameSubstringInt0Int1ToUpperCase = userNameSubstringInt0Int1.toUpperCase();
                    }


                    // read (user.name.substring(0, 1).toUpperCase()) + (".")
                    userNameSubstringInt0Int1ToUpperCaseJavaLangString = (userNameSubstringInt0Int1ToUpperCase) + (".");


                    // read ((user.name.substring(0, 1).toUpperCase()) + (".")) + (user.lastName)
                    userNameSubstringInt0Int1ToUpperCaseJavaLangStringUserLastName = (userNameSubstringInt0Int1ToUpperCaseJavaLangString) + (userLastName);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x39L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.fullname, userNameSubstringInt0Int1ToUpperCaseJavaLangStringUserLastName);
        }
        if ((dirtyFlags & 0x22L) != 0) {
            // api target 1

            this.root.setOnClickListener(clickListener);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            this.userPhoto.setBackgroundResource(userPhotoResource);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ListItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ListItemBinding>inflate(inflater, com.wenping.binding.R.layout.list_item, root, attachToRoot, bindingComponent);
    }
    public static ListItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wenping.binding.R.layout.list_item, null, false), bindingComponent);
    }
    public static ListItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/list_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ListItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): clickListener
        flag 2 (0x3L): user.photoResource
        flag 3 (0x4L): user.name
        flag 4 (0x5L): user.lastName
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}
```

### 
DataBindingUtil.java
1    DataBindingUtil.inflate(inflate,layoutId,parent,attachToParent)
 eg: DataBindingUtil.inflate(inflate,layoutId,parent,false)
 
2    inflate(inflater, layoutId, parent, attachToParent, sDefaultComponent)
 eg: inflate(inflater, layoutId, parent, false,null) 

3.    bind(bindingComponent,view,layoutId)
  eg: bind(null,view,layoutId)  view 通过inflate.inflate 方法生成
4.DataBinderMapper.java
     getDataBinder(bindingComponent,view,layoutId)
  eg: getDataBinder(null,view,layoutId) // 根据layoutId 调用对应布局绑定对象中的bind 方法
5.ListItemBinding.java
   bind(view,bindingComponent)
   eg:bind(view,null)
5.1 创建 ListItemBinding 实例
   ListItemBinding(bindingComponent,view)
   eg:ListItemBinding(null,view)
   
5.1.1 在构造方法中调用父类的构造方法及 ViewDataBinding
  在父类的构造方法中创建虚引用对象(WeakListener),并将参数给成员变量赋值
  同时根据SDK 版本分别创建不同的
   SDK >=16  choreographer 对象及 Choreographer.FrameCallback 回调实例
   SDK < 16 创建Handler 对象
   
5.1.2 调用父类中mapBindings()方法，将绑定的视图控件映射到 Object[] 中
5.1.3 将绑定的根视图设置 Tag 

6.1 调用 ListItemBinding.executeBindings() 将相应的数据设置到视图上进行显示




     








