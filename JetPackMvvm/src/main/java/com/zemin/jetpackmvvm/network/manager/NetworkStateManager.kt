package com.zemin.jetpackmvvm.network.manager

import com.zemin.jetpackmvvm.callback.livedata.event.EventLiveData

/**
 * @Author: ZeMin
 * @Date: 2021/5/27 16:47
 */
class NetworkStateManager private constructor() {
    val netWorkStateWorkCallback = EventLiveData<NetState>()

    companion object {
        val instance: NetworkStateManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }
}