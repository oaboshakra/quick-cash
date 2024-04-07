package com.example.quickcash.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quickcash.databinding.FragmentNotificationsBinding;

/**
 * A simple {@link Fragment} subclass representing the notifications screen.
 */
public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    /**
     * Initializes the fragment's UI and data.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment.
     * @param container          The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState A Bundle object containing the activity's previously saved state.
     * @return                   The root view of the fragment.
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Initialize the ViewModel for handling notifications
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        // Inflate the layout for this fragment using data binding
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Get the TextView for displaying notifications
        final TextView textView = binding.textNotifications;

        // Observe changes in the notification text and update the TextView accordingly
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    /**
     * Cleans up resources when the fragment's view is destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Release the binding to avoid memory leaks
        binding = null;
    }
}
