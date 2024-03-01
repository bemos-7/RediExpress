package com.example.rediexpress

import com.example.rediexpress.data.OnBordingItemsManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class OnBordingItemsManagerTest {

    private var onBordingManager = OnBordingItemsManager()

    @Test
    fun imageAndTextGet() {

        val expected = OnBordingItem(R.drawable.radio_selected, "test", "testtest")

        val listItems = listOf<OnBordingItem>(OnBordingItem(R.drawable._123, "123123", "1231222233") ,expected)

        onBordingManager.init(listItems)

        val actual = onBordingManager.get()

        Assert.assertEquals(actual, expected)
    }

    @Test
    fun correctGetImageOnBordingItem() {

        val expected = 0

        val listItems = listOf<OnBordingItem>(OnBordingItem(R.drawable._123, "123123", "1231222233"))

        onBordingManager.init(listItems)

        onBordingManager.get()

        val actual = onBordingManager.size()

        Assert.assertEquals(actual, expected)

    }


    @Before
    fun beforeEach() {

        onBordingManager = OnBordingItemsManager()

    }

}