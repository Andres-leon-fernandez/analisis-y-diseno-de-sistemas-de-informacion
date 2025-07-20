package com.mycompany.ecolimpio.dao.Impl;

import com.mycompany.ecolimpio.dao.Interfce.TecnicoDAO;
import com.mycompany.ecolimpio.model.Servicio;
import com.mycompany.ecolimpio.model.Tecnico;
import com.mycompany.ecolimpio.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class TecnicoDAOImpl implements TecnicoDAO {
    @Override
    public void guardar(Tecnico tecnico) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(tecnico);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Tecnico tecnico) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(tecnico);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long idtecnico) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(idtecnico);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Tecnico buscarPorId(Long idtecnico) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Tecnico tecnico = em.find(Tecnico.class, idtecnico);
        em.close();
        return tecnico;
    }

    @Override
    public List<Tecnico> listarTodos() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<Tecnico> Tecnicos = em.createQuery("FROM Tecnico", Tecnico.class).getResultList();
        em.close();
        return Tecnicos;
    }
}
