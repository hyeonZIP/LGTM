package zip.hyeon.lgtm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LgtmApplication {

    void main() {
        SpringApplication.run(LgtmApplication.class);
    }

}
