package com.ueesrg.grocerymarketkotlin.ui.order.detailsorders

import com.ueesrg.grocerymarketkotlin.base.BasePresenter
import com.ueesrg.grocerymarketkotlin.base.BaseView

interface OrdersDetailContract {
    interface View : BaseView {
        fun onUpdateTransactionSuccess(message: String)
        fun onUpdateTransactionFailed(message: String)
    }

    interface Presenter : OrdersDetailContract, BasePresenter {
        fun getUpdateTransaction(id:String, status:String)
    }
}