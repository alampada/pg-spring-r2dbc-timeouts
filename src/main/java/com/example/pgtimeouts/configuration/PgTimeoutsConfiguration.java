package com.example.pgtimeouts.configuration;

import java.util.Map;
import java.util.Optional;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

@Configuration
public class PgTimeoutsConfiguration extends AbstractR2dbcConfiguration {

	@Override
	@Bean
	public ConnectionFactory connectionFactory() {
		return  ConnectionFactories.get(ConnectionFactoryOptions.builder()
				.option(DRIVER, "postgresql")
				.option(HOST, "172.17.0.2")
				.option(USER, "postgres")
				.option(PASSWORD, "postgres")
				.option(Option.valueOf("options"), Map.of("statement_timeout", "1000"))
				.build());
	}
}
