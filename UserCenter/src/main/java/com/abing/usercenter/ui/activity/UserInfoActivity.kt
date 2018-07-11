package com.abing.usercenter.ui.activity

import android.os.Bundle
import com.abing.baselibrary.common.BaseConstant
import com.abing.baselibrary.ext.onClick
import com.abing.baselibrary.ui.activity.BaseTakePhotoActivity
import com.abing.baselibrary.utils.GlideUtils
import com.abing.usercenter.R
import com.abing.usercenter.data.protocol.UserInfo
import com.abing.usercenter.injection.component.DaggerUserComponent
import com.abing.usercenter.injection.module.UserModule
import com.abing.usercenter.presenter.UserInfoPresenter
import com.abing.usercenter.presenter.view.UserInfoView
import com.jph.takephoto.model.TResult
import com.qiniu.android.http.ResponseInfo
import com.qiniu.android.storage.UpCompletionHandler
import com.qiniu.android.storage.UploadManager
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast
import org.json.JSONObject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:18
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:18
 * 修改备注：
 * @version
 *
 */
class UserInfoActivity  : BaseTakePhotoActivity<UserInfoPresenter>(), UserInfoView {

    private val mUploadManager: UploadManager by lazy { UploadManager() }

    private var mLocalFileUrl:String? = null
    private var mRemoteFileUrl:String? = null

    private var mUserIcon:String? = ""
    private var mUserName:String? = null
    private var mUserMobile:String? = null
    private var mUserGender:String? = null
    private var mUserSign:String? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        initView()
        initData()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mUserIconView.onClick {
            showAlertView()
        }

        mHeaderBar.getRightView().onClick {
            mPresenter.editUser(mRemoteFileUrl!!,
                    mUserNameEt.text?.toString()?:"",
                    if(mGenderMaleRb.isChecked) "0" else "1",
                    mUserSignEt.text?.toString()?:""
            )
        }
    }

    /*
        初始化数据
     */
    private fun initData() {
//        mUserIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
//        mUserName = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
//        mUserMobile = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_MOBILE)
//        mUserGender = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_GENDER)
//        mUserSign = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_SIGN)

        mRemoteFileUrl = mUserIcon
        if (mUserIcon != ""){
            GlideUtils.loadUrlImage(this,mUserIcon!!,mUserIconIv)
        }
        mUserNameEt.setText(mUserName)
        mUserMobileTv.text = mUserMobile

        if (mUserGender == "0") {
            mGenderMaleRb.isChecked = true
        }
        else {
            mGenderFemaleRb.isChecked = true
        }

        mUserSignEt.setText(mUserSign)

    }
    /*
            获取图片成功回调
         */
    override fun takeSuccess(result: TResult?) {
        mLocalFileUrl=result?.image?.compressPath
        mPresenter.getUploadToken()
    }
    /*
      获取上传凭证回调
   */
    override fun onGetUploadTokenResult(result: String) {
        mUploadManager.put(mLocalFileUrl,null,result,object :UpCompletionHandler{
            override fun complete(key: String?, info: ResponseInfo?, response: JSONObject?) {
                mRemoteFileUrl=BaseConstant.IMAGE_SERVER_ADDRESS+response?.get("hash")

                GlideUtils.loadImage(this@UserInfoActivity,mRemoteFileUrl!!,mUserIconIv)
            }
        },null)
    }

    /*
        编辑用户资料回调
     */
    override fun onEditUserResult(result: UserInfo) {
        toast("修改成功")
//        UserPrefsUtils.putUserInfo(result)
    }

    /*
       Dagger注册
    */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }
}