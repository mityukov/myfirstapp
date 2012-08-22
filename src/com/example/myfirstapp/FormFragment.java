package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.app.Activity;

public class FormFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.form_fragment, container, false);
    }
    
    /*
    @Override
    public void onAttach(Activity activity) {
    
	super.onAttach(activity);
	
	// This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
        
	    mCallback = (OnSendMessageListener) activity;
	}
	catch (ClassCastException e) {
	
	    throw new ClassCastException(activity.toString()
		    + " must implement OnSendMessageListener");
	}
    }
    */
}
