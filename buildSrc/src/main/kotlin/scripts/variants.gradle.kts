package scripts

import com.android.build.gradle.internal.api.ApkVariantOutputImpl

plugins { id("com.android.application") }

private object BuildTypes {
    const val DEBUG = "debug"
    const val RELEASE = "release"
}


android {
    signingConfigs {
        create("release") {
            storeFile = file("enjoy.keystore")
            storePassword = "123456"
            keyAlias = "enjoy"
            keyPassword = "123456"
        }
    }


    buildTypes {
        maybeCreate(BuildTypes.DEBUG).apply {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")

            applicationVariants.all {
                outputs.all {
                    if (this is ApkVariantOutputImpl) {
                        this.outputFileName = "OpenEye_${defaultConfig.versionName}_debug.apk"
                    }
                }
            }
        }

        maybeCreate(BuildTypes.RELEASE).apply {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")

            applicationVariants.all {

                println(this)
                println(this.outputs)

                this.outputs.all {
                    if (this is ApkVariantOutputImpl) {
                        this.outputFileName = "OpenEye_${defaultConfig.versionName}_release.apk"
                    }
                }
            }
        }
    }
}