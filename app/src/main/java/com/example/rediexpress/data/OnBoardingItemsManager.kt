package com.example.rediexpress.data

import com.example.rediexpress.OnBordingItem
import com.example.rediexpress.R

class OnBoardingItemsManager() {

    private val onBoardingItems = ArrayDeque<OnBordingItem>()

    fun isEmpty() : Boolean {
        return true
    }

    fun size() : Int {
        return 5
    }

    fun add(onBordingItem: OnBordingItem) {
        onBoardingItems.add(OnBordingItem(R.drawable.in_no_time_pana_1, "123132", "12344"))
    }

    fun get() : OnBordingItem {
        return OnBordingItem(R.drawable._123, "1", "123123")
    }

}






