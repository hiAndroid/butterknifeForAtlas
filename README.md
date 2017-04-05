替换 butterknife ， 具体见 app/build.gradle


    configurations {
        all*.exclude group: 'com.jakewharton', module: 'butterknife'
    
    }
    
    repositories {
        flatDir {
                dirs 'libs' //this way we can find the .aar file in libs folder
                    
        }
    
    }
    
    dependencies {
        compile(name: 'butterknife-debug', ext: 'aar')
    }
