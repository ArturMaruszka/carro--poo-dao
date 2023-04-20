/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.PessoaDAO;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 182120013
 */
public class PessoaServicos {
    public void cadastroPessoa(Pessoa pVO){
        PessoaDAO pdao = DAOFactory.getPessoaDAO();
        pdao.cadastrarPessoaDAO(pVO);
    }
    public ArrayList<Pessoa> getPessoas(){
         PessoaDAO pdao = DAOFactory.getPessoaDAO();
         return pdao.getPessoas();
    }
    public Pessoa getPessoaByDoc(String cpf){
        PessoaDAO pdao = DAOFactory.getPessoaDAO();
        return pdao.getPessoaByDoc(cpf);
    }
    public void atualizarPessoa(Pessoa pVO){
        PessoaDAO pdao = DAOFactory.getPessoaDAO();
        pdao.atualizarPessoaDAO(pVO);
    }
    public void deletarPessoa(String cpf){
        PessoaDAO pdao = DAOFactory.getPessoaDAO();
        pdao.deletarPessoaDAO(cpf);
    }
}
