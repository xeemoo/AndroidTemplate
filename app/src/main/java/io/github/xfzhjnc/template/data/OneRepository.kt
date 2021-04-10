package io.github.xfzhjnc.template.data

import io.github.xfzhjnc.template.data.api.ApiFactory
import io.github.xfzhjnc.template.data.api.ApiService
import io.github.xfzhjnc.template.data.api.BASE_URL
import io.github.xfzhjnc.template.data.bean.OneDataBean
import io.github.xfzhjnc.template.data.network.ServerResult

object OneRepository {
    private val apiService = ApiFactory.create(BASE_URL, ApiService::class.java)

    suspend fun fetchTestOneData(): ServerResult<OneDataBean> {
        return apiService.getTestOneData()
    }

}