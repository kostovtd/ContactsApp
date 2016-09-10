package com.contactsapp.contactsScreen;


import android.util.Log;

public class ContactsPresenter implements ContactsContract.Presenter{

    public static final String TAG = ContactsPresenter.class.getSimpleName();

    private final ContactsContract.View mContactsView;

    public ContactsPresenter(ContactsContract.View mContactsView) {
        if(mContactsView == null) {
            throw new NullPointerException("mContactsView can not be NULL");
        }

        this.mContactsView = mContactsView;
    }

    @Override
    public void loadContacts() {
        Log.d(TAG, "loadContacts hit");
    }

    @Override
    public void openAddNewContact() {
        Log.d(TAG, "openAddNewContact hit");
    }


}
