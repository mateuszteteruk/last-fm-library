object Dependencies {

    const val applicationId = "pl.mateuszteteruk.lastfmlibrary"

    const val kotlin = "1.4.20"
    const val gradlePlugin = "com.android.tools.build:gradle:4.0.1"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val javaLibrary = "java-library"
    const val kotlinLibrary = "kotlin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val hiltPlugin = "dagger.hilt.android.plugin"

    object AndroidSdk {

        const val compileSdk = 29
        const val minSdk = 23
        const val targetSdk = 29
        const val buildToolsVersion = "30.0.2"
    }

    object Libraries {
        private object Version {

            const val core = "1.3.2"
            const val appcompat = "1.2.0"
            const val material = "1.2.1"
            const val constraintlayout = "2.0.4"
            const val navigation = "2.3.2"
            const val timber = "4.7.1"
            const val moshi = "1.11.0"
            const val retrofit = "2.9.0"
            const val okhttp = "4.9.0"
            const val hilt = "2.28-alpha"
        }

        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin"

        object AndroidX {

            const val core = "androidx.core:core-ktx:${Version.core}"
            const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
            const val material = "com.google.android.material:material:${Version.material}"
            const val constraint = "androidx.constraintlayout:constraintlayout:${Version.constraintlayout}"
            const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        }

        const val timber = "com.jakewharton.timber:timber:${Version.timber}"

        object Network {

            const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
            const val moshi = "com.squareup.moshi:moshi:${Version.moshi}"
            const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"
            const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
            const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
            const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
        }

        object Hilt {

            const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
            const val compiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
            const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
        }

    }

}