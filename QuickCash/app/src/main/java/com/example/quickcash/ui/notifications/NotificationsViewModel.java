package com.example.quickcash.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel for the NotificationsFragment.
 * This ViewModel provides data for displaying notifications.
 */
public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    /**
     * Constructor for NotificationsViewModel.
     * Initializes the MutableLiveData with a default value.
     */
    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    /**
     * Retrieves the LiveData object containing the notification text.
     *
     * @return LiveData object containing the notification text.
     */
    public LiveData<String> getText() {
        return mText;
    }
}
