package io.github.xfzhjnc.template.data.network

data class ServerResult<D>(
    val code: Int,
    val msg: String,
    val data: D
)
