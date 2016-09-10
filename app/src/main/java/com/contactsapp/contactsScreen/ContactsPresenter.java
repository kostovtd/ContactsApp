package com.contactsapp.contactsScreen;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import com.contactsapp.addNewContactScreen.AddNewContactActivity;
import com.contactsapp.models.Contact;


import java.util.ArrayList;
import java.util.List;

public class ContactsPresenter implements ContactsContract.Presenter{

    public static final String TAG = ContactsPresenter.class.getSimpleName();

    private final ContactsContract.View mContactsView;

    private List<Contact> contactList;

    public ContactsPresenter(ContactsContract.View mContactsView) {
        if(mContactsView == null) {
            throw new NullPointerException("mContactsView can not be NULL");
        }

        this.mContactsView = mContactsView;
    }

    @Override
    public void loadContacts(Context context) {
        Log.d(TAG, "loadContacts hit");
        contactList = loadContactsFromPhone(context);
        Log.d(TAG, "contacts size:" + contactList.size());
    }

    @Override
    public void openAddNewContact(Context context) {
        if(context == null) {
            throw new NullPointerException("context can not be NULL");
        }

        Intent addNewContactIntent = new Intent(context, AddNewContactActivity.class);
        context.startActivity(addNewContactIntent);
    }


    private List<Contact> loadContactsFromPhone(Context context) {
        List<Contact> resultList = new ArrayList<>();

        try {
            String [] PROJECTION = new String []  {
                    Contacts._ID,
                    Contacts.DISPLAY_NAME,
                    Phone.NUMBER
            };

            Cursor cursor = context.getContentResolver().query(Phone.CONTENT_URI, PROJECTION,
                    null, null, null);

            if(cursor != null && cursor.moveToFirst()) {
                String contactName;
                String contactPhone;

                do {
                    contactName = cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME));
                    contactPhone = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));

                    contactPhone = contactPhone.replaceAll("\\D", "");
                    contactName = contactName.replaceAll("&", "");
                    contactName = contactName.replace("|", "");

                    Contact contact = new Contact();
                    contact.setPhoneNumber(contactPhone);

                    resultList.add(contact);
                } while(cursor.moveToNext());

                cursor.close();
            }
        } catch (NullPointerException npe) {
            mContactsView.showErrorMessage("TEST");
        }

        return resultList;
    }
}
