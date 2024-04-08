package br.com.hygor;

import br.com.hygor.dao.ClienteMapDAO;
import br.com.hygor.dao.IClienteDao;
import br.com.hygor.olive.Cliente;

import javax.swing.*;
import java.util.Locale;

public class App<opcao> {
    private static IClienteDao iClienteDao;

    public static void main(String[] args) {

        iClienteDao = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para Cadastrar, 2 para consultar, 3 para excluir, 4 para Alterar ou 5 para sair",
                "green diner", JOptionPane.INFORMATION_MESSAGE);
        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção invalida, digite 1 para Cadastrar, 2 para consultar, 3 para excluir, 4 para Alterar ou 5 para sair",
                    "Green Diner", JOptionPane.INFORMATION_MESSAGE);
        }
        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por ',' Exemplo: nome, cpf, tel, cidade, endereço, numero, estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o Cpf do cliente",
                        "Cultando cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExclusao(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o cpf do cliente",
                        "Consultando cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar ou 5 para sair",
                        "Green diner", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static void excluir(String dados) {
        iClienteDao.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Cliente Excluido", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isExclusao(String opcao) {
        if("3".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDao.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado:" + cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente nao encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isConsulta(String opcao) {
        if("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1], dadosSeparados[2],dadosSeparados[3],
                dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        boolean isCadastrado = iClienteDao.cadastrar(cliente);
        if(isCadastrado) {
            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso","sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Cliente ja Cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair() {
        String clienteCadastrado = "";
        for(Cliente cliente : iClienteDao.buscarTodos()){
            clienteCadastrado += cliente.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, "Cliente Cadastrado: " +clienteCadastrado);
                System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao)
                || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
            return false;

        }
    }