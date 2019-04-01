package com.prophet.ecommerce.auth;


import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.prophet.ecommerce.MainActivity;
import com.prophet.ecommerce.R;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    private ImageButton closeButton;
    private EditText emailEditText;
    private EditText nameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signUpButton;
    private ProgressBar progressBar;
    private TextView alreadyMemberSignIn;
    private FrameLayout parentFrameLayout;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // Casting layout elements
        closeButton = view.findViewById(R.id.sign_up_close);
        emailEditText = view.findViewById(R.id.sign_up_email);
        nameEditText = view.findViewById(R.id.sign_up_name);
        passwordEditText = view.findViewById(R.id.sign_up_password);
        confirmPasswordEditText = view.findViewById(R.id.sign_up_password_check);
        signUpButton = view.findViewById(R.id.sign_up_button);
        progressBar = view.findViewById(R.id.progressBar);
        alreadyMemberSignIn = view.findViewById(R.id.sign_up_login);
        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        // Casting FrameLayout from {@Layout activity_register}
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Working with email EditText
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Trigger input validator
                customInputValidator();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Now with name EditText
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Trigger input validator
                customInputValidator();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // with password EditText
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Trigger input validator
                customInputValidator();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // finally confirm password EditText
        confirmPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Trigger input validator
                customInputValidator();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // TODO: send data to Firebase { SignUpFragment sign up button }
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Matching the password input
                checkEmailAndPassword();
            }
        });

        // Navigating to SignInFragment
        // when user clicks {@TextView R.id.sign_up_login}
        alreadyMemberSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User now accessing
                setFragment(new SignInFragment());
            }
        });

        //
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Skips and navigates to MainActivity
                mainIntent();
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
            fragmentTransaction.setCustomAnimations(R.anim.slidein_from_left, R.anim.slideout_from_right);
            fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }

    /**
     *  Custom input validator to validate
     *  user input is not empty
     */
    private void customInputValidator(){
        // Checking email
        if (!TextUtils.isEmpty(emailEditText.getText())){

            // Checking name
            if (!TextUtils.isEmpty(nameEditText.getText())){

                // Checking password with min 6digits length
                if (!TextUtils.isEmpty(passwordEditText.getText()) && passwordEditText.getText().length() >= 6){

                    // Password match
                    if (!TextUtils.isEmpty(confirmPasswordEditText.getText())){

                        // Enable Sign up button
                        // Also changing button text color
                        signUpButton.setEnabled(true);
                        signUpButton.setTextColor(getResources().getColor(R.color.colorPrimary));

                    } else {

                        // Default
                        signUpButton.setEnabled(false);
                        signUpButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
                    }

                } else {
                    if (passwordEditText.getText().length() < 6){
                        passwordEditText.setError("min 6 characters");
                    }
                    // Default
                    signUpButton.setEnabled(false);
                    signUpButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
                }
            }else {

                // Default
                signUpButton.setEnabled(false);
                signUpButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
            }
        }else {

            // Default
            signUpButton.setEnabled(false);
            signUpButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
        }
    }


    /**
     *
     */
    private void checkEmailAndPassword(){
        // Creating error icon
        Drawable errorIcon = getResources().getDrawable(R.drawable.ic_error_outline_white);
        errorIcon.setBounds(0, 0, errorIcon.getIntrinsicWidth(), errorIcon.getIntrinsicHeight());

        // Filter email with proper format
        if (emailEditText.getText().toString().matches(emailPattern)){


            // Matching two password inputs
            if (passwordEditText.getText().toString().equals(confirmPasswordEditText.getText().toString())){

                // ProgressBar is now on Foreground
                progressBar.setVisibility(View.VISIBLE);

                // Sign up button going back to Default mode
                // to prevent user from multiple click event
                signUpButton.setEnabled(false);
                signUpButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));


                // Creating new user
                firebaseAuth.createUserWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){

                                        // Creating map for userdata
                                        // prepare and send data to FirebaseFireStore
                                        Map<Object, String> userData = new HashMap<>();
                                        userData.put("fullname", nameEditText.getText().toString());
                                        firestore.collection("USERS")
                                                .add(userData)
                                                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<DocumentReference> task) {
                                                        if (task.isSuccessful()){
                                                            mainIntent();
                                                        }else {
                                                            // Catch the error to string
                                                            String error = task.getException().getMessage();
                                                            Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });

                                    } else {
                                        // ProgressBar is gone
                                        progressBar.setVisibility(View.INVISIBLE);
                                        // Catch the error to string
                                        String error = task.getException().getMessage();
                                        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();

                                        // Enable Sign up button once again
                                        signUpButton.setEnabled(true);
                                        signUpButton.setTextColor(getResources().getColor(R.color.colorPrimary));
                                    }
                            }
                        });
            } else {

                // In case password does not match
                // print text with icon
                confirmPasswordEditText.setError("Password doesn't match!", errorIcon);
            }
        } else {

            // In case email is invalid
            // print text with icon
            emailEditText.setError("Invalid email!", errorIcon);
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
