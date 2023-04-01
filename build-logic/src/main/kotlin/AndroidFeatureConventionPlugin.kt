
import com.android.build.gradle.LibraryExtension
import com.bravedroid.tools.configureGradleManagedDevices
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.bravedroid.android.library")
                apply("com.bravedroid.android.hilt")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        "com.bravedroid.core.testing.CalculatorTestRunner"
                }
                configureGradleManagedDevices(this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
//                add("implementation", project(":core:model"))
//                add("implementation", project(":core:ui"))
//                add("implementation", project(":core:designsystem"))
//                add("implementation", project(":core:data"))
//                add("implementation", project(":core:common"))
//                add("implementation", project(":core:domain"))
//                add("implementation", project(":core:analytics"))

                add("testImplementation", kotlin("test"))
                add("testImplementation", project(":core:testing"))
                add("androidTestImplementation", kotlin("test"))
                add("androidTestImplementation", project(":core:testing"))

                add("implementation", libs.findLibrary("coil.kt").get())
                add("implementation", libs.findLibrary("coil.kt.compose").get())

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}
