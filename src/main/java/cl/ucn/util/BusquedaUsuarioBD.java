package cl.ucn.util;

import cl.ucn.interfaz.ProxyInterface;
import cl.ucn.modelo.Usuario;
import jakarta.persistence.*;

public class BusquedaUsuarioBD implements ProxyInterface {

    EntityManagerFactory emf;
    EntityManager em;

    @Override
    public Usuario buscarUsuario(int rut) {

        emf = Persistence.createEntityManagerFactory("multimediaApp");
        em = emf.createEntityManager();
        Usuario usuario = null;
        String jpql = "SELECT u from Usuario u WHERE u.rut = :rut";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("rut", rut);
        try {
            usuario = query.getSingleResult();
        }catch (NoResultException e){
           System.out.println("");
        }
        finally {
            em.close();
        }
        return usuario;
    }
}
