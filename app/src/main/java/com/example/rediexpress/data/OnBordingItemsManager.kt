package com.example.rediexpress.data

import com.example.rediexpress.OnBordingItem
import com.example.rediexpress.R

class OnBoardingItemsManager() {

    private val onBordingItems: ArrayDeque<OnBordingItem> = ArrayDeque()

    fun isEmpty() : Boolean {
        return onBordingItems.isEmpty()
    }

    fun add(onBordingItem: OnBordingItem) {

        onBordingItems.add(onBordingItem)

    }

    fun size() : Int {
        return onBordingItems.size
    }
    fun get() : OnBordingItem {

        return onBordingItems.removeFirst()

    }

}