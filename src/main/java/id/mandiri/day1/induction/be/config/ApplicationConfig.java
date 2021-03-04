package id.mandiri.day1.induction.be.config;

import id.mandiri.day1.induction.be.model.Fruit;
import id.mandiri.day1.induction.be.service.GreetingService;
import id.mandiri.day1.induction.be.service.OutputService;
import id.mandiri.day1.induction.be.service.TimeService;
import id.mandiri.day1.induction.be.service.impl.StoreAgus;
import id.mandiri.day1.induction.be.service.impl.StoreBudi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ApplicationConfig {

    @Value("Selamat Datang")
    private String greeting;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;

    @Bean
    public TimeService timeService(){
        return new TimeService(true);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService,timeService);
    }

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(greeting);
    }

    @Bean
    public StoreAgus storeAgus() { return new StoreAgus(new Fruit(), new ArrayList<>());}

    @Bean
    public StoreBudi storeBudi() { return new StoreBudi(new Fruit(), new ArrayList<>());}


}

