package com.zemin.jetpackmvvm.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.zemin.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * @Author: ZeMin
 * @Date: 2021/5/27 16:59
 */
abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {

    lateinit var databind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        userDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    override fun initDataBind() {
        databind = DataBindingUtil.setContentView(this, layoutId())
        databind.lifecycleOwner = this
    }
}