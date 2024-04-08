package br.com.hygor.dao;

import br.com.hygor.olive.Cliente;

import java.util.Collection;

public interface IClienteDao {

    public boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar (long cpf);

    public Collection<Cliente> buscarTodos();

    Cliente consultar(String dados);
}