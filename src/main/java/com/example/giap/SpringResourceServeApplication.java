package com.example.giap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableMethodSecurity
public class SpringResourceServeApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringResourceServeApplication.class, args);
  }

  @PostMapping(value = "/hello")
  public String poolPersistBy() {
    return "Hello admin";
  }

  @PostMapping(value = "/survey")
  @PreAuthorize("hasAuthority('APPROLE_ROLE_STAFF')")
  public String addAnswer(@RequestParam("answer") String answer) {
    if (StringUtils.hasText(answer)) {
      return "succeeded";
    }
    return "Failed";
  }
}
