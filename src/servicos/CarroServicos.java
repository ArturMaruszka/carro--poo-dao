/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.CarroDAO;
import dao.DAOFactory;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 182120013
 */
public class CarroServicos {

    public void cadastroCarro(Carro pVO) {
        CarroDAO cdao = DAOFactory.getCarroDAO();
        cdao.cadastrarCarroDAO(pVO);
    }

    public ArrayList<Carro> getCarro() {
        CarroDAO cdao = DAOFactory.getCarroDAO();
        return cdao.getCarros();
    }

    public Carro getCarroByDoc(String placa) {
        CarroDAO cdao = DAOFactory.getCarroDAO();
        return cdao.getCarroByDoc(placa);
    }

    public void atualizarCarro(Carro cVO) {
        CarroDAO cdao = DAOFactory.getCarroDAO();
        cdao.atualizarCarroDAO(cVO);
    }

    public void deletarCarro(String placa) {
        CarroDAO cdao = DAOFactory.getCarroDAO();
        cdao.deletarCarroDAO(placa);
    }
}//fim da class

