package com.astrainteractive.astraclans.config.config

import com.astrainteractive.astraclans.domain.config.IConfigProvider
import com.astrainteractive.astraclans.domain.config.PluginConfig
import ru.astrainteractive.astralibs.EmpireSerializer
import ru.astrainteractive.astralibs.file_manager.FileManager

class ConfigProvider(initial: PluginConfig) : IConfigProvider {
    override var config: PluginConfig = initial

    companion object {
        fun loadPluginConfig(file: FileManager): PluginConfig {
            return EmpireSerializer.toClass<PluginConfig>(file.configFile) ?: throw Exception("Could not load config")
        }
    }
}