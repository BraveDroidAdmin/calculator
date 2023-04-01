plugins {
    id("com.bravedroid.android.library")
    id("com.bravedroid.android.library.compose")
    id("com.bravedroid.android.hilt")
}

android {
    namespace = "com.bravedroid.core.testing"
}

dependencies {
    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)
    api(libs.hilt.android.testing)
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    debugApi(libs.androidx.compose.ui.testManifest)
}
