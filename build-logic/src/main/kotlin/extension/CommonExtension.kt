@file:Suppress("UnstableApiUsage")

package extension

import CalculatorVersions
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import composeVersion
import gradle.kotlin.dsl.accessors.*
import org.gradle.api.artifacts.VersionCatalog

fun CommonExtension<*, *, *, *>.androidConfig() {
    defaultConfig {
        compileSdk = CalculatorVersions.compileSdk
        minSdk = CalculatorVersions.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

fun CommonExtension<*, *, *, *>.composeConfig(libs: VersionCatalog) {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.composeVersion
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

fun LibraryExtension.proguardConfig() {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
            consumerProguardFiles("proguard-rules.pro")
        }
    }
}
