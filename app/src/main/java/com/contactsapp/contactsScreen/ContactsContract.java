package com.contactsapp.contactsScreen;

import android.content.Context;

import com.contactsapp.models.Contact;

import java.util.List;

public interface ContactsContract {

    interface View {

        void setLoadingIndicator(boolean active);

        void showContacts(List<Contact> contacts);

        void showErrorMessage(String message);

        boolean isActive();
    }


    interface Presenter {

        void loadContacts(Context context);

        void openAddNewContact(Context context);
    }

}
