package com.ueesrg.grocerymarketkotlin.ui.auth.signin

import com.ueesrg.grocerymarketkotlin.base.BasePresenter
import com.ueesrg.grocerymarketkotlin.base.BaseView
import com.ueesrg.grocerymarketkotlin.model.response.login.LoginResponse

interface SigninContract {

    interface View: BaseView {
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message:String)

    }

    interface Presenter : SigninContract, BasePresenter {
        fun subimtLogin(email:String, password:String)
    }
}