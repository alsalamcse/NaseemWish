package com.naseem.naseemwish.mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naseem.naseemwish.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrntListFragment extends Fragment {


    public CurrntListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currnt_list, container, false);
    }

}
