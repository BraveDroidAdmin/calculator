@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.gradle.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.bravedroid.design"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
           excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of("11"))
    }
}
dependencies {

//    implementation(libs.bundles.composeAndroidUI)

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.material:material:1.3.1")

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

//    debugImplementation(libs.bundles.composeAndroidTestsDebug)
    implementation(platform(libs.composeBom))
    implementation (libs.composeActivity)
    implementation (libs.composeLifecycleViewmodel)
    implementation (libs.composeNavigation)
    implementation(libs.composeMaterial3)
    implementation(libs.composeToolingUiPreview)
    debugImplementation(libs.composeDebugUiTooling)
    androidTestImplementation (libs.composeBom)
    androidTestImplementation( libs.composeTestJunit4)
    debugImplementation (libs.composeTestManifest)

    androidTestImplementation(libs.bundles.androidTests)
    testImplementation(libs.bundles.unitTestsBundle)
}
