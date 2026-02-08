package com.ueesrg.grocerymarketkotlin.ui.detail

import android.view.View
import com.ueesrg.grocerymarketkotlin.base.BasePresenter
import com.ueesrg.grocerymarketkotlin.base.BaseView
import com.ueesrg.grocerymarketkotlin.model.response.checkout.CheckoutResponse
import com.ueesrg.grocerymarketkotlin.model.response.home.HomeResponse
import com.ueesrg.grocerymarketkotlin.model.response.login.LoginResponse

interface PaymentContract {

    interface View: BaseView {
        fun onCheckoutSuccess(checkoutResponse: CheckoutResponse, view: android.view.View)
        fun onCheckoutFailed(message:String)

    }

    interface Presenter : PaymentContract, BasePresenter {
        fun getCheckout(productId:String, userId:String, quantity:String, total:String, view: android.view.View)
    }
}