package com.abing.ordercenter.ui.activity

import android.os.Bundle
import com.abing.baselibrary.ext.onClick
import com.abing.baselibrary.ui.activity.BaseMvpActivity
import com.abing.ordercenter.R
import com.abing.ordercenter.common.OrderConstant
import com.abing.ordercenter.data.protocol.ShipAddress
import com.abing.ordercenter.injection.component.DaggerShipAddressComponent
import com.abing.ordercenter.injection.module.ShipAddressModule
import com.abing.ordercenter.presenter.EditShipAddressPresenter
import com.kotlin.order.presenter.view.EditShipAddressView
import kotlinx.android.synthetic.main.activity_edit_address.*
import org.jetbrains.anko.toast

/*
    收货人编辑页面
 */
class ShipAddressEditActivity : BaseMvpActivity<EditShipAddressPresenter>(),EditShipAddressView {

    private var mAddress: ShipAddress? = null

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerShipAddressComponent.builder().activityComponent(mActivityComponent).shipAddressModule(ShipAddressModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_address)

        initView()
        initData()
    }

    /*
        初始化视图
     */
    private fun initView() {

        mSaveBtn.onClick {
            if (mShipNameEt.text.isNullOrEmpty()){
                toast("名称不能为空")
                return@onClick
            }
            if (mShipMobileEt.text.isNullOrEmpty()){
                toast("电话不能为空")
                return@onClick
            }
            if (mShipAddressEt.text.isNullOrEmpty()){
                toast("地址不能为空")
                return@onClick
            }
            if (mAddress == null) {
                mPresenter.addShipAddress(mShipNameEt.text.toString(),
                        mShipMobileEt.text.toString(),
                        mShipAddressEt.text.toString())
            }else{
                mAddress!!.shipUserName = mShipNameEt.text.toString()
                mAddress!!.shipUserMobile = mShipMobileEt.text.toString()
                mAddress!!.shipAddress = mShipAddressEt.text.toString()
                mPresenter.editShipAddress(mAddress!!)
            }
        }
    }

    /*
        初始化数据
     */
    private fun initData() {
        mAddress = intent.getParcelableExtra(OrderConstant.KEY_SHIP_ADDRESS)
        mAddress?.let {
            mShipNameEt.setText(it.shipUserName)
            mShipMobileEt.setText(it.shipUserMobile)
            mShipAddressEt.setText(it.shipAddress)
        }

    }

    /*
        添加收货人信息回调
     */
    override fun onAddShipAddressResult(result: Boolean) {
        toast("添加地址成功")
        finish()
    }

    /*
        修改收货人信息回调
     */
    override fun onEditShipAddressResult(result: Boolean) {
        toast("修改地址成功")
        finish()
    }

}
