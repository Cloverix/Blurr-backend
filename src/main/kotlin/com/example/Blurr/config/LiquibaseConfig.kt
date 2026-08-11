package com.example.Blurr.config

import liquibase.Liquibase
import liquibase.database.DatabaseFactory
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LiquibaseConfig {
    @Bean
    fun liquibase(dataSource: DataSource): Liquibase {
        val connection = dataSource.connection
        val database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(JdbcConnection(connection))
        val liquibase = Liquibase("db/changelog/db.changelog-master.sql", ClassLoaderResourceAccessor(), database)
        liquibase.update("")
        return liquibase
    }
}