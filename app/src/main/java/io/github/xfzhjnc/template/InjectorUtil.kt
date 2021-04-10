package io.github.xfzhjnc.template

import io.github.xfzhjnc.template.data.OneRepository
import io.github.xfzhjnc.template.data.TwoRepository

object InjectorUtil {

    fun getOneRepository(): OneRepository {
        return OneRepository
    }

    fun getTwoRepository(): TwoRepository {
        return TwoRepository
    }

}