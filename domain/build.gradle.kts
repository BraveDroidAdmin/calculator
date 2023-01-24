plugins {
    kotlin("jvm")
    `java-library`
    id("kotlin-kapt")
}
dependencies {
    implementation(libs.bundles.kotlinJVM)
    implementation(libs.javax.inject)
    testImplementation(libs.bundles.unitTests)
 }

