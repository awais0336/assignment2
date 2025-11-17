package com.awais.assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends Fragment {

    EditText etName, etEmail;
    Button btnSave, btnReset;

    public Settings() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.user_settings, container, false);

        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        btnSave = view.findViewById(R.id.btnSave);
        btnReset = view.findViewById(R.id.btnReset);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {
                    Toast.makeText(getActivity(), "Please fill everything!", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences sp = getActivity().getSharedPreferences("myprefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString(getString(R.string.pref_username_key), name);
                editor.putString(getString(R.string.pref_email_key), email);

                editor.apply();

                Toast.makeText(getActivity(), "Preferences Saved Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getActivity().getSharedPreferences("myprefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.clear();
                editor.apply();

                Toast.makeText(getActivity(), "Preferences Reset!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
