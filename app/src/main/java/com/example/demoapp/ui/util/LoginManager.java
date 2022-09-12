package com.example.demoapp.ui.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.demoapp.R;

public class LoginManager {

    public static String USER_NAME_KEY = "USER_NAME_KEY";

    public static boolean validateUserName(EditText editTextUsername, Context context) {
        boolean isValid = false;
        if (TextUtils.isEmpty(editTextUsername.getText().toString()))
            editTextUsername.setError(context.getString(R.string.invalid_username));
        else {
            isValid = true;
        }
        return isValid;

    }

    public static boolean validatePass(EditText editTextPass, Context context) {
        boolean isValid = false;
        if (TextUtils.isEmpty(editTextPass.getText().toString())) {
            editTextPass.setError(context.getString(R.string.invalid_password));
        } else {
            isValid = true;
        }
        return isValid;
    }

}
