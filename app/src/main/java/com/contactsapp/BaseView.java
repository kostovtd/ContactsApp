package com.contactsapp;


public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
