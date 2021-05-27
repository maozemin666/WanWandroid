package com.zemin.jetpackmvvm.base.viewmodel

import androidx.lifecycle.ViewModel
import com.zemin.jetpackmvvm.callback.livedata.event.EventLiveData

/**
 * @Author: ZeMin
 * @Date: 2021/5/27 15:52
 */
open class BaseViewModel : ViewModel() {
    val loadingChange by lazy { UiLoadingChange() }


    inner class UiLoadingChange {
        val showDialog by lazy { EventLiveData<String>() }
        val dismissDialog by lazy { EventLiveData<Boolean>() }
    }
}