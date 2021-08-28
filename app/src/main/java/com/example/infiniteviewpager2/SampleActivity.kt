package com.example.infiniteviewpager2.infinite_view_pager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.infiniteviewpager2.R

class SampleActivity : AppCompatActivity() {

    private lateinit var normalViewPager: ViewPager2
    private lateinit var normalRecyclerAdapter: NormalRecyclerAdapter
    private lateinit var infiniteViewPager: ViewPager2
    private lateinit var infiniteRecyclerAdapter: InfiniteRecyclerAdapter

    private var sampleList: MutableList<Sample> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        // getting the required sample data for filling the ViewPager
        getSampleData()

        // setting up the normal ViewPager for illustration
        normalViewPager = findViewById(R.id.normalViewPager)
        normalRecyclerAdapter = NormalRecyclerAdapter(sampleList)
        normalViewPager.adapter = normalRecyclerAdapter

        // setting up the infinite ViewPager
        infiniteViewPager = findViewById(R.id.infiniteViewPager)
        infiniteRecyclerAdapter = InfiniteRecyclerAdapter(sampleList)
        infiniteViewPager.adapter = infiniteRecyclerAdapter

        // setting the current item of the infinite ViewPager to the actual first element
        infiniteViewPager.currentItem = 1

        // function for registering a callback to update the ViewPager
        // and provide a smooth flow for infinite scroll
        onInfinitePageChangeCallback(sampleList.size + 2)
    }

    private fun getSampleData() {
        sampleList.add(Sample(1, "#91C555"))
        sampleList.add(Sample(2, "#F48E37"))
        sampleList.add(Sample(3, "#FF7B7B"))
    }

    private fun onInfinitePageChangeCallback(listSize: Int) {
        infiniteViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (infiniteViewPager.currentItem) {
                        listSize - 1 -> infiniteViewPager.setCurrentItem(1, false)
                        0 -> infiniteViewPager.setCurrentItem(listSize - 2, false)
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position != 0 && position != listSize - 1) {
                    // pageIndicatorView.setSelected(position-1)
                }
            }
        })
    }

}