package com.prophet.ecommerce.auth;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.prophet.ecommerce.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends Fragment {


    public ResetPasswordFragment() {
        // Required empty public constructor
    }

    private EditText emailEditText;
    private Button submitButton;
    private ProgressBar progressBar;
    private TextView goBack;
    private ViewGroup successContainer;
    private ImageView emailIcon;
    private TextView victory;

    private FrameLayout parentFrameLayout;
    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

        // Casting layout elements
        emailEditText = view.findViewById(R.id.emailEditText);
        submitButton = view.findViewById(R.id.submitButton);
        progressBar = view.findViewById(R.id.progressBar);
        goBack = view.findViewById(R.id.goBackTextVIew);
        successContainer = view.findViewById(R.id.linearLayout);
        emailIcon = view.findViewById(R.id.emailImageView);
        victory = view.findViewById(R.id.successText);

        // Casting frame layout from from parent activity
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        firebaseAuth = FirebaseAuth.getInstance();

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
                checkUserInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Submit button event
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remember that linear layout?
                // Its here
                TransitionManager.beginDelayedTransition(successContainer);
                victory.setVisibility(View.GONE);
                emailIcon.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                // Prevent user from multiple click
                // Bring button to default state
                submitButton.setEnabled(false);
                submitButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));

                // Trigger Firebase password reset method
                firebaseAuth.sendPasswordResetEmail(emailEditText.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                // TODO: password reset email sent
                                // TODO: condition successful
                                // TODO: else error handling with toast
                                 if (task.isSuccessful()){

                                     // TODO Animation here
                                     ScaleAnimation scaleAnimation = new ScaleAnimation(1,0,1,0,emailIcon.getWidth()/2, emailIcon.getHeight()/2);
                                     scaleAnimation.setDuration(100);
                                     scaleAnimation.setInterpolator(new AccelerateInterpolator());
                                     scaleAnimation.setRepeatMode(Animation.REVERSE);
                                     scaleAnimation.setRepeatCount(1);
                                     scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                                         @Override
                                         public void onAnimationStart(Animation animation) {

                                         }

                                         @Override
                                         public void onAnimationEnd(Animation animation) {
                                             victory.setText("Recovery email sent. Please check your inbox.");
                                             victory.setTextColor(getResources().getColor(R.color.white));
                                             TransitionManager.beginDelayedTransition(successContainer);
                                             victory.setVisibility(View.VISIBLE);
                                         }

                                         @Override
                                         public void onAnimationRepeat(Animation animation) {

                                         }
                                     });
                                     victory.startAnimation(scaleAnimation);

                                     // Bringing submit button to default state
                                     submitButton.setEnabled(false);
                                     submitButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
                                 } else {
                                     // todo Animated Error handling example is here
                                     // Handling error
                                     String error = task.getException().getMessage();


                                     // Using victory TextView to display the moron
                                     victory.setText(error);
                                     // giving the moron text, a moron color
                                     victory.setTextColor(getResources().getColor(R.color.error_yellow));
                                     // giving the icon a moron color
                                     emailIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_email_yellow));
                                     // with a little flower transition
                                     TransitionManager.beginDelayedTransition(successContainer);
                                     // Alas !!!
                                     victory.setVisibility(View.VISIBLE);

                                     // Activating button
                                     submitButton.setEnabled(true);
                                     submitButton.setTextColor(getResources().getColor(R.color.colorPrimary));

                                 }
                                // bringing progress bar to default state
                                progressBar.setVisibility(View.GONE);

                            }
                        });
            }
        });


        // Now with go back TextView
        // which is currently positioning at bottom of the screen
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Trigger fragment switch helper
                setFragment(new SignInFragment());
            }
        });

    }



    /**
     * Method checks user input
     * also tweaks submit button behavior
     *
     */
    private void checkUserInputs(){
        if (TextUtils.isEmpty(emailEditText.getText())){
            submitButton.setEnabled(false);
            submitButton.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
        } else {
            submitButton.setEnabled(true);
            submitButton.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
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
}
