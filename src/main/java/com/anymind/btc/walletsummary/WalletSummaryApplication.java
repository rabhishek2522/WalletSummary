package com.anymind.btc.walletsummary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class WalletSummaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletSummaryApplication.class, args);
	}

}
