plugins {
    id("kotlin")
    id("com.bravedroid.android.quality")
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.javax.inject)
    testImplementation(libs.bundles.unitTests)
}
