package id.mandiri.day1.induction.be;

import id.mandiri.day1.induction.be.config.ApplicationConfig;
import id.mandiri.day1.induction.be.model.Apel;
import id.mandiri.day1.induction.be.model.Fruit;
import id.mandiri.day1.induction.be.model.Jeruk;
import id.mandiri.day1.induction.be.model.Mangga;
import id.mandiri.day1.induction.be.service.GreetingService;
import id.mandiri.day1.induction.be.service.OutputService;
import id.mandiri.day1.induction.be.service.impl.StoreAgus;
import id.mandiri.day1.induction.be.service.impl.StoreBudi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) throws Exception {


        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        GreetingService greetingService = context.getBean(GreetingService.class);
        System.out.println(greetingService.getGreeting("Isma"));
        OutputService outputService = context.getBean(OutputService.class);

        for (int i=0;i<5;i++){
            outputService.generateOutput("Isma");
            Thread.sleep(3000);
        }

        StoreAgus storeAgus = context.getBean(StoreAgus.class);

        System.out.println(storeAgus.addNewFruit(new Jeruk()));
        System.out.println(storeAgus.addNewFruit(new Mangga()));
        System.out.println(storeAgus.addNewFruit(new Apel()));
        System.out.println(storeAgus.findAllFruits());

        storeAgus.sellAFruit("apel", 2);


        //Store Budi sell a fruit cheaper than store Agus

        StoreBudi storeBudi = context.getBean(StoreBudi.class);


        System.out.println(storeBudi.addNewFruit(new Jeruk()));
        System.out.println(storeBudi.addNewFruit(new Mangga()));
        System.out.println(storeBudi.findAllFruits());

        storeBudi.sellAFruit("apel", 2);


    }
}
