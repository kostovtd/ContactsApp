package com.contactsapp.addNewContactScreen;

public class AddNewContactPresenter implements AddNewContactContract.Presenter{

    public static final String TAG = AddNewContactPresenter.class.getSimpleName();

    private final AddNewContactContract.View mNewContactView;


    public AddNewContactPresenter(AddNewContactContract.View mNewContactView) {
        if(mNewContactView == null) {
            throw new NullPointerException("mNewContactView");
        }

        this.mNewContactView = mNewContactView;

    }


    @Override
    public void createNewContact() {

    }

    @Override
    public void cancelNewContact() {

    }
}
