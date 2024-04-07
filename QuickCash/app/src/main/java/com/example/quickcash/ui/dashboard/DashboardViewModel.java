package com.example.quickcash.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel for the DashboardFragment.
 * This ViewModel holds and manages the data related to the DashboardFragment.
 */
public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    /**
     * Constructor for the DashboardViewModel.
     * Initializes the LiveData with a default value.
     */
    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    /**
     * Get the LiveData object containing the text to be displayed in the dashboard.
     *
     * @return LiveData object containing the text for the dashboard.
     */
    public LiveData<String> getText() {
        return mText;
    }
}
