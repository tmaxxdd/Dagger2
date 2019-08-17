package com.tkadziolka.dagger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tkadziolka.dagger.data.SharedPrefsUtil;

import javax.inject.Inject;

import dagger.android.support.DaggerDialogFragment;

public class MainFragment extends DaggerDialogFragment {

    @Inject MainFragment() {}

    @Inject
    SharedPrefsUtil sharedPrefsUtil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getView().findViewById(R.id.fragment_tv);
        textView.setText(sharedPrefsUtil.getSharedData());
    }
}
