package extension

import java.io.File
import java.io.FileInputStream
import java.util.*

object SigningConfigHelper {
    fun getSigningConfigProperties(propertiesFile: File): Properties {
        if (propertiesFile.exists()) {
            val properties = Properties().apply {
                load(FileInputStream(propertiesFile))
            }
            return properties
        }
        throw IllegalStateException("keystore file not found")
    }
}
