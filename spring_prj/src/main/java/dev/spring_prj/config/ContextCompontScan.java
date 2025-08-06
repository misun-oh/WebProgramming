package dev.spring_prj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dev.spring_prj.service", "dev.spring_prj.send"})
public class ContextCompontScan {

}
