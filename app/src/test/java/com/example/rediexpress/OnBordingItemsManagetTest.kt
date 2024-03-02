package com.example.rediexpress

import com.example.rediexpress.data.OnBoardingItemsManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class OnBordingItemsManagetTest() {

    private var onBoardingItemsManager: OnBoardingItemsManager = OnBoardingItemsManager()

    @Before
    fun beforeEach() {
        onBoardingItemsManager = OnBoardingItemsManager()
    }


    @Test
    fun imageAndTextGet() {

        val expected = OnBordingItem(R.drawable._123, "133123", "1232333")

        onBoardingItemsManager.add(expected)
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "qwerwere", "sefsdfsd"))

        val actual = onBoardingItemsManager.get()

        Assert.assertEquals(expected, actual)

    }

    @Test
    fun sizeChange() {

        val expected = 3

        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "1", "1"))
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "2", "2"))
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "3", "1"))
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "4", "1"))

        onBoardingItemsManager.get()

        val actual = onBoardingItemsManager.size()

        Assert.assertEquals(expected, actual)

    }

}