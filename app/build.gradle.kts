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
    implementation(Libraries.legacy)
    implementation(Libraries.banner)
    implementation(Libraries.title)
    implementation(Libraries.player)
}