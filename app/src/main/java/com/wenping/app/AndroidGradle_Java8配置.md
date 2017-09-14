 ### 应用中gradle Java8 lamb 配置
 ``` groovy
     android{
        defaultConfig{
            jackOptions {
                enabled true
            }
        }
        
        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }
    }
 ```



