package com.example.cmdf25.ui.home;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cmdf25.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ConstraintLayout constraintLayout = binding.homeLayout;
        AnimationDrawable anim = (AnimationDrawable) constraintLayout.getBackground();
        anim.setEnterFadeDuration(2500);
        anim.setExitFadeDuration(5000);
        anim.start();

        final TextView welcomeText = binding.welcomeText;
        homeViewModel.getWelcomeText().observe(getViewLifecycleOwner(), welcomeText::setText);

        final TextView dateText = binding.dateText;
        homeViewModel.getDateText().observe(getViewLifecycleOwner(), dateText::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}