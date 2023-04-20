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
import model.Carro;
import servicos.PessoaServicos;
import servicos.ServicosFactory;

/**
 *
 * @author 182120013
 */
public class CarroDAO {

    public void cadastrarCarroDAO(Carro cVO) {
        try {
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            Connection con = Conexao.getConexao();
            String sql = "insert into carros values(null,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getPlaca());
            pst.setString(2, cVO.getMarca());
            pst.setString(3, cVO.getModelo());
            pst.setInt(4, cVO.getAnoFab());
            pst.setInt(5, cVO.getAnoMod());
            pst.setString(6, cVO.getCor());
            pst.setString(7, cVO.getTpCambio());
            pst.setString(8, cVO.getCombustivel());
            pst.setInt(9, pessoaS.getPessoaByDoc(cVO.getProprietario().getCpf()).getIdPessoa());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Deu ruim meu chapa!!!!!!!!!!!!!!!!!!!!!!\n" + e.getMessage());
        }
    }//fim cadastra carro

    public ArrayList<Carro> getCarros() {
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        ArrayList<Carro> carros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select catrro.*, pessoa.cpf as cpf from carros join pessoa using idPessoa";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {//lado do java  ||  lado do banco
                Carro c = new Carro();
                c.setPlaca(rs.getString("placa"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setAnoMod(rs.getInt("ano mod"));
                c.setAnoFab(rs.getInt("ano fab"));
                c.setCor(rs.getNString("cor"));
                c.setTpCambio(rs.getString("cambio"));
                c.setCombustivel(rs.getString("combustivel"));
                c.setProprietario(pessoaS.getPessoaByDoc(rs.getString("cpf")));
                carros.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");
        }
        return carros;
    }

    public Carro getCarroByDoc(String Placa) {
        Carro c = new Carro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select*from carros where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Placa);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.setPlaca(rs.getString("placa"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setAnoMod(rs.getInt("ano mod"));
                c.setAnoFab(rs.getInt("ano fab"));
                c.setCor(rs.getNString("cor"));
                c.setTpCambio(rs.getString("cambio"));
                c.setCombustivel(rs.getString("combustivel"));
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                c.setProprietario(pessoaS.getPessoaByDoc(rs.getString("cpf")));
            }
        } catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");
        }
        return c;
    }//fim do get carro

    public void atualizarCarroDAO(Carro cVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoas set nome = ?,endereco = ?, telefone = ?" + "where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            pst.setString(1, cVO.getPlaca());
            pst.setString(2, cVO.getMarca());
            pst.setString(3, cVO.getModelo());
            pst.setInt(3, cVO.getAnoMod());
            pst.setInt(5, cVO.getAnoFab());
            pst.setString(6, cVO.getCor());
            pst.setString(7, cVO.getTpCambio());
            pst.setString(8, cVO.getCombustivel());
            pst.setInt(9, pessoaS.getPessoaByDoc(cVO.getProprietario().getCpf()).getIdPessoa());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");
        }
    }//fim do atualiza carro

    public void deletarCarroDAO(String placa) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "select*from pessoas where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, placa);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Não deu camarada!!\n");

        }//fim de delete
    }//fim do deleta carro
}//fim da main
