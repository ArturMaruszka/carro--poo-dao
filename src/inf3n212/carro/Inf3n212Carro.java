/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import servicos.CarroServicos;
import servicos.PessoaServicos;
import servicos.ServicosFactory;
import util.Validadores;

/**
 *
 * @author 182120013
 */
public class Inf3n212Carro {

    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        int opM = 99;
        int opSM = 99;
        do {
            System.out.println("Sistema de Cadastro");
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:

                                if (opM == 1) {
                                    cadastrarPessoa();
                                } else {
                                    cadastrarCarro();
                                }

                                break;
                            case 2:
                                System.out.println("Edita");
                                if (opM == 1) {
                                    EditaPessoa();
                                } else {
                                    EditaCarro();
                                }
                                break;
                            case 3:
                                System.out.println("Listar");
                                if (opM == 1) {
                                    ListarPessoa();
                                } else {
                                    ListarCarro();
                                }
                                break;
                            case 4:
                                System.out.println("Deleta");
                                if (opM == 1) {
                                    DeletaPessoa();
                                } else {
                                    DeletaCarro();
                                }
                                break;
                            case 0:

                                break;
                            default:
                                System.out.print("Opção invalida, tente novamente");
                        }//fim do switch

                    } while (opSM != 0);//fim do do

                    break;

                case 0:
                    System.out.println("Aplicação Encerrada Pelo usuário");
                default:
                    System.out.println("Добро пожаловать в товарищеский Советский Союз!");
            }//fim do shwitch

        } while (opM != 0); //fim do do

    }//fim da main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Добро пожаловать в товарищеский Советский Союз!");
        }
        return 99;
    }//fim do leiaNumInt

    public static void menuP() {
        System.out.println("\u001B[33m" + "_____Menu Inicial____");
        System.out.println("\u001B[33m" + "1-Gerenciar Pessoa");
        System.out.println("\u001B[33m" + "2-Gerenciar Carro");
        System.out.println("\u001B[33m" + "0-Sair");
        System.out.println("\u001B[33m" + "Digite aqui: ");
    }//fim do menu inicial

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Carro";
        }
        if (opM < 0 || opM > 3) {
            System.out.println("Opção inválida!");

        }
        System.out.println("\u001B[32m" + "Gerenciador de " + subM);
        System.out.println("\u001B[32m" + "1-Cadastrar" + subM);
        System.out.println("\u001B[32m" + "2-Editar" + subM);
        System.out.println("\u001B[32m" + "3-Listar" + subM + "s");
        System.out.println("\u001B[32m" + "4-Deletar" + subM);
        System.out.println("\u001B[32m" + "0-Voltar");
        System.out.println("\u001B[32m" + "Digite aqui: ");
    }//fim subMenu

    private static void cadastrarCarro() {
        CarroServicos carroS = ServicosFactory.getCarroServicos();
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        System.out.println("Cadastro de Carros");
        boolean pCarro = true;
        String marca;
        String modelo;
        int anoFab;
        int anoMod;
        String cor;
        String tpCambio;
        String combustivel;
        Pessoa proprietario;

        do {
            System.out.println("Informe a placa do veiculo: ");
            String placa = leia.nextLine();
            placa = placa.toUpperCase();
            pCarro = Validadores.validarPlaca(placa);
            if (pCarro) {
                //Carro carro = cadCarro.getCarro(placa);
                Carro carro = carroS.getCarroByDoc(placa);
                if (carro == null) {
                    System.out.println("Informe a marca do veiculo: ");
                    marca = leia.nextLine();
                    System.out.println("informe o modelo do veiculo: ");
                    modelo = leia.nextLine();
                    do {
                        System.out.println("Informe o ano de Fabricação do veiculo: ");
                        anoFab = leiaNumInt();
                        System.out.println("Informe o ano do modelo do veiculo: ");
                        anoMod = leiaNumInt();
                        if (!Validadores.validarAnoCarro(anoFab, anoMod)) {
                            System.out.println("ANO INVALIDO.");
                        }
                    } while (!Validadores.validarAnoCarro(anoFab, anoMod));
                    System.out.println("Informe a cor do veiculo: ");
                    cor = leia.nextLine();
                    System.out.println("Informe o tipo de transmição do veiculo: ");
                    tpCambio = leia.nextLine();
                    System.out.println("Informe o tipo de combustivel do veiculo: ");
                    combustivel = leia.nextLine();
                    do {
                        System.out.println("Informe o CPF do proprietário do veiculo: ");
                        String cpf = leia.nextLine();
                        // proprietario = cadPessoa.getPessoaCPF(cpf);
                        proprietario = pessoaS.getPessoaByDoc(cpf);
                        if (proprietario.getCpf() == null) {
                            System.out.println("CPF não cadastrado");
                        } else {
                            System.out.println(proprietario.getNome() + " é o proprietario?");
                            System.out.println("1- Sim | 2- Não");
                            System.out.println("Digite aqui: ");
                            int op = leiaNumInt();
                            if (op == 2) {
                                System.out.println("Tente outro proprietario.");
                                proprietario.setCpf(null);

                            }
                        }
                    } while (proprietario.getCpf() == null);
                    pCarro = false;
                    Carro c = new Carro(placa, marca, modelo, anoFab, anoMod, cor, tpCambio, combustivel, proprietario);
                    //cadCarro.addCarro(c);
                    carroS.cadastroCarro(c);
                    System.out.println("\u001B[32m" + "USUARIO, ENCERRE A OPERAÇÃO, OU SEU SUPORTE VITAL SERÁ DESATIVADO!");

                } else {
                    System.out.println("Placa já cadastrada.");
                    pCarro = false;
                }
            } else {
                System.out.println("Placa invalida!");
                pCarro = true;
            }

        } while (pCarro);
    }// fim do cadastrar carro

    private static void cadastrarPessoa() {
        System.out.println("Cadastro de Pessoa");
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;
        do {
            System.out.print("Insira um cpf válido:");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (pessoaS.getPessoaByDoc(cpf).getCpf() != null) {
                    System.out.println("CPF já cadastrado!!");
                    if (!Deukk()) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF inválido!");
                if (!Deukk()) {
                    return;
                }
                tcpf = true;
            }

        } while (tcpf);
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o Endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o Telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        //cadPessoa.addPessoa(p);
        pessoaS.cadastroPessoa(p);
        System.out.println(p.getNome() + " cadastrado com sucesso");

    }//fim cadastrar pessoa

    private static void EditaPessoa() {
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        System.out.print("Editar cadastro de Proprietário");
        boolean isCPF;
        do {
            System.out.print("Informe o CPF do ficheiro a ser editado: ");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Pessoa p = pessoaS.getPessoaByDoc(cpf); //cadPessoa.getPessoaCPF(cpf);
                if (p.getCpf() != null) {
                    do {
                        System.out.println("Quais dados de " + p.getNome() + " deseja alterar?");
                        System.out.println("1- Nome");
                        System.out.println("2- Endereço");
                        System.out.println("3- Telefone");
                        System.out.println("4- Todos");
                        System.out.println("0- Voltar");
                        System.out.print("Digite aqui: ");
                        int op = leiaNumInt();
                        if (op == 1 || op == 4) {
                            System.out.print("Informe o novo nome: ");
                            p.setNome(leia.nextLine());
                        }
                        if (op == 2 || op == 4) {
                            System.out.print("Informe o novo Endereço: : ");
                            p.setEndereco(leia.nextLine());
                        }
                        if (op == 3 || op == 4) {
                            System.out.print("Informe o novo Telefone: ");
                            p.setTelefone(leia.nextLine());
                        }
                        if (op == 0) {
                            System.out.print("Operação cancelada pelo usuário.");
                            isCPF = false;
                        }
                        if (op < 0 || op > 4) {
                            System.out.print("Opção inválida!");

                        }
                        if (op > 0 && op < 4) {
                            pessoaS.atualizarPessoa(p);

                        }
                        isCPF = false;
                    } while (isCPF);//fim do do

                } else {
                    System.out.println("CPF não cadastrado.");
                    isCPF = false;
                }
            } else {
                System.out.println("CPF inválido.");
                Deukk();
            }
        } while (isCPF);

    }//fim do edita pessoa

    private static void EditaCarro() {
        CarroServicos carroS = ServicosFactory.getCarroServicos();
        System.out.println("Editor de cadastro de veiculo");
        boolean isPlaca;
        do {
            System.out.println("Informe a placa do veiculo desejado: ");
            String placa = leia.nextLine();
            placa = placa.toUpperCase();
            isPlaca = Validadores.validarPlaca(placa);
            if (isPlaca) {
                Carro c;
                c = carroS.getCarroByDoc(placa);
                if (c.getPlaca() != null) {
                    System.out.println(c.toString());
                    do {
                        System.out.println("Quais dados de " + c.getPlaca() + " vai ser alterado?");
                        System.out.println("1- cor; ");
                        System.out.println("2- A porra do Cambio;");
                        System.out.println("3- A porra  do combustivel;");
                        System.out.println("4-O infeliz do Proprietário;");
                        System.out.println("5- A PORRA TODA!!!!!;");
                        System.out.println("0- FODA-SE ESSA MERDA!!!");
                        System.out.println("Digite aqui? ");
                        int op = leiaNumInt();
                        if (op == 1 || op == 5) {
                            System.out.print("Informe a porra da cor: ");
                            c.setCor(leia.nextLine().toUpperCase());
                        }
                        if (op == 2 || op == 5) {
                            System.out.print("Informe a porra do cambio: : ");
                            c.setTpCambio(leia.nextLine().toUpperCase());
                        }
                        if (op == 3 || op == 5) {
                            System.out.print("Informe a porra do combustivel: ");
                            c.setCombustivel(leia.nextLine().toUpperCase());
                        }
                        if (op == 4 || op == 5) {
                            boolean isCPF;
                            do {
                                System.out.print("Informe o CPF do novo Proprietário: ");
                                String cpf = leia.nextLine();
                                isCPF = Validadores.isCPF(cpf);
                                if (isCPF) {
                                    Pessoa p = cadPessoa.getPessoaCPF(cpf);
                                    if (p != null) {
                                        System.out.println("Pessoa selecionada: " + p.getNome());
                                        System.out.println("Está correto?");
                                        System.out.println("1- sim || 2- não");
                                        op = leiaNumInt();
                                        if (op == 1) {
                                            isCPF = false;
                                            c.setProprietario(p);
                                        }
                                    } else {
                                        System.out.println("CPF não dacastrado!!!");
                                        System.out.println("Informe o que deseja fazer a seguir:");
                                        System.out.println("1-Cadastrar");
                                        System.out.println("2-Tentar novamente");
                                        int op2 = leiaNumInt();
                                        if (op2 == 1) {
                                            cadastrarPessoa();
                                        }
                                    }
                                } else {
                                    System.out.println("CPF inválido!!!");
                                    isCPF = true;
                                }
                            } while (isPlaca);
                        }
                        if (op == 0) {
                            System.out.print("Operação cancelada pelo usuário.");
                            isPlaca = false;
                        }
                        if (op < 0 || op > 5) {
                            System.out.print("Opção inválida!");
                        }
                        isPlaca = false;
                    } while (isPlaca);
                } else {
                    System.out.println("Placa não cadastrada.");
                    isPlaca = true;
                }
            } else {
                System.out.println("Placa não encontrada");
                System.out.println("Deseja tentar novamente?");
                System.out.println("1- sim | 2- não");
                System.out.println("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 1) {
                    isPlaca = true;
                }
            }
        } while (isPlaca);
    }// fim do edita carro

    private static void ListarPessoa() {
        System.out.println("Listar Pessoas");
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        if (pessoaS.getPessoas().isEmpty()) {
            System.out.println("Nunca nem vi ninguem!!!");
        } else {
            for (Pessoa pessoa : pessoaS.getPessoas()) {
                System.out.println(pessoa.toString());
            }
        }
    }//fim do listar pessoa

    private static void ListarCarro() {
        System.out.println("Listar Carros");
        CarroServicos carroS = ServicosFactory.getCarroServicos();
        if (carroS.getCarro().isEmpty()) {
            System.out.println("Num deu!?!");
        } else {
            for (Carro carro : carroS.getCarro()) {
                System.out.println(carro.toString());
            }//fim do for
        }
    }//fim do listar carros

    private static void DeletaPessoa() {
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        System.out.println("Deletar Pessoas");
        boolean delCPF = false;
        do {
            System.out.println("Informe o cpf da pessoa a ser removida: ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Pessoa p = pessoaS.getPessoaByDoc(cpf);
                if (p.getCpf() != null) {
                    System.out.println("Deseja deletar " + p.getNome() + "?");
                    System.out.println("1-SIM / 2-NÃO");
                    System.out.println("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        //cadPessoa.removePessoa(p);
                        pessoaS.deletarPessoa(cpf);
                        System.out.println("Velorio encomendádo!!!");
                        delCPF = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário.");
                        delCPF = false;
                    }
                } else {
                    System.out.println("CPF não cadastrado!");
                    Deukk();
                }
            } else {
                System.out.println("CPF inválido");
                delCPF = true;
            }
        } while (delCPF);
    }//fim deletar pessoa

    private static void DeletaCarro() {
        Carro c;
        CarroServicos carroS = ServicosFactory.getCarroServicos();
        System.out.println("dELEÇÃO DE CARROS");
        boolean dplaca = false;
        do {
            System.out.println("Informe a placa do carro que deseja remover do sistema: ");
            String placa = leia.nextLine().toUpperCase();
            c = carroS.getCarroByDoc(placa);
            if (c.getPlaca() != null) {
                //Carro p = cadCarro.getCarro(placa);
                c = carroS.getCarroByDoc(placa);
                if (c.getPlaca() != null) {
                    System.out.println("Deseja deletar " + c.getPlaca() + "/" +c.getModelo() +"?");
                    System.out.println("1- sim | 2- não");
                    System.out.println("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        //cadCarro.removeCarro(p);
                        carroS.deletarCarro(c.getPlaca());
                        System.out.println("Veiculo removido.");
                        dplaca = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário.");
                        dplaca = false;
                    }
                } else {
                    System.out.println("Veiculo não cadastrado");
                    Deukk();
                    dplaca = false;
                }

            } else {
                System.out.println("Placa invalida");
                dplaca = true;
            }
        } while (c.getPlaca() == null);
    }// fim do deleta carro

    private static boolean Deukk() {
        System.out.println("Operação invalida!!!");
        System.out.println("1-Tentar novamente.");
        System.out.println("2-Cancelar .");
        System.out.println("Digite aqui");
        int op = leiaNumInt();
        if (op == 2) {
            return false;
        }
        return true;
    }// fim do deuKK

}//fim da public class
