package io.github.xfzhjnc.template.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import io.github.xfzhjnc.template.InjectorUtil
import io.github.xfzhjnc.template.databinding.ActivityWelcomeBinding
import io.github.xfzhjnc.template.ui.base.BaseVmActivity
import io.github.xfzhjnc.template.viewmodel.BaseViewModelFactory
import io.github.xfzhjnc.template.viewmodel.WelcomeViewModel

class WelcomeActivity : BaseVmActivity<ActivityWelcomeBinding, WelcomeViewModel>() {

    override fun createViewBinding(): ActivityWelcomeBinding {
        return ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun createViewModel(): WelcomeViewModel {
        return ViewModelProvider(
            this, BaseViewModelFactory(
                InjectorUtil.getOneRepository(), InjectorUtil.getTwoRepository()
            )
        ).get(WelcomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(mBinding.container.id, WelcomeFragment())
                .commitNow()
        }

        mViewModel.also { println(it.hashCode()) }

    }


}
