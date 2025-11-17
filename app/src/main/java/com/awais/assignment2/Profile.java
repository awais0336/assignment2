package com.awais.assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Profile extends Fragment {

    TextView tvName, tvEmail;

    public Profile() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, container, false);

        tvName = view.findViewById(R.id.tvName);
        tvEmail = view.findViewById(R.id.tvEmail);

        SharedPreferences sp = getActivity().getSharedPreferences("myprefs", Context.MODE_PRIVATE);

        String name = sp.getString(getString(R.string.pref_username_key), "No Name Saved");
        String email = sp.getString(getString(R.string.pref_email_key), "No Email Saved");

        tvName.setText("Username: " + name);
        tvEmail.setText("Email: " + email);

        return view;
    }
}
