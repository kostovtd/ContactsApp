package com.contactsapp.contactsScreen.allContacts;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contactsapp.R;

public class AllContactsFragment extends Fragment{

    public static final String TAG = AllContactsFragment.class.getSimpleName();



    public static AllContactsFragment newInstance() {

        Bundle args = new Bundle();

        AllContactsFragment fragment = new AllContactsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate hit");
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView hit");
        View rootView = inflater.inflate(R.layout.fragment_all_contacts, container, false);

        return rootView;
    }


    @Override
    public void onResume() {
        Log.d(TAG, "onResume hit");
        super.onResume();
    }


    @Override
    public void onPause() {
        Log.d(TAG, "onPause hit");
        super.onPause();
    }


    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy hit");
        super.onDestroy();
    }
}
