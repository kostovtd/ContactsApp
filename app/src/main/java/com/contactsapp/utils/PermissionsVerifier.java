package com.contactsapp.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

public class PermissionsVerifier {
    private final Context mContext;


    public PermissionsVerifier(Context mContext) {
        this.mContext = mContext;
    }

    public boolean hasMissingPermissions(String ... permissions){
        for (String permission : permissions) {
            if(permissionMissing(permission)){
                return true;
            }
        }
        return false;
    }

    public boolean permissionMissing(String permission){
        return ContextCompat.checkSelfPermission(mContext,permission) == PackageManager.PERMISSION_DENIED;
    }
}
