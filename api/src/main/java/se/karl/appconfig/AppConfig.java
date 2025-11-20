package se.karl.appconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSource realDataSource() {
        String url = this.dataSourceProperties.getUrl();
        String username = this.dataSourceProperties.getUsername();
        String password = this.dataSourceProperties.getPassword();

        // Wait for DB to become available (development convenience)
        int maxAttempts = 30;
        int attempt = 0;
        while (attempt < maxAttempts) {
            try (Connection ignored = DriverManager.getConnection(url, username, password)) {
                break; // success
            } catch (SQLException ex) {
                attempt++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupted while waiting for database", ie);
                }
            }
        }

        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(url)
                .username(username)
                .password(password)
                .build();
        return dataSource;
    }

    @Bean
    @Primary
    DataSource dataSource() {
        return new DataSourceSpy(realDataSource());
    }
}