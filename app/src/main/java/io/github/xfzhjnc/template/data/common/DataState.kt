package io.github.xfzhjnc.template.data.common

/**
 * Enum states of requested data.
 */
enum class DataState {

    /**
     * 创建
     */
    STATE_CREATE,

    /**
     * 加载中
     */
    STATE_LOADING,

    /**
     * 已成功且返回非空数据
     */
    STATE_SUCCEEDED,

    /**
     * 已完成
     */
    STATE_COMPLETED,

    /**
     * 已成功，返回数据为null
     */
    STATE_EMPTY,

    /**
     * 接口请求成功，但是服务器返回错误码
     */
    STATE_FAILED,

    /**
     * 请求失败
     */
    STATE_ERROR,

    /**
     * 未知状态
     */
    STATE_UNKNOWN,

}