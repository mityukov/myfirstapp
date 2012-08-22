package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.util.Log;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if(findViewById(R.id.fragment_container) != null) { // if phone
            
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if(savedInstanceState != null) {
                return;
            }

            // Create an instance of FormFragment
            FormFragment formFragment = new FormFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            formFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, formFragment).commit();
        }
    }

    public void onSendMessageClick(View view) {

        //Get message text
        EditText editMessage = (EditText) findViewById(R.id.edit_message);
        String mes = editMessage.getText().toString();

        // Send message text to another fragment, initializing it if necessary
        ResultFragment resFrag = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (resFrag != null) { // this is a tablet
            
            resFrag.updateText(message);
        }
        else { // this is a phone

            ResultFragment newFragment = new ResultFragment();
            Bundle args = new Bundle();
            args.putString(ResultFragment.ARG_MESSAGE, mes);
            newFragment.setArguments(args);
            
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            
            transaction.commit();
        }
    }
}
