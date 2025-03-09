package com.example.cmdf25.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> welcomeText;
    private final MutableLiveData<String> dateText;

    public HomeViewModel() {
        //get welcoming text
        String username = "username"; //TODO access database for username
        welcomeText = new MutableLiveData<>();
        welcomeText.setValue("Welcome " + username + "!");

        //get current date text
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        String formattedDate = dateFormat.format(currentDate);
        dateText = new MutableLiveData<>();
        dateText.setValue("Today is " + formattedDate);

    }

    public LiveData<String> getWelcomeText() {
        return welcomeText;
    }

    public LiveData<String> getDateText() {
        return dateText;
    }
}