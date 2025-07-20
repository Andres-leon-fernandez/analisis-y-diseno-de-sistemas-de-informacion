/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.ClienteService;
import com.mycompany.ecolimpio.model.Cliente;

import java.util.List;

/**
 * @author Andres
 */
public class ClienteController {

    private final ClienteService clienteService = new ClienteService();

    public void registrarCliente(Cliente cliente) {
        clienteService.registrar(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        clienteService.actualizar(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteService.eliminar(id);
    }

    public List<Cliente> listarClientes() {
        return clienteService.listarTodos();
    }

    public Cliente obtenerCliente(Long id) {
        return clienteService.listarPorId(id);
    }

}
