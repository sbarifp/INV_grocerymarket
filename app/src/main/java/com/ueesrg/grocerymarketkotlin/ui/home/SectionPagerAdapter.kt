package com.ueesrg.grocerymarketkotlin.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ueesrg.grocerymarketkotlin.model.response.home.Data
import com.ueesrg.grocerymarketkotlin.ui.home.newexperience.HomeNewExperienceFragment
import com.ueesrg.grocerymarketkotlin.ui.home.popular.HomePopularFragment
import com.ueesrg.grocerymarketkotlin.ui.home.recommended.HomeRecomendedFragment

class SectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    var newExperienceList:ArrayList<Data>? = ArrayList()
    var popularList:ArrayList<Data>? = ArrayList()
    var recommendedList:ArrayList<Data>? = ArrayList()

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "New Experience"
            1 -> "Popular"
            2 -> "Recommended"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        return when(position) {
            0 -> {
                fragment = HomeNewExperienceFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", newExperienceList)
                fragment.arguments = bundle
                return fragment
            }
            1 -> {
                fragment = HomePopularFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", popularList)
                fragment.arguments = bundle
                return fragment
            }
            2 -> {
                fragment = HomeRecomendedFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", recommendedList)
                fragment.arguments = bundle
                return fragment
            }
            else -> {
                fragment = HomeNewExperienceFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", newExperienceList)
                fragment.arguments = bundle
                return fragment
            }
        }
    }

    fun setData(newExperienceListParms : ArrayList<Data>?, popularListParms : ArrayList<Data>?, recomendedListParms : ArrayList<Data>?) {
        newExperienceList = newExperienceListParms
        popularList = popularListParms
        recommendedList = recomendedListParms

    }
}