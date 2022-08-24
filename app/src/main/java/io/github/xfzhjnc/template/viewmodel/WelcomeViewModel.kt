package io.github.xfzhjnc.template.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.xfzhjnc.template.data.OneRepository
import io.github.xfzhjnc.template.data.TwoRepository
import io.github.xfzhjnc.template.data.bean.OneDataBean
import io.github.xfzhjnc.template.data.bean.TwoDataBean
import io.github.xfzhjnc.template.data.common.BaseDataResult
import io.github.xfzhjnc.template.data.common.StateLiveData
import io.github.xfzhjnc.template.ui.WelcomeActivity
import io.github.xfzhjnc.template.ui.WelcomeFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * The ViewModel used in [WelcomeActivity] and [WelcomeFragment]
 */
@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val oneRepository: OneRepository,
    private val twoRepository: TwoRepository
) : BaseViewModel() {

    private val _testOneLiveData = StateLiveData<OneDataBean>()
    private val _testTwoLiveData = StateLiveData<TwoDataBean>()

    val testOneLiveData: LiveData<BaseDataResult<OneDataBean>>
        get() = _testOneLiveData

    val testTwoLiveData: LiveData<BaseDataResult<TwoDataBean>>
        get() = _testTwoLiveData

    fun fetchTestOneData() {
        viewModelScope.launch {
            oneRepository.fetchTestOneData(_testOneLiveData)
        }
    }

    fun fetchTestTwoData() {
        viewModelScope.launch {
            twoRepository.fetchTestTwoData(_testTwoLiveData)
        }
    }

}