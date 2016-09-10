package com.contactsapp.addNewContactScreen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.contactsapp.R;

public class AddNewContactActivity extends AppCompatActivity implements AddNewContactContract.View {

    public static final String TAG = AddNewContactActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate hit");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
    }


    @Override
    protected void onResume() {
        Log.d(TAG, "onResume hit");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG, "onPause hit");
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy hit");
        super.onDestroy();
    }


    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showSuccessMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }
}
