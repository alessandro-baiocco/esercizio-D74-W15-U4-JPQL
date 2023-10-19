package coso;

import com.github.javafaker.Faker;
import entities.*;
import enums.Genere;
import utils.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = JPAutil.emfCreate();


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();
        Random rnd = new Random();
        ConcertoDAO cD = new ConcertoDAO(em);
        PersonaDAO persD = new PersonaDAO(em);
        PartitaDiCalcioDAO playD = new PartitaDiCalcioDAO(em);
        EventDAO eD = new EventDAO(em);


        Supplier<Persona> personaSupplier = () -> {
            return new Persona(faker.name().firstName(), faker.name().lastName(), rnd.nextInt(20, 40));
        };
        Supplier<Concerto> concertiSupplier = () -> {
            return new Concerto(Genere.POP, true);
        };
        Supplier<PartitaDiCalcio> partitaSupplier = () -> {
            String[] squadre = {faker.esports().team(), faker.esports().team()};
            return new PartitaDiCalcio(squadre[0], squadre[1], squadre[rnd.nextInt(0, 1)], rnd.nextInt(0, 4), rnd.nextInt(0, 4));
        };
        Supplier<PartitaDiCalcio> pareggioSupplier = () -> {
            String[] squadre = {faker.esports().team(), faker.esports().team()};
            return new PartitaDiCalcio(squadre[0], squadre[1], rnd.nextInt(0, 4), rnd.nextInt(0, 4));
        };


//        for (int i = 0; i < 10; i++) {
//            persD.save(personaSupplier.get());
//        }

//        for (int i = 0; i < 3; i++) {
//            cD.save(concertiSupplier.get());
//        }

//        for (int i = 0; i < 5; i++) {
//            playD.save(partitaSupplier.get());
//            playD.save(pareggioSupplier.get());
//        }

        eD.filterVinteInCasa(true).forEach(System.out::println);


        em.close();
        emf.close();

    }


}
