package com.tkadziolka.dagger;

import android.os.Bundle;
import android.widget.TextView;

import com.tkadziolka.dagger.utils.Worker;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class OtherActivity extends DaggerAppCompatActivity {

    @Inject
    Worker worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        TextView textView = findViewById(R.id.other_tv);

        textView.setText(String.valueOf(worker.hashCode()));

    }
}
