package com.ueesrg.grocerymarketkotlin.ui.home

import com.ueesrg.grocerymarketkotlin.base.BasePresenter
import com.ueesrg.grocerymarketkotlin.base.BaseView
import com.ueesrg.grocerymarketkotlin.model.response.home.HomeResponse
import com.ueesrg.grocerymarketkotlin.model.response.login.LoginResponse

interface HomeContract {

    interface View: BaseView {
        fun onHomeSuccess(homeResponse: HomeResponse)
        fun onHomeFailed(message:String)

    }

    interface Presenter : HomeContract, BasePresenter {
        fun getHome()
    }
}