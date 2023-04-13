/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Carro

/**
 *
 * @author 182120013
 */
public class CarroDAO {
    public void cadastrarCarroDAO(CarroDAO dVO){
        try{
            Connection con = Conexao.getConexao();
            String sql="insert into carros values(null,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.g);
        }
    }
}
