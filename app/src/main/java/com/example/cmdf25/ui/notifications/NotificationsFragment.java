package com.example.cmdf25.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cmdf25.databinding.FragmentNotificationsBinding;

import org.w3c.dom.Text;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView profileName = binding.textProfileName;
        final TextView profileAge = binding.textProfileAge;
        final TextView profileAllergies = binding.textProfileAllergies;

        notificationsViewModel.getName().observe(getViewLifecycleOwner(), profileName::setText);
        notificationsViewModel.getAge().observe(getViewLifecycleOwner(), age -> profileAge.setText("Age: " + age));
        notificationsViewModel.getAllergies().observe(getViewLifecycleOwner(), allergies -> {
            StringBuilder allergiesText = new StringBuilder("Allergies: ");
            if (allergies.length > 0) {
                for (String allergy : allergies) {
                    allergiesText.append(allergy).append(", ");
                }
                allergiesText.setLength(allergiesText.length() - 2); // Remove last comma
            } else {
                allergiesText.append("None");
            }
            profileAllergies.setText(allergiesText.toString());
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}