plugins {
    id("com.bravedroid.android.feature")
    id("com.bravedroid.android.library.compose")
    id("com.bravedroid.android.library.jacoco")
}
android {
    namespace = "com.bravedroid.internal"
}

dependencies {

    implementation(libs.androidx.fragment)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime)

    testImplementation(project(":core:testing"))
    androidTestImplementation(project(":core:testing"))
}
