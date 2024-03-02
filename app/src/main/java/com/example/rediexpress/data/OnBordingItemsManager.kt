package com.example.rediexpress.data

import com.example.rediexpress.OnBordingItem
import com.example.rediexpress.R

class OnBoardingItemsManager() {

    private val onBordingItems: ArrayDeque<OnBordingItem> = ArrayDeque()

    fun isEmpty() : Boolean {
        return true
    }

    fun add(onBordingItem: OnBordingItem) {

        onBordingItems.add(onBordingItem)

    }

    fun size() : Int {
        return 2
    }
    fun get() : OnBordingItem {

        return OnBordingItem(R.drawable._123, "123123", "12312333312")

    }

}