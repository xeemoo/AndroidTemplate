package io.github.xfzhjnc.template.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import io.github.xfzhjnc.template.databinding.FragmentWelcomeBinding
import io.github.xfzhjnc.template.ui.base.BaseVmFragment
import io.github.xfzhjnc.template.viewmodel.WelcomeViewModel

class WelcomeFragment : BaseVmFragment<FragmentWelcomeBinding, WelcomeViewModel>() {

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentWelcomeBinding {
        return FragmentWelcomeBinding.inflate(inflater, container, false)
    }

    override fun createViewModel(): WelcomeViewModel {
        val viewModel: WelcomeViewModel by activityViewModels()
        return viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewModel.testTwoLiveData.observe(viewLifecycleOwner, Observer { result ->
            result.onSuccess {
                mBinding.tvWelcome.visibility = View.VISIBLE
            }

            result.onFailure {

            }
        })

        mViewModel.fetchTestTwoData()
    }



}