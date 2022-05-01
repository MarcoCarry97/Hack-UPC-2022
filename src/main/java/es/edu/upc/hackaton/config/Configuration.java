//package es.edu.upc.hackaton.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//
//@org.springframework.context.annotation.Configuration
//public class Configuration {
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            Quote quote = restTemplate.getForObject(
//                    "https://quoters.apps.pcfone.io/api/random", Quote.class);
//            log.info(quote.toString());
//        };
//    }
//}
