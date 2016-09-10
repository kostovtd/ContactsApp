package com.contactsapp.contactsScreen;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.contactsapp.R;
import com.contactsapp.contactsScreen.allContacts.AllContactsFragment;
import com.contactsapp.contactsScreen.favoriteContacts.FavoriteContactsFragment;

public class ContactsPagerAdapter extends FragmentStatePagerAdapter{

    private static final int NUMBER_OF_FRAGMENTS = 2;

    private AllContactsFragment allContactsFragment;
    private FavoriteContactsFragment favoriteContactsFragment;
    private Context context;

    public ContactsPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);

        if(fragmentManager == null) {
            throw new NullPointerException("fragmentManager cannot be null");
        } else if(context == null) {
            throw new NullPointerException("context cannot be null");
        }

        this.context = context;

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
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return context.getString(R.string.contacts_favorites_tab_title);
            case 1: return context.getString(R.string.contacts_all_contacts_tab_title);
        }
        return "";
    }

    @Override
    public int getCount() {
        return NUMBER_OF_FRAGMENTS;
    }
}
