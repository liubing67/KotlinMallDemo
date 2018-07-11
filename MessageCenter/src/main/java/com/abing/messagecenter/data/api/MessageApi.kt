package com.abing.messagecenter.data.api

import com.abing.baselibrary.data.protocol.BaseResp
import rx.Observable
import com.abing.messagecenter.data.protocol.Message
import retrofit2.http.POST

/*
    消息 接口
 */
interface MessageApi {

    /*
        获取消息列表
     */
    @POST("msg/getList")
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>>

}
