package com.mycompany.ecolimpio.dao.Impl;

import com.mycompany.ecolimpio.dao.Interfce.IncidenciaDAO;
import com.mycompany.ecolimpio.model.Incidencia;
import com.mycompany.ecolimpio.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class IncidenciaDAOImpl implements IncidenciaDAO {
    @Override
    public void guardar(Incidencia incidencia) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(incidencia);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Incidencia incidencia) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(incidencia);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long idincidencia) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(idincidencia);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Incidencia buscarPorId(Long idincidencia) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Incidencia inc = em.find(Incidencia.class, idincidencia);
        em.close();
        return inc;
    }

    @Override
    public List<Incidencia> listarTodos() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<Incidencia> Incidencias = em.createQuery("FROM Incidencia", Incidencia.class).getResultList();
        em.close();
        return Incidencias;
    }
}
