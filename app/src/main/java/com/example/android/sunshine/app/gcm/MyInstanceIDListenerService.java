package com.example.android.sunshine.app.gcm;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by ramana on 26/1/16.
 */

public class MyInstanceIDListenerService  extends InstanceIDListenerService {

    private static final String TAG = "MyInstanceIDLS";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. This call is initiated by the
     * InstanceID provider.
     */
    @Override
    public void onTokenRefresh() {
        Log.i(TAG,"Calling RegistrationIntentService");
        Intent intent = new Intent(this,RegistrationIntentService.class);
        startService(intent);
    }
}

