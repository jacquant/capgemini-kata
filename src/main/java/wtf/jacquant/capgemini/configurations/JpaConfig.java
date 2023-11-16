package wtf.jacquant.capgemini.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "wtf.jacquant.capgemini.repositories")
@EnableJpaAuditing
@EnableTransactionManagement
public class JpaConfig {
}
