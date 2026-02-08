package com.ueesrg.grocerymarketkotlin.ui.auth.signup

import android.net.Uri
import android.view.View
import com.ueesrg.grocerymarketkotlin.base.BasePresenter
import com.ueesrg.grocerymarketkotlin.base.BaseView
import com.ueesrg.grocerymarketkotlin.model.request.RegisterRequest
import com.ueesrg.grocerymarketkotlin.model.response.login.LoginResponse

interface SignupContract {

    interface View: BaseView {
        fun onRegisterSuccess(loginResponse: LoginResponse, view:android.view.View)
        fun onRegisterPhotoSuccess(view:android.view.View)
        fun onRegisterFailed(message:String)

    }

    interface Presenter : SignupContract, BasePresenter {
        fun submitRegister(registerRequest: RegisterRequest, view:android.view.View)
        fun submitPhotoRegister(filePath:Uri, view:android.view.View)
    }
}