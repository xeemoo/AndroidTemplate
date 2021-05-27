package io.github.xfzhjnc.template.data

import io.github.xfzhjnc.template.data.api.ApiFactory
import io.github.xfzhjnc.template.data.api.ApiService
import io.github.xfzhjnc.template.data.api.BASE_URL
import io.github.xfzhjnc.template.data.bean.TwoDataBean
import io.github.xfzhjnc.template.data.common.BaseRepository
import io.github.xfzhjnc.template.data.common.StateLiveData

object TwoRepository: BaseRepository() {

    private val apiService = ApiFactory.create(BASE_URL, ApiService::class.java)

    suspend fun fetchTestTwoData(livedata: StateLiveData<TwoDataBean>) {
        executeRequest(apiService::getTestTwoData, livedata)
    }

}