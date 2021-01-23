import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Dependencies.androidApplication)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinAndroidExtensions)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
}

fun loadLocalProperty(property: String): String {
    return gradleLocalProperties(rootDir).getProperty(property)
}

android {
    compileSdkVersion(Dependencies.AndroidSdk.compileSdk)
    buildToolsVersion(Dependencies.AndroidSdk.buildToolsVersion)

    defaultConfig {
        applicationId = Dependencies.applicationId
        minSdkVersion(Dependencies.AndroidSdk.minSdk)
        targetSdkVersion(Dependencies.AndroidSdk.targetSdk)
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "LASTFM_API_KEY", loadLocalProperty("lastfm_api_key"))
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Dependencies.Libraries.kotlinStdLib)

    implementation(Dependencies.Libraries.AndroidX.core)
    implementation(Dependencies.Libraries.AndroidX.appcompat)
    implementation(Dependencies.Libraries.AndroidX.material)
    implementation(Dependencies.Libraries.AndroidX.constraint)
    implementation(Dependencies.Libraries.AndroidX.navigationUi)
    implementation(Dependencies.Libraries.AndroidX.navigationFragment)

    implementation(Dependencies.Libraries.timber)

    implementation(Dependencies.Libraries.Network.moshi)
    implementation(Dependencies.Libraries.Network.moshiConverter)
    implementation(Dependencies.Libraries.Network.okhttp)
    implementation(Dependencies.Libraries.Network.okhttpLoggingInterceptor)
    implementation(Dependencies.Libraries.Network.retrofit)

    implementation(Dependencies.Libraries.Hilt.hilt)

    kapt(Dependencies.Libraries.Network.moshiKotlinCodegen)
    kapt(Dependencies.Libraries.Hilt.compiler)
}