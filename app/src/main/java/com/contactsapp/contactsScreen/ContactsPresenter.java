package com.contactsapp.contactsScreen;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.contactsapp.addNewContactScreen.AddNewContactActivity;

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
    public void openAddNewContact(Context context) {
        if(context == null) {
            throw new NullPointerException("context can not be NULL");
        }

        Intent addNewContactIntent = new Intent(context, AddNewContactActivity.class);
        context.startActivity(addNewContactIntent);
    }


}
