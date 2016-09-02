package com.contactsapp.contactsScreen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contactsapp.R;

public class FavoriteContactsFragment extends Fragment {

    public static final String TAG = FavoriteContactsFragment.class.getSimpleName();



    public static FavoriteContactsFragment newInstance() {

        Bundle args = new Bundle();

        FavoriteContactsFragment fragment = new FavoriteContactsFragment();
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
        View roottView = inflater.inflate(R.layout.fragment_favorite_contacts, container, false);



        return roottView;
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
