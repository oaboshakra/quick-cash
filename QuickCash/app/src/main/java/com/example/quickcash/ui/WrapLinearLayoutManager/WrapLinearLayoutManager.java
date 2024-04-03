package com.example.quickcash.ui.WrapLinearLayoutManager;

import android.content.Context;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Custom LinearLayoutManager class that allows wrapping content in a RecyclerView.
 */
public class WrapLinearLayoutManager extends LinearLayoutManager {

    /**
     * Constructs a new WrapLinearLayoutManager.
     *
     * @param context       The context being worked with.
     * @param orientation   Layout orientation. Should be LinearLayoutManager.VERTICAL or LinearLayoutManager.HORIZONTAL.
     * @param reverseLayout Whether the layout should be reversed.
     */
    public WrapLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    /**
     * Overridden method to layout children in the RecyclerView.
     * Catches IndexOutOfBoundsException that may occur during layout to prevent crashes.
     *
     * @param recycler The Recycler to use for managing child views.
     * @param state    Transitional state of RecyclerView.
     */
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            // If there is, in fact, an IndexOutOfBoundsException, it will be logged.
            Log.e("WrapLinearLayoutManager", "Index Out Of Bound Exception in RecyclerView");
        }
    }
}
