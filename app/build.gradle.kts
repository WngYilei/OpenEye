plugins {
    // 系统插件
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerPlugin)
    id(BuildPlugins.kotlinAndroidExtensions)
    // 内部插件
    id(ScriptPlugins.variants)
    id(ScriptPlugins.compilation)
}

dependencies {
    implementation(Libraries.hiltlifecycleviewmodel)
    implementation(Libraries.hiltandroid)
    implementation(Libraries.base)
    kapt(Libraries.daggercompiler)
    kapt(Libraries.hiltcompiler)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")

    implementation("io.github.youth5201314:banner:2.2.2")
    implementation("com.github.getActivity:TitleBar:9.3")
    implementation("cn.jzvd:jiaozivideoplayer:7.7.0")
}