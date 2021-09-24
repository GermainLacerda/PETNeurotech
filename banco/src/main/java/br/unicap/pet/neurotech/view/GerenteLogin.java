package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ADMController;
import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class GerenteLogin {
    public void Login() {
        int login;
        String senha = " ";
        int op;

        MenuGerente acessoGerente = new MenuGerente();
        ADMController acesso = new ADMController();
        ADMView acessoAdmView = new ADMView();

        do {
            System.out.println("<<Login para gerente>>");
            System.out.println("1 - Entrar");
            System.out.println("2 - Criar");
            System.out.println("3 - Voltar");
            op = Leitor.getLeitor().nextInt();
            switch (op) {
                case 1:
                    System.out.println("Informe seu Id de gerente");
                    login = Leitor.getLeitor().nextInt();
                    while (acesso.VerificarLogin(login) == false) {
                        System.out.println("Informe novamente o seu Id de gerente");
                        login = Leitor.getLeitor().nextInt();
                    }
                    int opc;
                    do {
                        System.out.println("1 - Insira sua senha");
                        System.out.println("2 - Alterar senha");
                        System.out.println("3 - Sair");
                        opc = Leitor.getLeitor().nextInt();
                        switch (opc) {
                            case 1:
                                System.out.println("Informe sua Senha");
                                senha = Leitor.getLeitor().next();
                                while (acesso.ValidarSenha(senha) == false) {
                                    System.out.println("Informe novamente sua Senha");
                                    senha = Leitor.getLeitor().next();
                                }
                                break;
                            case 2:
                                acessoAdmView.AlterarSenha();
                                System.out.println("Informe sua Senha");
                                senha = Leitor.getLeitor().next();
                                while (acesso.ValidarSenha(senha) == false) {
                                    System.out.println("Informe novamente sua Senha");
                                    senha = Leitor.getLeitor().next();
                                }
                                break;
                            case 3:
                                System.out.println("Voltando!");
                                break;
                            default:
                                System.out.println("Opção invalida!");
                        }

                    } while (opc != 3);
                    if (acesso.VerificarLogin(login) == true && acesso.ValidarSenha(senha) == true && acesso.VerificarGerente(login) == true) {
                        acessoGerente.Menu();
                    }
                    break;
                case 2:
                    acessoAdmView.CriarContaGerente();
                    break;
                case 3:
                    System.out.println("Voltando!");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (op != 3);

    }
}
