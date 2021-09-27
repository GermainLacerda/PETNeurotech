package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.control.ADMController;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class ClienteLogin {
    public void Login() throws ContaInexistenteException {
        int login;
        String senha = " ";
        int op;

        MenuCliente acessoCliente = new MenuCliente();
        ADMController acesso = new ADMController();
        ADMView acessoAdmView = new ADMView();

        do {
            System.out.println("<<Login para cliente>>");
            System.out.println("1 - Entrar");
            System.out.println("2 - Criar");
            System.out.println("3 - Voltar");
            op = Leitor.getLeitor().nextInt();
            switch (op) {
                case 1:
                    System.out.println("Informe seu Id de Cliente");
                    login = Leitor.getLeitor().nextInt();
                    while (acesso.VerificarLogin(login) == false) {//verificando login ok
                        System.out.println("Informe novamente o seu Id de Cliente");
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
                                while (acesso.ValidarSenha(senha) == false) {//Validação de senha funcionando
                                    System.out.println("Informe novamente sua Senha");//enivar como exception
                                    senha = Leitor.getLeitor().next();
                                }
                                break;
                            case 2:
                                acessoAdmView.AlterarSenha();
                                System.out.println("Informe sua Senha");
                                senha = Leitor.getLeitor().next();
                                while (acesso.ValidarSenha(senha) == false) {
                                    System.out.println("Senha errada!!! Informe novamente sua Senha");
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
                    if (acesso.VerificarLogin(login) == true && acesso.ValidarSenha(senha) == true && acesso.VerificarGerente(login)==false) {
                       acessoCliente.Menu(login);
                    }
                    break;
                case 2:
                    acessoAdmView.CriarContaCliente();
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
