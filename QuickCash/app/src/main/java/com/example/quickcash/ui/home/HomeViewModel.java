package com.example.quickcash.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel for the HomeFragment.
 * This ViewModel holds and manages the data related to the HomeFragment.
 */
public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    /**
     * Constructor for the HomeViewModel.
     * Initializes the LiveData with a default value.
     */
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    /**
     * Get the LiveData object containing the text to be displayed in the home fragment.
     *
     * @return LiveData object containing the text for the home fragment.
     */
    public LiveData<String> getText() {
        return mText;
    }
}
