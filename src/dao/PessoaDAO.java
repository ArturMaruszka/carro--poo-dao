/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 182120013
 */
public class PessoaDAO {

    public void cadastrarPessoaDAO(Pessoa pVO) {
        try {
            //buscar conexao com BD
            Connection con = Conexao.getConexao();
            //criar script sql de insert
            String sql = "insert into pessoas values(null,?,?,?,?)";
            //criar espaço para exxecutar script
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pVO.getNome());
            pst.setString(2, pVO.getCpf());
            pst.setString(3, pVO.getEndereco());
            pst.setString(4, pVO.getTelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Deu ruim meu chapa!!!!!!!!!!!!!!!!!!!!!!\n" + e.getMessage());
        }
    }//fim do cadastrar pessoa
    public ArrayList<Pessoa> getPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select*from pessoas";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {//lado do java  ||  lado do banco
                Pessoa p = new Pessoa();
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                pessoas.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");
        }
        return pessoas;
    }

    public Pessoa getPessoaByDoc(String cpf) {
        Pessoa p = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select*from pessoas where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {//lado do java  ||  lado do banco

                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));

            }
        } catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");
        }

        return p;
    }

    public void atualizarPessoaDAO(Pessoa pVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoas set nome = ?,endereco = ?, telefone = ?, where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pVO.getNome());
            pst.setString(2, pVO.getCpf());
            pst.setString(3, pVO.getEndereco());
            pst.setString(4, pVO.getTelefone());
        } catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");
        }
    }//fim atualiza pessoa
    public void deletarPessoaDAO(String cpf){
        try{
             Connection con = Conexao.getConexao();
            String sql = "delete from pessoas where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");
            
        }
    }
}//fim da main
