package io.github.xfzhjnc.template.data

import io.github.xfzhjnc.template.data.api.ApiFactory
import io.github.xfzhjnc.template.data.api.ApiService
import io.github.xfzhjnc.template.data.api.BASE_URL
import io.github.xfzhjnc.template.data.bean.TwoDataBean
import io.github.xfzhjnc.template.data.common.BaseRepository
import io.github.xfzhjnc.template.data.common.StateLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TwoRepository @Inject constructor() : BaseRepository() {

    private val apiService = ApiFactory.create(BASE_URL, ApiService::class.java)

    suspend fun fetchTestTwoData(livedata: StateLiveData<TwoDataBean>) {
        executeRequest(apiService::getTestTwoData, livedata)
    }

}