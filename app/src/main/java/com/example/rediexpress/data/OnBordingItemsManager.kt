package com.example.rediexpress.data

import com.example.rediexpress.OnBordingItem
import com.example.rediexpress.R

class OnBordingItemsManager {

    private var onBordingItems = ArrayDeque<OnBordingItem>()

    fun init(items: List<OnBordingItem>) {

        items.forEach{
            onBordingItems.add(it)
        }

    }

    fun size() : Int {

        return onBordingItems.size

    }

    fun isEmpty() : Boolean {



        return true
    }

    fun get() : OnBordingItem {



        return OnBordingItem(R.drawable._123, "123", "2132")
    }

}