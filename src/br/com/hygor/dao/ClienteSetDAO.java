package br.com.hygor.dao;

import br.com.hygor.olive.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
public class ClienteSetDAO implements IClienteDao {

    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }
    @Override
    public void excluir(Long cpf) {
        Cliente ClienteEncontrado = null;
        for (Cliente cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                ClienteEncontrado = cliente;
                break;
            }
        }
        if (ClienteEncontrado != null) {
            this.set.remove(ClienteEncontrado);
        }

    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado : this.set) {
                if (clienteCadastrado.equals(cliente)){
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setCpf(cliente.getCpf());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }

    }

    @Override
    public Cliente consultar(long cpf) {
        for (Cliente clienteCadastrado : this.set) {
            if (clienteCadastrado.getCpf().equals(cpf)) {
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }

    @Override
    public Cliente consultar(String dados) {
        return null;
    }
}
