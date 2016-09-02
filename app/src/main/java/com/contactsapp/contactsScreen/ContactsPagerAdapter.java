package com.contactsapp.contactsScreen;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ContactsPagerAdapter extends FragmentStatePagerAdapter{

    private static final int NUMBER_OF_FRAGMENTS = 2;

    private AllContactsFragment allContactsFragment;
    private FavoriteContactsFragment favoriteContactsFragment;

    public ContactsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        favoriteContactsFragment = FavoriteContactsFragment.newInstance();
        allContactsFragment = AllContactsFragment.newInstance();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return favoriteContactsFragment;
            case 1: return allContactsFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return NUMBER_OF_FRAGMENTS;
    }
}
