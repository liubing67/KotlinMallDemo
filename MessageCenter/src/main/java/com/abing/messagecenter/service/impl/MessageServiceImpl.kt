package com.abing.messagecenter.service.impl


import com.abing.baselibrary.ext.convert
import com.abing.messagecenter.data.protocol.Message
import javax.inject.Inject
import rx.Observable
import com.kotlin.message.data.repository.MessageRepository
import com.abing.messagecenter.service.MessageService

/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository

    /*
        获取消息列表
     */
    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }

}
