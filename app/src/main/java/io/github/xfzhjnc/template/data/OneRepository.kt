package io.github.xfzhjnc.template.data

import io.github.xfzhjnc.template.data.api.ApiFactory
import io.github.xfzhjnc.template.data.api.ApiService
import io.github.xfzhjnc.template.data.api.BASE_URL
import io.github.xfzhjnc.template.data.bean.OneDataBean
import io.github.xfzhjnc.template.data.common.BaseRepository
import io.github.xfzhjnc.template.data.common.StateLiveData

object OneRepository: BaseRepository() {
    private val apiService = ApiFactory.create(BASE_URL, ApiService::class.java)

    suspend fun fetchTestOneData(liveData: StateLiveData<OneDataBean>) {
        executeRequest(apiService::getTestOneData, liveData)
    }

}