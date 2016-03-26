package com.example.prakhargautam.userposts.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prakhargautam.userposts.R;

/**
 * Created by prakhargautam on 25/03/16.
 */
public class AddUserFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.add_user_fragment,container,false);

        return v;
    }
}
