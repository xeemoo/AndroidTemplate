package io.github.xfzhjnc.template.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.xfzhjnc.template.data.OneRepository
import io.github.xfzhjnc.template.data.TwoRepository

class BaseViewModelFactory(
    private val oneRepository: OneRepository,
    private val twoRepository: TwoRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(WelcomeViewModel::class.java) -> {
                return WelcomeViewModel(oneRepository, twoRepository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}