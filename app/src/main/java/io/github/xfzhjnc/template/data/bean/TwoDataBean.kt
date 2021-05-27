package io.github.xfzhjnc.template.data.bean

import com.squareup.moshi.Json

data class TwoDataBean(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String
)