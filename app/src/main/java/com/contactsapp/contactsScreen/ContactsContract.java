package com.contactsapp.contactsScreen;


import com.contactsapp.BasePresenter;
import com.contactsapp.BaseView;
import com.contactsapp.models.Contact;

import java.util.List;

public interface ContactsContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showNoContacts();

        void showContacts(List<Contact> contacts);

        boolean isActive();
    }


    interface Presenter extends BasePresenter {

        void loadContacts();

        void openContactDetails(Contact contact);

        void openAddNewContact();
    }

}
