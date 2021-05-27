package io.github.xfzhjnc.template.data.common

import io.github.xfzhjnc.template.data.network.ServerResult

open class BaseRepository {

    /**
     * 执行网络请求，并将网络请求结果处理成带状态的LiveData数据
     *
     * @param block         suspend网络请求方法
     * @param stateLiveData 接收网络请求数据的LiveData变量
     */
    suspend fun <T : Any> executeRequest(
        block: suspend () -> ServerResult<T>,
        stateLiveData: StateLiveData<T>
    ) {
        val baseDataResult = BaseDataResult<T>()

        try {
            //set state to loading
            baseDataResult.dataState = DataState.STATE_LOADING

            //do network request
            val serverResult = block.invoke()

            //set dataResult according to serverResult
            copyServerResultToDataResult(serverResult, baseDataResult)

            if (baseDataResult.data == null ||
                baseDataResult.data is List<*> && (baseDataResult.data as List<*>).size == 0) {

                baseDataResult.dataState = DataState.STATE_EMPTY

            } else {
                baseDataResult.dataState = DataState.STATE_SUCCEEDED
            }

        } catch (e: Throwable) {
            baseDataResult.dataState = DataState.STATE_ERROR
            baseDataResult.error = e

        } finally {
            stateLiveData.postValue(baseDataResult)
        }
    }

    private fun <T> copyServerResultToDataResult(
        serverResult: ServerResult<T>,
        dataResult: BaseDataResult<T>
    ) {
        dataResult.code = serverResult.code
        dataResult.msg = serverResult.msg
        dataResult.data = serverResult.data
    }
}