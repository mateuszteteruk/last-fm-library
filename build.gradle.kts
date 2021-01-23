// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        maven(url = "https://maven.google.com")
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.gradlePlugin)
        classpath(Dependencies.kotlinPlugin)
        classpath(Dependencies.Libraries.Hilt.plugin)
    }
}

allprojects {
    repositories {
        google()
        maven(url = "https://maven.google.com")
        mavenCentral()
        jcenter()
    }
}