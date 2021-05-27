package com.zemin.jetpackmvvm.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zemin.jetpackmvvm.base.ext.getVmClazz
import com.zemin.jetpackmvvm.base.viewmodel.BaseViewModel
import com.zemin.jetpackmvvm.network.manager.NetState
import com.zemin.jetpackmvvm.network.manager.NetworkStateManager

/**
 * @Author: ZeMin
 * @Date: 2021/5/27 15:50
 */
abstract class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity() {
    private var isUserDb = false

    lateinit var viewModel: VM

    abstract fun layoutId(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun createObserver()

    abstract fun showLoading(msg: String = "请求网络中...")

    abstract fun dismissLoading()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isUserDb) {
            initDataBind()
        } else {
            setContentView(layoutId())
        }
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        viewModel = createViewModel()
        registerUiChange()
        initView(savedInstanceState)
        createObserver()
        NetworkStateManager.instance.netWorkStateWorkCallback.observe(this) { netSate ->
            onNetWorkStateChange(netSate)
        }
    }

    open fun onNetWorkStateChange(netSate: NetState) {
    }

    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

    private fun registerUiChange() {
        viewModel.loadingChange.showDialog.observe(this) { msg ->
            showLoading(msg)
        }
        viewModel.loadingChange.dismissDialog.observe(this) {
            dismissLoading()
        }
    }

    fun userDataBinding(isUserDb: Boolean) {
        this.isUserDb = isUserDb
    }

    open fun initDataBind() {

    }
}