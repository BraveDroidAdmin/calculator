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

val coreModules = arrayOf(":core:domain", ":core:design-system", ":core:testing")
val featureModules = arrayOf(":feature:cmp", ":feature:internal")
val modules = arrayOf(
    ":app",
    *coreModules,
    *featureModules,
)
include(*modules)
