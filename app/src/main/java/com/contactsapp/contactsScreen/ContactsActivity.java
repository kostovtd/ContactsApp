package com.contactsapp.contactsScreen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.contactsapp.R;
import com.contactsapp.models.Contact;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContactsActivity extends AppCompatActivity implements ContactsContract.View{

    public static final String TAG = ContactsActivity.class.getSimpleName();

    private Unbinder unbinder;
    private ContactsContract.Presenter presenter;
    private ContactsPagerAdapter contactsPagerAdapter;

    @BindView(R.id.contacts_view_pager)
    ViewPager contactsViewPager;

    @BindView(R.id.contacts_tab_layout)
    TabLayout contactsTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCrate hit");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        unbinder = ButterKnife.bind(this);

        presenter = new ContactsPresenter(this);

        contactsPagerAdapter = new ContactsPagerAdapter(getSupportFragmentManager(), this);
        contactsViewPager.setAdapter(contactsPagerAdapter);
        contactsTabLayout.setupWithViewPager(contactsViewPager);
    }



    @Override
    protected void onResume() {
        Log.d(TAG, "onResume hit");
        super.onResume();
    }




    @Override
    protected void onPause() {
        Log.d(TAG, "onPause hit");
        super.onPause();
    }



    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy hit");
        super.onDestroy();
        unbinder.unbind();
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
    public void showContacts(List<Contact> contacts) {

    }


    @Override
    public boolean isActive() {
        return false;
    }
}
