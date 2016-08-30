package com.contactsapp.contactsScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.contactsapp.R;
import com.contactsapp.models.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContactsActivity extends AppCompatActivity implements ContactsContract.View{

    public static final String TAG = ContactsActivity.class.getCanonicalName();

    private Unbinder unbinder;
    private ContactsContract.Presenter presenter;

    @BindView(R.id.noContactsTv)
    private TextView noContactsTv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCrate hit");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        unbinder = ButterKnife.bind(this);
    }



    @Override
    protected void onResume() {
        Log.d(TAG, "onResume hit");
        super.onResume();
        presenter.start();
    }




    @Override
    protected void onPause() {
        Log.d(TAG, "onPause hit");
        super.onPause();
        presenter.start();
    }



    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy hit");
        unbinder.unbind();
        super.onDestroy();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contacts, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addNewContact:
                presenter.openAddNewContact();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }


    @Override
    public void showNoContacts() {
        noContactsTv.setVisibility(View.VISIBLE);
    }


    @Override
    public void showContacts(List<Contact> contacts) {

    }


    @Override
    public boolean isActive() {
        return false;
    }


    @Override
    public void setPresenter(ContactsContract.Presenter presenter) {
        if(presenter != null)
            this.presenter = presenter;
    }
}
