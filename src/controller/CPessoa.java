/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 182120013
 */
public class CPessoa {

    ArrayList<Pessoa> pessoas = new ArrayList<>();
    int idPessoa = 1;

    /**
     * metodo geraID emula a função de auto-incrementação de ID
     *
     * @return
     */
    public int geraID() {
        return this.idPessoa++;
    }//fim do geraID

    /**
     * metodo addPessoa adiciona pessoas ao array list "pessoas"
     *
     * @param p
     */
    public void addPessoa(Pessoa p) {
        this.pessoas.add(p);
    }//fim public class add

    /**
     * metodo removePessoa remove uma pessoa do array list
     *
     * @param p
     */
    public void removePessoa(Pessoa p) {
        this.pessoas.remove(p);
    }//fim da public class remove

    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }//fim do getPessoa

    /**
     * metodo getPessoaCPF retorna uma pessoa caso encontre correspondênciado
     * ArrayList pessoas, caso contrário retorna null.
     *
     * @param CPF
     * @return
     */
    public Pessoa getPessoaCPF(String CPF) {
        Pessoa p = null;
        for (Pessoa pes : pessoas) {
            if (pes.getCpf().equals(CPF)) {
                p = pes;
                break;
            }//fim do if
        }//fim do "foreach"
        return p;
    }//fim get cpf

    /**
     * Metodo mockPessoas() serve para popular artificialmente o arraylist
     */
    public void mockPessoas() {
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(geraID());
        p1.setCpf("30668518006");
        p1.setNome("Juvenal das Candongas");
        p1.setTelefone("51999889988");
        p1.setEndereco("Rua das Margaridas");
        addPessoa(p1);
        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(geraID());
        p2.setCpf("85606196077");
        p2.setNome("Madalena Espirito Santo");
        p2.setTelefone("51988998899");
        p2.setEndereco("Rua sem saída");
        addPessoa(p2);
    }//fim do void
    
}//fim da classe
