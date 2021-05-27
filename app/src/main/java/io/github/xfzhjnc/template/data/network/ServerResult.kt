package io.github.xfzhjnc.template.data.network

import com.squareup.moshi.Json

/**
 * 网络接口返回的基础数据结构
 */
data class ServerResult<D>(
    @Json(name = "code")
    val code: Int,
    @Json(name = "msg")
    val msg: String,
    @Json(name = "data")
    val data: D
)
