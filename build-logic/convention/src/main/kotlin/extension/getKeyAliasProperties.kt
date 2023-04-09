package extension

import org.gradle.api.Project
import java.io.File
import java.io.FileInputStream
import java.util.*

object SigningConfigHelper {
    fun Project.getSigningConfigProperties(propertiesFile: File = rootProject.file("/keys/keystore.properties")): Properties {
        if (propertiesFile.exists()) {
            val properties = Properties().apply {
                load(FileInputStream(propertiesFile))
            }
            return properties
        }
        throw IllegalStateException("keystore file not found")
    }
}
