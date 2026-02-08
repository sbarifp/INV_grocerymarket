package com.ueesrg.grocerymarketkotlin.ui.order.pastorders

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ueesrg.grocerymarketkotlin.R
import com.ueesrg.grocerymarketkotlin.model.dummy.ProfileMenuModel
import com.ueesrg.grocerymarketkotlin.model.response.transaction.Data
import com.ueesrg.grocerymarketkotlin.ui.order.detailsorders.OrdersDetailActivity
import com.ueesrg.grocerymarketkotlin.ui.order.inprogress.InprogressAdapter
import com.ueesrg.grocerymarketkotlin.ui.profile.ProfileMenuAdapter
import kotlinx.android.synthetic.main.fragment_profile_account.*

class PastordersFragment : Fragment(), PastordersAdapter.ItemAdapterCallback {

    private var adapter: PastordersAdapter?=null
    var pastordersList:ArrayList<Data>? = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pastorders, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        pastordersList = arguments?.getParcelableArrayList("data")

        if (!pastordersList.isNullOrEmpty()) {
            adapter= PastordersAdapter(pastordersList!!, this)
            val layoutManager = LinearLayoutManager(activity)
            rcList.layoutManager = layoutManager
            rcList.adapter = adapter
        }
    }

    override fun onClick(v: View, data: Data) {
        val detail = Intent(activity, OrdersDetailActivity::class.java).putExtra("data", data)
        startActivity(detail)
    }

}