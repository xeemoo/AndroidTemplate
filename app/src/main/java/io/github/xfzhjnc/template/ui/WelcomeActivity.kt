package io.github.xfzhjnc.template.ui

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.xfzhjnc.template.databinding.ActivityWelcomeBinding
import io.github.xfzhjnc.template.ui.base.BaseActivity
import io.github.xfzhjnc.template.viewmodel.WelcomeViewModel

@AndroidEntryPoint
class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {

    private val mViewModel: WelcomeViewModel by viewModels()

    override fun createViewBinding(): ActivityWelcomeBinding {
        return ActivityWelcomeBinding.inflate(layoutInflater)
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
