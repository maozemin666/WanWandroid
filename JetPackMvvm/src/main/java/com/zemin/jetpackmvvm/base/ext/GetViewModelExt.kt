package com.zemin.jetpackmvvm.base.ext

import java.lang.reflect.ParameterizedType

/**
 * @Author: ZeMin
 * @Date: 2021/5/27 16:07
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}
