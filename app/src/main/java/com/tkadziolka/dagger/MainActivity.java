package com.tkadziolka.dagger;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.tkadziolka.dagger.data.DataSource;
import com.tkadziolka.dagger.data.LocalDataSource;
import com.tkadziolka.dagger.data.RemoteDataSource;
import com.tkadziolka.dagger.data.SharedPrefsUtil;
import com.tkadziolka.dagger.message.MyMessage;
import com.tkadziolka.dagger.utils.NetworkHelper;
import com.tkadziolka.dagger.utils.NetworkState;
import com.tkadziolka.dagger.utils.Worker;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Worker worker;

    @Inject
    @Named("PRODUCTION")
    MyMessage myMessage;

    @Inject
    Set<DataSource> dataSources;

    @Inject
    SharedPrefsUtil sharedPrefsUtil;

    @Inject
    NetworkHelper networkHelper;

    @Inject
    MainFragment mainFragment;

    private AppCompatTextView dataView;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatTextView textView = findViewById(R.id.main_tv);
        AppCompatButton button = findViewById(R.id.main_btn);
        AppCompatButton showFragmentButton = findViewById(R.id.show_fragment_button);
        dataView = findViewById(R.id.data_view);

        myMessage.showMessage(worker.getWork());

        textView.setText(String.valueOf(worker.hashCode()));

        button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, OtherActivity.class)));

        showFragmentButton.setOnClickListener(view -> showFragment());

        filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(networkHelper, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (NetworkState.isConnected) {

            for (DataSource source: dataSources) {
                if (source instanceof RemoteDataSource) {
                    dataView.setText(source.getData());
                }
            }

        } else {

            for (DataSource source: dataSources) {
                if (source instanceof LocalDataSource) {
                    dataView.setText(source.getData());
                }
            }

        }

        myMessage.showMessage(sharedPrefsUtil.getSharedData());
    }

    @Override
    protected void onPause() {
        unregisterReceiver(networkHelper);
        super.onPause();
    }

    private void showFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment dialog = getSupportFragmentManager().findFragmentByTag("dialog");
        if (dialog != null) {
            ft.remove(dialog);
        }
        ft.addToBackStack(null);

        mainFragment.show(ft, "dialog");
    }
}
