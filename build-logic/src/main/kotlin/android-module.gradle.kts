@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

import extension.*
import org.gradle.api.JavaVersion
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.`java-library`
import org.gradle.kotlin.dsl.kotlin


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
//    id ("com.google.dagger.hilt.android")
    kotlin("kapt")
}
val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

//android {
//    namespace = "com.bravedroid.cmp"
//    compileSdk = 33
//
//    defaultConfig {
//        minSdk = 24
//        targetSdk = 33
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
//        vectorDrawables {
//            useSupportLibrary = true
//        }
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    buildFeatures {
//        viewBinding = true
//        compose = true
//    }
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
//    packagingOptions {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//}
//kapt {
//    correctErrorTypes = true
//}
//kotlin {
//    jvmToolchain {
//        languageVersion.set(JavaLanguageVersion.of("11"))
//    }
//}

dependencies {

////  implementation(libs.bundles.composeAndroidUI)
//    implementation(platform(libs.composeBom))
//    implementation (libs.composeActivity)
//    implementation (libs.composeLifecycleViewmodel)
//    implementation (libs.composeNavigation)
//    implementation(libs.composeMaterial3)
//    implementation(libs.composeToolingUiPreview)
//    debugImplementation(libs.composeDebugUiTooling)
//
//    implementation(libs.androidxCore)
//    implementation(libs.androidxAppcompat)
//    implementation(libs.googleMaterial)
//    implementation(libs.androidxConstraintlayout)
//    implementation( libs.androidxFragment)
//
//    implementation(platform(libs.firebaseBom))
//    implementation(libs.firebase.crashlytics)
//    implementation(libs.firebase.analytics)
//
//    implementation(libs.hilt)
//    kapt(libs.hilt.compiler)
//
//    androidTestImplementation(libs.composeBom)
//    androidTestImplementation(libs.composeTestJunit4)
//    debugImplementation(libs.composeTestManifest)
//
//    androidTestImplementation(libs.bundles.androidTests)
//    testImplementation(libs.bundles.unitTestsBundle)
}
