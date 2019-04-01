package com.prophet.ecommerce.auth;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.prophet.ecommerce.MainActivity;
import com.prophet.ecommerce.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {


    public SignInFragment() {
        // Required empty public constructor
    }

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    private TextView newUserSignUp;
    private TextView forgotPassword;
    private EditText email;
    private EditText password;
    private ImageButton closeButton;
    private ProgressBar progressBar;
    private Button signInButton;
    private FrameLayout parentFrameLayout;

    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        // Casting layout elements
        newUserSignUp = view.findViewById(R.id.new_user_sign_up);
        forgotPassword = view.findViewById(R.id.sign_in_forgot_password);
        email = view.findViewById(R.id.sign_in_email);
        password = view.findViewById(R.id.sign_in_password);
        closeButton = view.findViewById(R.id.sign_in_close);
        signInButton = view.findViewById(R.id.sign_in_button);
        progressBar = view.findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        // Working with email EditText
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Trigger custom user input method
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // and now password EditText
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Trigger custom user input method
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Now working sign in button
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Trigger email and password
                checkEmailAndPassword();
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Navigating to SignUpFragment
        // when user clicks {@TextView R.id.new_user_sign_up}
        newUserSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });

        // Activating close ImageButton
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Skipping to MainActivity
                mainIntent();
            }
        });

        // Activating forgot password event
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ResetPasswordFragment());
            }
        });
    }

    /**
     * Helper method for Fragment switching
     * @param fragment
     */
    private void setFragment(Fragment fragment){
        if (getActivity() != null){
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            // Setting animation
            fragmentTransaction.setCustomAnimations(R.anim.slidein_from_right, R.anim.slideout_from_left);
            fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }

    /**
     * This method checks that required fields are not
     * empty
     *
     */
    private void checkInputs(){
        if (!TextUtils.isEmpty(email.getText())){
            if (!TextUtils.isEmpty(password.getText())){

                // Enable sign in button
                signInButton.setEnabled(true);
                signInButton.setTextColor(getResources().getColor(R.color.colorPrimary));
            }else {
                // Default sign in button state
                signInButton.setEnabled(false);
                signInButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
            }
        }else {
            // Default sign in button state
            signInButton.setEnabled(false);
            signInButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
        }
    }

    /**
     * This method validates email pattern
     * also signs in with credential
     */
    private void checkEmailAndPassword(){

        if (email.getText().toString().matches(emailPattern)){
            if (password.getText().toString().length() >= 6){
                // Bringing progressbar on foreground
                progressBar.setVisibility(View.VISIBLE);
                // Default sign in button state
                signInButton.setEnabled(false);
                signInButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));

                // Sign in with credential
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    // Navigate to MainActivity
                                    mainIntent();
                                }else {
                                    // Hiding progressbar
                                    progressBar.setVisibility(View.INVISIBLE);
                                    // Enable sign in button
                                    signInButton.setEnabled(true);
                                    signInButton.setTextColor(getResources().getColor(R.color.colorPrimary));
                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            } else {
                Toast.makeText(getActivity(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method  helps Navigating to MainActivity
     * also closing current activity invoking getActivity()
     */
    private void mainIntent(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        try {
            getActivity().finish();
        }catch (NullPointerException e){

        }
    }
}
