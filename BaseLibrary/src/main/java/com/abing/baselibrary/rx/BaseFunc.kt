package com.abing.baselibrary.rx

import com.abing.baselibrary.common.ResultCode
import com.abing.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 10:53
 * 修改人：Administrator
 * 修改时间：2018-7-7 10:53
 * 修改备注：
 * @version
 *
 */
/*
    通用数据类型转换封装
 */
class BaseFunc<T>: Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status,t.message))
        }

        return Observable.just(t.data)
    }
}
