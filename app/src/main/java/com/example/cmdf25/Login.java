package com.example.cmdf25;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cmdf25.databinding.ActivityMainBinding;  // Make sure this is correct for your project
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    Button google_sign_in_button;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    GoogleSignInOptions gso;
    //GoogleSignInClient gsc;

    int RC_SIGN_IN = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        google_sign_in_button = findViewById(R.id.google_sign_in_button);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_clident_id))
                .requestEmail().build();

    }
}
