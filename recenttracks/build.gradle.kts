plugins {
    id(Dependencies.androidLibrary)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinAndroidExtensions)
    id(Dependencies.kotlinKapt)
}

android {
    compileSdkVersion(Dependencies.AndroidSdk.compileSdk)
    buildToolsVersion(Dependencies.AndroidSdk.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Dependencies.AndroidSdk.minSdk)
        targetSdkVersion(Dependencies.AndroidSdk.targetSdk)
        versionCode = 1
        versionName = "1.0"

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

    implementation(Dependencies.Libraries.timber)

    implementation(Dependencies.Libraries.Network.retrofit)

    implementation(Dependencies.Libraries.Network.moshi)
    implementation(Dependencies.Libraries.Network.moshiConverter)
    implementation(project(mapOf("path" to ":core")))

    implementation(Dependencies.Libraries.Dagger.runtime)
    kapt(Dependencies.Libraries.Dagger.compiler)

    kapt(Dependencies.Libraries.Network.moshiKotlinCodegen)

}