@file:Suppress("DSL_SCOPE_VIOLATION")

buildscript {

}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.gms.google.service) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
}
