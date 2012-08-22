package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.app.Activity;

public class FormFragment extends Fragment {
    OnSendMessageListener mCallback;

    interface OnSendMessageListener {
        public void onSendMessage(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.form_fragment, container, false);
    }
    
    @Override
    public void onAttach(Activity activity) {
	super.onAttach(activity);
	
	// This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
	    mCallback = (OnSendMessageListener) activity;
	} catch (ClassCastException e) {
	    throw new ClassCastException(activity.toString()
		    + " must implement OnSendMessageListener");
	}
    }
        
    public void onSendMessageClick(View view) {
        EditText editText = (EditText) getActivity().findViewById(R.id.edit_message);
	String message = editText.getText().toString();
        mCallback.onSendMessage(message);
    }
}
