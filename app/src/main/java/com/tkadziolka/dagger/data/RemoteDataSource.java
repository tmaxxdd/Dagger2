package com.tkadziolka.dagger.data;

import javax.inject.Inject;

public class RemoteDataSource implements DataSource {

    @Inject RemoteDataSource() {}

    @Override
    public String getData() {
        return "A data from the RemoteDataSource";
    }
}
