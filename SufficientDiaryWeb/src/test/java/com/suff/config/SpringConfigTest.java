/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.config;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
/**
 *
 * @author Jeerapu
 */
@Configuration
@ComponentScan(basePackages="com.suff")
public class SpringConfigTest
{
    @Bean
    public DataSource dataSource() {
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            EmbeddedDatabase dataSource = (EmbeddedDatabase) builder.setType(EmbeddedDatabaseType.HSQL)
                            .addScript("dataset/schema.sql")
                            .addScript("dataset/data.sql")
                            .build();
            return dataSource;
    }
}
