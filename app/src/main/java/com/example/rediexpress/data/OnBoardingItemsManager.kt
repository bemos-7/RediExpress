package com.example.rediexpress.data

import com.example.rediexpress.OnBordingItem
import com.example.rediexpress.R

class OnBoardingItemsManager() {

    private val onBoardingItems = ArrayDeque<OnBordingItem>()

    fun isEmpty() : Boolean {
        return onBoardingItems.isEmpty()
    }

    fun size() : Int {
        return onBoardingItems.size
    }

    fun add(onBordingItem: OnBordingItem) {
        onBoardingItems.add(onBordingItem)
    }

    fun get() : OnBordingItem {
        return onBoardingItems.removeFirst()
    }

}






