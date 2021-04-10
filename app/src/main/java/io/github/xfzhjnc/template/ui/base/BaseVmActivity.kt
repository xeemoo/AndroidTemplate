package io.github.xfzhjnc.template.ui.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import io.github.xfzhjnc.template.viewmodel.BaseViewModel

abstract class BaseVmActivity<VB : ViewBinding, VM : BaseViewModel> : BaseActivity<VB>() {

    private lateinit var _viewModel: VM
    protected val mViewModel: VM get() = _viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _viewModel = createViewModel()
    }

    abstract fun createViewModel(): VM

}