package io.github.xfzhjnc.template

open class SingletonHolder<out T, in A>(private val creator: (A) -> T) {
    private var instance: T? = null

    fun getInstance(arg: A): T = instance ?: synchronized(this) {
        instance ?: creator(arg).apply {
            instance = this
        }
    }

}

open class PairArgsSingletonHolder<out T, in A, in B>(private val creator: (A, B) -> T) :
    SingletonHolder<T, Pair<A, B>>(creator = { (a, b) -> creator(a, b) }) {
        fun getInstance(arg1: A, arg2: B) = getInstance(Pair(arg1, arg2))
}

open class TripleArgsSingletonHolder<out T, in A, in B, in C>(private val creator: (A, B, C) -> T) :
    SingletonHolder<T, Triple<A, B, C>>(creator = { (a, b, c) -> creator(a, b, c) }) {
        fun getInstance(arg1: A, arg2: B, arg3: C) = getInstance(Triple(arg1, arg2, arg3))
}

