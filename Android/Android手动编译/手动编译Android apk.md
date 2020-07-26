

```shell
export PATH=$PATH:/Users/xianeng/Library/Android/sdk/build-tools/29.0.2

midir build

aapt2 compile -o build/res.zip --dir app/src/main/res



aapt2 link build/res.zip -I $ANDROID_SDK/platforms/android-29/android.jar --java build --manifest app/src/main/AndroidManifest.xml -o build/app-debug.apk


javac -d build -cp $ANDROID_SDK/platforms/android-29/android.jar app/src/main/java/com/**/**/*.java


d8 --output build/ --lib $ANDROID_SDK/platforms/android-29/android.jar build/com/xprojct/myapplication/*.class


zip -j build/app-debug.apk build/classes.dex



apksigner sign -ks ~/.android/debug.keystore build/app-debug.apk 
```





