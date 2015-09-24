package app.amaroll.loise.kbc.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.amaroll.loise.kbc.R;

/**
 * Created by muli on 9/23/2015.
 */
public class tv extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tv,container,false);
        return v;

    }
}
