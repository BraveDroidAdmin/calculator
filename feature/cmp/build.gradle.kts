plugins {
    id("com.bravedroid.android.feature")
    id("com.bravedroid.android.library.jacoco")
}
android {
    namespace = "com.bravedroid.cmp"
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)

    testImplementation(project(":core:testing"))
    androidTestImplementation(project(":core:testing"))
}
