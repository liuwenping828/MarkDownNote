###  
1.AndroidViewModel--->ViewModel
#### 
1.接口 LifecycleOwner 中方法 获取
     Lifecycle getLifecycle();
1.1  接口LifecycleRegistryOwner 继承LifecycleOwner 并重写getLifecycle方法
     LifecycleRegistry getLifecycle();
1.2  
   
2.抽象类Lifecycle 定义Android中 Activity/Fragment 生命周期
        抽象方法
        addObserver(LifecycleObserver observer);   添加观察者
        removeObserver(LifecycleObserver observer)  移除
        getCurrentState();                          获取当前状态

3.Lifecycle 实现类 LifecycleRegistry 中处理对Android 组件生命 周期的监听及管理

4. LifecycleObserver 接口中没有定义方法
       
5. GenericLifecycleObserver 接口继承LifecycleObserver并定义如下方法
        void onStateChanged(LifecycleOwner source, Lifecycle.Event event);
        Object getReceiver(); 获取Event 事件
    5.1 ReflectiveGenericLifecycleObserver 实现 GenericLifecycleObserver 通过反射对方法，注解，字段获取
    
6. 抽象类 LiveData 内部类 LifecycleBoundObserver 实现 LifecycleObserver

#### Andrid Lifecycle
Activity 组件
1.通常按照文档是继承LifecycleActivity, 但是由于 LifecycleActivity 继承的是FragmentActivity ,当我们使用V7 主题时需要继承
AppCompatActivity ，所有抽取一个支持V7 主题的 Activity 基类
'''
    
    public class LifecycleAppCompatActivity extends AppCompatActivity
            implements LifecycleRegistryOwner {
    
        private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    
        @Override
        public LifecycleRegistry getLifecycle() {
            return mRegistry;
        }
    }

'''
 Fragment 组件
1.通常按照文档是继承LifecycleFragment  

##### ViewModel
1. ViewModelProviders 

     








