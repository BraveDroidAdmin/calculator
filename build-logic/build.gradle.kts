plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)

//    // https://github.com/gradle/gradle/issues/15383
//    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

