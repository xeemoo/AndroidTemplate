package io.github.xfzhjnc.template.data.bean

import com.squareup.moshi.Json

data class OneDataBean(
    @Json(name = "id")
    val id: String,
    @Json(name = "url")
    val url: String
)