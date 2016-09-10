package com.contactsapp.contactsScreen;


import com.contactsapp.BasePresenter;
import com.contactsapp.models.Contact;

import java.util.List;

public interface ContactsContract {

    interface View {

        void setLoadingIndicator(boolean active);

        void showContacts(List<Contact> contacts);

        boolean isActive();
    }


    interface Presenter {

        void loadContacts();

        void openAddNewContact();
    }

}
