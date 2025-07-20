package com.mycompany.ecolimpio.dao.Impl;

import com.mycompany.ecolimpio.dao.Interfce.NotificacionDAO;
import com.mycompany.ecolimpio.model.Incidencia;
import com.mycompany.ecolimpio.model.Notificacion;
import com.mycompany.ecolimpio.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NotificacionDAOImpl implements NotificacionDAO {
    @Override
    public void guardar(Notificacion notificacion) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(notificacion);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Notificacion notificacion) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(notificacion);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long idnotificacion) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(idnotificacion);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Notificacion buscarPorId(Long idnotificacion) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Notificacion not = em.find(Notificacion.class, idnotificacion);
        em.close();
        return not;
    }

    @Override
    public List<Notificacion> listarTodos() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<Notificacion> notificaciones = em.createQuery("FROM Notificacion", Notificacion.class).getResultList();
        em.close();
        return notificaciones;
    }
}
