package com.example.myfirstapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Activity;

public class ResultFragment extends Fragment {
    final static String ARG_MESSAGE = "message";
    String mMessage = "";
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

	// If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mMessage = savedInstanceState.getString(ARG_MESSAGE);
        }

	return inflater.inflate(R.layout.result_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateText(args.getString(ARG_MESSAGE));
        } else if (mMessage != "") {
            // Set article based on saved instance state defined during onCreateView
            updateText(mMessage);
        }
    }
    
    public void updateText(String message) {
        TextView textView = (TextView) getActivity().findViewById(R.id.txt_entered_text);
        textView.setTextSize(40);
        textView.setText(message);
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
	super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putString(ARG_MESSAGE, mMessage);
    }

}
