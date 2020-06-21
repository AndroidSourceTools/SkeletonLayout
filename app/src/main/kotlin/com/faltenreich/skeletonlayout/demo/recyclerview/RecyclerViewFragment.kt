package com.faltenreich.skeletonlayout.demo.recyclerview

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.faltenreich.skeletonlayout.demo.BuildConfig
import com.faltenreich.skeletonlayout.demo.R
import com.faltenreich.skeletonlayout.demo.MainPagerFragment
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class RecyclerViewFragment : MainPagerFragment(R.layout.fragment_recyclerview, "RecyclerView") {

    override lateinit var skeleton: Skeleton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = RecyclerViewListItem.DEMO

        val listAdapter = RecyclerViewAdapter(items)
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = listAdapter

        val skeletonItemSize = if (BuildConfig.isDemoMode) items.size else SKELETON_ITEM_COUNT
        skeleton = list.applySkeleton(R.layout.list_item, skeletonItemSize).apply { showSkeleton() }
    }

    companion object {
        private const val SKELETON_ITEM_COUNT = 30
    }
}