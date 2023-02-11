import extension.*
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.`java-library`
import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
    `java-library`
    id("kotlin-kapt")
}
val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of("11"))
    }
}

dependencies {
    implementation(libs.kotlinJVMBundle)
    implementation(libs.javaxInject)
    testImplementation(libs.unitTestsBundle)
}

