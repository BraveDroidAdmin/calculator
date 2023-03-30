
group = "com.bravedroid.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

plugins {
    `version-catalog`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradle)
}
gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "nowinandroid.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}
