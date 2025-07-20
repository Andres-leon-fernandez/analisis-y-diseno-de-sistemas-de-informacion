package com.mycompany.ecolimpio.dao.Impl;

import com.mycompany.ecolimpio.dao.Interfce.ClienteDAO;
import com.mycompany.ecolimpio.model.Cliente;
import com.mycompany.ecolimpio.util.HibernateUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {


    @Override
    public void guardar(Cliente cliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(cliente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Cliente cliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(cliente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long idCliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            Cliente cliente = em.find(Cliente.class, idCliente);
            if (cliente != null) {
                tx.begin();
                em.remove(cliente);
                tx.commit();
            }
        } catch (
                Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Cliente buscarPorId(Long idCliente) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Cliente cl = em.find(Cliente.class, idCliente);
        em.close();
        return cl;
    }

    @Override
    public List<Cliente> listarTodos() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<Cliente> clientes = em.createQuery("FROM Cliente", Cliente.class).getResultList();
        em.close();
        return clientes;
    }
}
