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
 * 创建时间：2018-7-7 11:02
 * 修改人：Administrator
 * 修改时间：2018-7-7 11:02
 * 修改备注：
 * @version
 *
 */
/*
    Boolean类型转换封装
 */
class BaseFuncBoolean<T>: Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.rtState != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.rtState, t.rtMsrg))
        }

        return Observable.just(true)
    }
}
