package com.ueesrg.grocerymarketkotlin.ui.order

import com.ueesrg.grocerymarketkotlin.base.BasePresenter
import com.ueesrg.grocerymarketkotlin.base.BaseView
import com.ueesrg.grocerymarketkotlin.model.response.home.HomeResponse
import com.ueesrg.grocerymarketkotlin.model.response.login.LoginResponse
import com.ueesrg.grocerymarketkotlin.model.response.transaction.TransactionResponse

interface OrderContract {

    interface View: BaseView {
        fun onTransactionSuccess(transactionResponse: TransactionResponse)
        fun onTransactionFailed(message:String)

    }

    interface Presenter : OrderContract, BasePresenter {
        fun getTransaction()
    }
}