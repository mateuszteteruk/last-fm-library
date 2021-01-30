plugins {
    id(Dependencies.javaLibrary)
    id(Dependencies.kotlinLibrary)
    id(Dependencies.kotlinKapt)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.Libraries.kotlinStdLib)

    implementation(Dependencies.Libraries.Network.moshi)
    implementation(Dependencies.Libraries.Network.moshiConverter)

    implementation("javax.inject:javax.inject:1")

    kapt(Dependencies.Libraries.Network.moshiKotlinCodegen)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}