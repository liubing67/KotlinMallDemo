package com.abing.ordercenter.event

import com.abing.ordercenter.data.protocol.ShipAddress

/*
    选择收货人信息事件
 */
class SelectAddressEvent(val address: ShipAddress)
