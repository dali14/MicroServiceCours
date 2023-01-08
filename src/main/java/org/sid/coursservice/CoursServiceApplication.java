package org.sid.coursservice;

import org.sid.coursservice.entities.Cours;
import org.sid.coursservice.repository.CoursRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class CoursServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CoursServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner (CoursRepository coursRepository , RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Cours.class);
            coursRepository.saveAll(
                    List.of(
                            Cours.builder().name("sgbd").niveau("2").section("info").file("file").image("file").build(),
                            Cours.builder().name("soa").niveau("1").section("info").file("file").image("file").build(),
                            Cours.builder().name("francais").niveau("2").section("electrique").file("file").image("file").build()
                    )
            );
            coursRepository.findAll().forEach(e->{
                System.out.println(e);
            });
        };

    }
}
