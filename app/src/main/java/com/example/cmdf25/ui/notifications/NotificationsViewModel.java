package com.example.cmdf25.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> mName;
    private final MutableLiveData<Integer> mAge;
    private final MutableLiveData<String[]> mAllergies;

    public NotificationsViewModel() {
        mName = new MutableLiveData<>();
        mAge = new MutableLiveData<>();
        mAllergies = new MutableLiveData<>();

        mName.setValue("emmy fong");
        mAge.setValue(55);
        mAllergies.setValue(new String[] {"Dairy", "Peanuts", "Seafood"});
    }

    public LiveData<String> getName() {
        return mName;
    }

    public LiveData<Integer> getAge() {
        return mAge;
    }

    public LiveData<String[]> getAllergies() {
        return mAllergies;
    }

}