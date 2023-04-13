/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 182120013
 */
public class PessoaDAO {
    public void cadastrarPessoaDAO(Pessoa pVO){
        try{
            //buscar conexao com BD
            Connection con = Conexao.getConexao();
            //criar script sql de insert
            String sql = "insert into pessoas values(null,?,?,?,?)";
            //criar espaço para exxecutar script
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, pVO.getNome());
            pst.setString(2, pVO.getCpf());
            pst.setString(3, pVO.getEndereco());
            pst.setString(4, pVO.getTelefone());
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println("Deu ruim meu chapa!!!!!!!!!!!!!!!!!!!!!!\n"+e.getMessage());
        }
    }//fim do cadastrar pessoa
    public ArrayList<Pessoa>getPessoas(){
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try{
            
        }catch(SQLException e){
            System.out.println("Não deu camarada!!\n");
        }
        return pessoas;
    }
}
