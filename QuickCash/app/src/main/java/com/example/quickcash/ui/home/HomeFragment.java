//package com.example.quickcash.ui.home;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.example.quickcash.R;
//import com.example.quickcash.databinding.FragmentHomeBinding;
//
//public class HomeFragment extends Fragment{
//
//    private FragmentHomeBinding binding;
//    Button searchJob;
//    Button postJob;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
////        setupUi();
////        setupListenders();
//
//
//        return root;
//    }
//
////    private void setupListenders() {
////        searchJob.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                 // Naviagte to search job page
////            }
////        });
////        postJob.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // nagivate to post a job page.
////            }
////        });
////    }
////
////    private void setupUi() {
//////        searchJob = searchJob.findViewById(R.id.jobSearchButton);
//////        postJob = postJob.findViewById(R.id.postJobButton);
////    }
////
////
////}