package com.example.android.sunshine.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

/**
 *
 * Custom EditTextPreference for location
 * preference in settings (Preferences)
 *
 */

public class LocationEditTextPreference extends EditTextPreference {
    static final private int DEFAULT_MINIMUM_LOCATION_LENGTH = 2;
    private int mMinLength;

    public LocationEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LocationEditTextPreference,
                0,0);
        try{
             mMinLength = a.getInteger(R.styleable.LocationEditTextPreference_minLength
                     ,DEFAULT_MINIMUM_LOCATION_LENGTH);
        }finally {
            a.recycle();
        }
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);
        EditText loc_edit_text = getEditText();

        loc_edit_text.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                Dialog dialog = getDialog();
                if(dialog instanceof AlertDialog){
                    AlertDialog alertDialog = (AlertDialog)dialog;
                    Button b_ok = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    if(s.length()<mMinLength)
                        b_ok.setEnabled(false);
                    else
                        b_ok.setEnabled(true);
                }
            }
        });

    }
}
