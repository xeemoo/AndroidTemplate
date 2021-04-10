package io.github.xfzhjnc.template.viewmodel

import androidx.lifecycle.*
import io.github.xfzhjnc.template.data.OneRepository
import io.github.xfzhjnc.template.data.TwoRepository
import io.github.xfzhjnc.template.data.bean.OneDataBean
import io.github.xfzhjnc.template.data.bean.TwoDataBean
import io.github.xfzhjnc.template.data.network.ServerResult
import kotlinx.coroutines.launch
import java.lang.Exception

class WelcomeViewModel(
    private val oneRepository: OneRepository,
    private val twoRepository: TwoRepository
) : BaseViewModel() {

    private val _testOneLiveData = MediatorLiveData<Result<ServerResult<OneDataBean>>>()
    private val _testTwoLiveData = MutableLiveData<Result<ServerResult<TwoDataBean>>>()

    val testOneLiveData: LiveData<Result<ServerResult<OneDataBean>>>
        get() = _testOneLiveData

    val testTwoLiveData: LiveData<Result<ServerResult<TwoDataBean>>>
        get() = _testTwoLiveData

    fun fetchTestOneData() {
        viewModelScope.launch {
            val testOneResult = try {
                Result.success(oneRepository.fetchTestOneData())
            } catch (e : Exception) {
                Result.failure(e)
            }

            _testOneLiveData.value = testOneResult
        }

    }

    fun fetchTestTwoData() {
        viewModelScope.launch {
            val testTwoResult = try {
                Result.success(twoRepository.fetchTestTwoData())
            } catch (e : Exception) {
                Result.failure(e)
            }

            _testTwoLiveData.value = testTwoResult
        }
    }

}