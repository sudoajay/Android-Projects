package com.example.sudoajay.form;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sudoajay on 11/2/17.
 */

public class About_Maker extends Fragment {
    private View view;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_about_maker, container, false);
        return view;
    }
}
