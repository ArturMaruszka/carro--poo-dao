/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static inf3n212.carro.Inf3n212Carro.cadPessoa;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 182120013
 */
public class CCarro {

    ArrayList<Carro> carros = new ArrayList();

    public void addCarro(Carro c) {
        this.carros.add(c);
    }//fim add carro

    public void removeCarro(Carro c) {
        this.carros.remove(c);
    }//fim removeCarro

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }//fim addcarro

    public Carro getCarro(String placa) {
        Carro c = null;
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                c = carro;
                break;
            }//fim do if
        }//fim do for
        return c;
    }//fim da placa

    public void mockCarros() {
        Carro c1 = new Carro();
        c1.setPlaca("ABC1F34");
        c1.setAnoFab(2023);
        c1.setAnoMod(2023);
        c1.setMarca("Fiat");
        c1.setModelo("Palio");
        c1.setTpCambio("Manual");
        c1.setCombustivel("Flex");
        c1.setCor("Bege");
        c1.setProprietario(cadPessoa.getPessoaCPF("30668518006"));
        addCarro(c1);
        Carro c2 = new Carro();
        c2.setPlaca("ABC2F34");
        c2.setAnoFab(2023);
        c2.setAnoMod(2023);
        c2.setMarca("Fiat");
        c2.setModelo("Panda");
        c2.setTpCambio("Automático");
        c2.setCombustivel("Disel");
        c2.setCor("cinza");
        c2.setProprietario(cadPessoa.getPessoaCPF("85606196077"));
        addCarro(c2);
    }//fim do mock
}//fim da CCarro
