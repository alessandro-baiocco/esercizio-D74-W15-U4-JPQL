package coso;

import com.github.javafaker.Faker;
import utils.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = JPAutil.emfCreate();
    EntityManager em = emf.createEntityManager();
    Faker faker = new Faker();
    Random rnd = new Random();

    public static void main(String[] args) {


    }


}
