package cosmetic.modelo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cosmetic.modelo.persistencia.AtributoCosmeticoDao;
import cosmetic.modelo.entidad.AtributoCosmetico;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(AtributoCosmeticoDao repository) {

        return args -> {
            log.info("Preloading " + repository.save(new AtributoCosmetico()));
            log.info("Preloading " + repository.save(new AtributoCosmetico()));
          
        };
    }
}
