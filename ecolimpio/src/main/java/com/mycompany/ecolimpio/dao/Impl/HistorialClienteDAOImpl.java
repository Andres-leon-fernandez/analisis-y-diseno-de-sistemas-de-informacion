package com.mycompany.ecolimpio.dao.Impl;

import com.mycompany.ecolimpio.dao.Interfce.HistorialClienteDAO;
import com.mycompany.ecolimpio.model.Factura;
import com.mycompany.ecolimpio.model.HistorialCliente;
import com.mycompany.ecolimpio.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class HistorialClienteDAOImpl implements HistorialClienteDAO {
    @Override
    public void guardar(HistorialCliente historialCliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(historialCliente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(HistorialCliente historialCliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(historialCliente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long idhistorialCliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(idhistorialCliente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public HistorialCliente buscarPorId(Long idhistorialCliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        HistorialCliente hc = em.find(HistorialCliente.class, idhistorialCliente);
        em.close();
        return hc;
    }

    @Override
    public List<HistorialCliente> listarTodos() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<HistorialCliente> hc = em.createQuery("FROM HistorialCliente", HistorialCliente.class).getResultList();
        em.close();
        return hc;
    }
}
