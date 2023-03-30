plugins {
    kotlin("jvm")
//    `java-library`
//    id("kotlin-kapt")
}
kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of("11"))
    }
}

dependencies {
    implementation(libs.bundles.kotlinJVMBundle)
    implementation(libs.javaxInject)
    testImplementation(libs.bundles.unitTestsBundle)
}

