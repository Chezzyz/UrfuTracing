package com.urfu.tracing.config;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistConfig {
    @Bean(initMethod = "migrate")
    Flyway flyway(HikariDataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:migration")
                .baselineOnMigrate(false)
                .table("schema_version")
                .load();
    }
}
