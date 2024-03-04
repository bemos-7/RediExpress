package com.example.rediexpress


import com.example.rediexpress.data.OnBoardingItemsManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class OnBoardingItemsManagerTest() {

    private var onBoardingItemsManager = OnBoardingItemsManager()

    @Before
    fun beforeEach() {
        onBoardingItemsManager = OnBoardingItemsManager()
    }

    @Test
    fun ImageAndTextGet() {

        val expected = OnBordingItem(R.drawable._123, "123123", "00038")

        onBoardingItemsManager.add(expected)
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "45", "0003338"))

        val actual = onBoardingItemsManager.get()

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun sizeChange() {
        val expected = 3

        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "112", "12333"))
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "11", "1233"))
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "12", "133"))
        onBoardingItemsManager.add(OnBordingItem(R.drawable._123, "12", "133"))

        onBoardingItemsManager.get()

        val actual = onBoardingItemsManager.size()

        Assert.assertEquals(expected, actual)
    }

}
