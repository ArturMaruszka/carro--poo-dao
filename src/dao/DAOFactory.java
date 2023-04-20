/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author 182120013
 */
public class DAOFactory {
    private static PessoaDAO pdao = new PessoaDAO();
    public static PessoaDAO getPessoaDAO(){
        return pdao;
    }
    private static CarroDAO cdao = new CarroDAO();
    public static CarroDAO getCarroDAO(){
        return cdao;
    }
}
