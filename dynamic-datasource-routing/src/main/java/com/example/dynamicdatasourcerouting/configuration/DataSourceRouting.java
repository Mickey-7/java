package com.example.dynamicdatasourcerouting.configuration;

import com.example.dynamicdatasourcerouting.domain.BranchEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DataSourceRouting extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return BranchContextHolder.getBranchContext();
    }

    public void initDatasource(DataSource bangkokDatasource, DataSource hongkongDatasource){
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(BranchEnum.BANGKOK, bangkokDatasource);
        dataSourceMap.put(BranchEnum.HONGKONG, hongkongDatasource);
        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(bangkokDatasource);
    }
}
