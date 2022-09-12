package com.example.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoapp.ui.util.LoginManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {


    private static final String TAG = "RegisterActivity";

    private FirebaseAuth mAuth;
    private Button btnRegister;
    private EditText editTextUsername;
    private EditText editTextPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnRegister = findViewById(R.id.btnRegister);
        editTextUsername = findViewById(R.id.username);
        editTextPass = findViewById(R.id.password);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            updateUI(null);

                        }
                    }
                });
        // [END create_user_with_email]
    }

    private void validate() {

        if (LoginManager.validatePass(editTextPass, this)
                &&
                LoginManager.validateUserName(editTextUsername, this)) {


            createAccount(editTextUsername.getText().toString(), editTextPass.getText().toString());
        }
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra(LoginManager.USER_NAME_KEY, user.getEmail());

            startActivity(intent);
        } else {
            //TODO: toast is not being displayed, maybe because UI thread is not the authentication thread...

            Toast toast = Toast.makeText(this, R.string.register_failed, Toast.LENGTH_LONG);
            toast.show();
        }
    }


}