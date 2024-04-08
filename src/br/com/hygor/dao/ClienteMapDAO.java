package br.com.hygor.dao;

import br.com.hygor.olive.Cliente;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClienteMapDAO implements IClienteDao {

    private Map<Long, Cliente> map;

    public ClienteMapDAO(){map = new TreeMap<>();
    }

    @Override
    public boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente ClienteCadastrado = this.map.get(cpf);
        if(ClienteCadastrado != null);
        this.map.remove(ClienteCadastrado.getCpf(), ClienteCadastrado);
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente ClienteCadastrado = this.map.get(cliente.getCpf());
        if(ClienteCadastrado !=null);
        ClienteCadastrado.setNome((cliente.getNome()));
        ClienteCadastrado.setCpf((cliente.getCpf()));
        ClienteCadastrado.setTel(cliente.getTel());
        ClienteCadastrado.setCidade(cliente.getCidade());
        ClienteCadastrado.setEnd(cliente.getEnd());
        ClienteCadastrado.setNumero(cliente.getNumero());
        ClienteCadastrado.setEstado(cliente.getEstado());

    }

    @Override
    public Cliente consultar(long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }

    @Override
    public Cliente consultar(String dados) {
        return null;
    }
}
