package com.contactsapp.contactsScreen;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.contactsapp.R;
import com.contactsapp.models.Contact;
import com.contactsapp.utils.PermissionsVerifier;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContactsActivity extends AppCompatActivity implements ContactsContract.View{

    public static final String TAG = ContactsActivity.class.getSimpleName();

    private static final String PCKG_URL_SCHEME = "package";
    private static final int PERMISSION_REQUEST_CODE = 0;
    private static final String[] PERMISSIONS = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS
    };

    private boolean mDeniedNever = false;
    private Unbinder unbinder;
    private ContactsContract.Presenter presenter;
    private ContactsPagerAdapter contactsPagerAdapter;
    private AlertDialog mPermissionsDialog;
    private PermissionsVerifier permissionsVerifier;

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
        permissionsVerifier = new PermissionsVerifier(this);

        contactsPagerAdapter = new ContactsPagerAdapter(getSupportFragmentManager(), this);
        contactsViewPager.setAdapter(contactsPagerAdapter);
        contactsTabLayout.setupWithViewPager(contactsViewPager);
    }



    @Override
    protected void onResume() {
        Log.d(TAG, "onResume hit");
        super.onResume();

        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion >= Build.VERSION_CODES.LOLLIPOP) {
            if (permissionsVerifier.hasMissingPermissions(PERMISSIONS)) {
                requestPermissions(PERMISSIONS);
            } else {
                presenter.loadContacts(this);
            }
        } else {
            presenter.loadContacts(this);
        }
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
                presenter.openAddNewContact(this);
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

    @Override
    public void showErrorMessage(String message) {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE && hasAllPermissionsGranted(grantResults)) {

        } else {
            if (mDeniedNever) {
                showMissingPermissionDialog();
            } else {
                mDeniedNever = true;
            }

        }
    }



    private void showMissingPermissionDialog() {
        if (mPermissionsDialog != null && mPermissionsDialog.isShowing()) {
            return;
        }
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ContactsActivity.this);
        dialogBuilder.setTitle(R.string.application_help);
        dialogBuilder.setMessage(R.string.application_help_text);
        dialogBuilder.setNegativeButton(R.string.application_quit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPermissionsDialog.dismiss();
                finish();
            }
        });
        dialogBuilder.setPositiveButton(R.string.application_settings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPermissionsDialog.dismiss();
                startAppSettings();
            }
        });
        mPermissionsDialog = dialogBuilder.create();
        mPermissionsDialog.show();
    }

    private boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }


    private void requestPermissions(String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
    }

    private void startAppSettings() {
        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PCKG_URL_SCHEME + getPackageName()));
        startActivity(intent);
    }
}
