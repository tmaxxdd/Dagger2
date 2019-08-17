package com.tkadziolka.dagger.data;

import javax.inject.Inject;

public class LocalDataSource implements DataSource {

    @Inject LocalDataSource() {}

    @Override
    public String getData() {
        return "A data from a LocalDataSource";
    }
}
