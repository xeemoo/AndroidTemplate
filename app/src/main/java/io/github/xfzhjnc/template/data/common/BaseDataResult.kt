package io.github.xfzhjnc.template.data.common

/**
 * 带状态（[DataState]）的基础数据结构
 */
class BaseDataResult<D> {
    var code: Int = -1
    var msg: String? = null
    var data: D? = null
    var dataState: DataState? = null
    var error: Throwable? = null
}