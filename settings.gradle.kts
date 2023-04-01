@file:Suppress("UnstableApiUsage")

include(":core:testing")


enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        includeBuild("build-logic")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Calculator"
val modules = arrayOf(
    ":app", ":domain", ":cmp", ":internal", ":system-design",
)
include(*modules)
