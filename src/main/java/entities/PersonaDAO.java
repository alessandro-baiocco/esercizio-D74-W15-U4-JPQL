package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(persona);
            transaction.commit();
            System.out.println("persona salvata correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Persona findById(long id) {
        return em.find(Persona.class, id);
    }

    public void delete(long id) {
        Persona personFounded = em.find(Persona.class, id);
        try {
            if (personFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(personFounded);
                System.out.println("ok");
                transaction.commit();
                System.out.println("persona è stata cancellata correttamente");
            } else {
                System.err.println("la persona non è stata trovata");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


}