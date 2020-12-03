package com.cmbytes.compose.configs

import com.cmbytes.compose.BuildConfig
import com.cmbytes.compose.network.configs.HttpConfig

class HttpConfigProvider : HttpConfig {
    override val baseUrl: String
        get() = BuildConfig.HTTP_SERVER_BASE_URL
}