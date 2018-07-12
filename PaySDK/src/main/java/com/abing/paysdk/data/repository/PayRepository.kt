package com.abing.paysdk.data.repository


import com.abing.baselibrary.data.net.RetrofitFactory
import com.abing.baselibrary.data.protocol.BaseResp
import com.abing.paysdk.data.api.PayApi
import com.abing.paysdk.data.protocol.GetPaySignReq
import com.abing.paysdk.data.protocol.PayOrderReq
import rx.Observable
import javax.inject.Inject


/*
   支付数据层
 */
class PayRepository @Inject constructor() {

    /*
        获取支付宝支付签名
     */
    fun getPaySign(orderId: Int, totalPrice: Long): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java).getPaySign(GetPaySignReq(orderId, totalPrice))
    }

    /*
        刷新订单状态已支付
     */
    fun payOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java).payOrder(PayOrderReq(orderId))
    }


}
