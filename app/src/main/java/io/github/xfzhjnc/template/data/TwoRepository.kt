package io.github.xfzhjnc.template.data

import io.github.xfzhjnc.template.data.api.ApiFactory
import io.github.xfzhjnc.template.data.api.ApiService
import io.github.xfzhjnc.template.data.api.BASE_URL
import io.github.xfzhjnc.template.data.bean.TwoDataBean
import io.github.xfzhjnc.template.data.network.ServerResult

object TwoRepository {

    private val apiService = ApiFactory.create(BASE_URL, ApiService::class.java)

    suspend fun fetchTestTwoData(): ServerResult<TwoDataBean> {
        return apiService.getTestTwoData()
    }

}