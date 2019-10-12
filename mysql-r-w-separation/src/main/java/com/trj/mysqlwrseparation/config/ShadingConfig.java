package com.trj.mysqlwrseparation.config;

import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author TRJ
 * @date 2019/10/12
 * Description:读写分离配置
 */
@Configuration
public class ShadingConfig {
    @Bean
    public DataSource dataSource() throws IOException, SQLException {
        File yamlFile = ResourceUtils.getFile("classpath:sharding-jdbc.yaml");
        return YamlMasterSlaveDataSourceFactory.createDataSource(yamlFile);
    }
}
