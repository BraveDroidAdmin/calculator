@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")


plugins {
//    id("com.android.library")
//    id("org.jetbrains.kotlin.android")
//    alias(libs.plugins.gradle.plugins.hilt)
//    kotlin("kapt")
    id("com.bravedroid.android.feature")
    id("com.bravedroid.android.library.compose")
    id("com.bravedroid.android.hilt")
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
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//    kotlinOptions {
//        jvmTarget = JavaVersion.VERSION_11.toString()
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.4.0"
//    }
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
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)

    debugApi(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.core.ktx)
    api(libs.coil.kt.compose)

    androidTestImplementation(project(":core:testing"))
}
