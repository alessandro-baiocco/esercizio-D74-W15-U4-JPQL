package entities;

import enums.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventDAO {
    private EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(event);
            transaction.commit();
            System.out.println("Nuovo evento salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void delete(long id) {
        Event eventFounded = em.find(Event.class, id);
        try {
            if (eventFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(eventFounded);
                System.out.println("ok");
                transaction.commit();
                System.out.println("l'evento o è stato cancellato correttamente");
            } else {
                System.err.println("l'evento non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


//    public List<Cat> findAllCats() {
//        // SELECT * FROM animals WHERE tipo_animale = 'Gatto'
//        TypedQuery<Cat> getAllQuery = em.createQuery("SELECT c FROM Cat c", Cat.class); // Query JPQL
//        return getAllQuery.getResultList();
//    }
//
//    public List<Concerto> filterStraming(String title) {
//        TypedQuery<Concerto> getBlogs = em.createNamedQuery("findByPartialName", Concerto.class);
//        getBlogs.setParameter("title", title);
//        return getBlogs.getResultList();
//    }


    public List<Concerto> filterStreaming(Boolean bool) {
        TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.streaming = :bool", Concerto.class);
        getAllQuery.setParameter("bool", bool);
        return getAllQuery.getResultList();
    }


    public List<Concerto> filterCategory(Genere gen) {
        TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :gen", Concerto.class);
        getAllQuery.setParameter("gen", gen);
        return getAllQuery.getResultList();
    }

    public List<PartitaDiCalcio> filterVinteInCasa(Boolean bool) {
        if (bool) {
            TypedQuery<PartitaDiCalcio> getAllQuery = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraCasa = p.vincitore", PartitaDiCalcio.class);
            return getAllQuery.getResultList();
        } else {
            TypedQuery<PartitaDiCalcio> getAllQuery = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraOspite = p.vincitore", PartitaDiCalcio.class);
            return getAllQuery.getResultList();
        }
    }


}
