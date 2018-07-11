package com.kotlin.message.data.repository


import com.abing.baselibrary.data.net.RetrofitFactory
import com.abing.baselibrary.data.protocol.BaseResp
import javax.inject.Inject

import rx.Observable
import com.abing.messagecenter.data.api.MessageApi
import com.abing.messagecenter.data.protocol.Message


/*
   消息数据层
 */
class MessageRepository @Inject constructor() {

    /*
        获取消息列表
     */
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>> {
        return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }



}
