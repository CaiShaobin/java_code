package com.abin.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DivDatasource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        DatasourceType.DataBaseType dataBaseType = DatasourceType.getDataBaseType();
        return dataBaseType;
    }
}
