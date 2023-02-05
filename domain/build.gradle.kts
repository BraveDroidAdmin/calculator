plugins {
    kotlin("jvm")
    `java-library`
    id("kotlin-kapt")
}
kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of("11"))
    }
}

dependencies {
    implementation(libs.bundles.kotlinJVM)
    implementation(libs.javax.inject)
    testImplementation(libs.bundles.unitTests)
 }

