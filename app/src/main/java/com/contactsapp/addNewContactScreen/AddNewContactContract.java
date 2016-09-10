package com.contactsapp.addNewContactScreen;


public interface AddNewContactContract {

    interface View {
        void setLoadingIndicator(boolean active);

        void showSuccessMessage(String message);

        void showErrorMessage(String message);
    }

    interface Presenter {
        void createNewContact();

        void cancelNewContact();
    }
}
