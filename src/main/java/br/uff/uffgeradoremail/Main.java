package br.uff.uffgeradoremail;

import br.uff.uffgeradoremail.service.CriaUffmail;
import br.uff.uffgeradoremail.service.CsvReader;
import br.uff.uffgeradoremail.service.CsvUpdater;
import br.uff.uffgeradoremail.service.EmailGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CsvReader csvReader = new CsvReader();
        EmailGenerator emailService = new EmailGenerator();
        CsvUpdater csvUpdater = new CsvUpdater();

        while (true) {
            System.out.println("\n--- Sistema de Geração de UFF Mail ---");
            System.out.println("1 - Criar UFFMail");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcaoMenu;
            try {
                opcaoMenu = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.nextLine();
                continue;
            }

            switch (opcaoMenu) {
                case 1:
                    CriaUffmail.processarCriacaoUffMail(sc, csvReader, emailService, csvUpdater);
                    break;
                case 2:
                    System.out.println("Encerrando o sistema. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}