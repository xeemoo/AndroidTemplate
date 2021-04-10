package io.github.xfzhjnc.template.data.api

import io.github.xfzhjnc.template.data.bean.OneDataBean
import io.github.xfzhjnc.template.data.bean.TwoDataBean
import io.github.xfzhjnc.template.data.network.ServerResult
import retrofit2.http.GET

@JvmSuppressWildcards
interface ApiService {

    @GET(GET_TEST_1)
    suspend fun getTestOneData(): ServerResult<OneDataBean>

    @GET(GET_TEST_2)
    suspend fun getTestTwoData(): ServerResult<TwoDataBean>
}