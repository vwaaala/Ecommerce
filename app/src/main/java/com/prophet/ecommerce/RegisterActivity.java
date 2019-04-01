package com.prophet.ecommerce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.prophet.ecommerce.auth.SignInFragment;

public class RegisterActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initializing FrameLayout
        frameLayout = findViewById(R.id.register_framelayout);

        // Changing Fragment based on use cases
        // Default Fragment is {@link SignInFragment()}
        setFragment(new SignInFragment());
    }


    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}
