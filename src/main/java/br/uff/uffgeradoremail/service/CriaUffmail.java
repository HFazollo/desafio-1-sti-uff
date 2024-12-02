package br.uff.uffgeradoremail.service;

import br.uff.uffgeradoremail.model.Aluno;
import br.uff.uffgeradoremail.util.SmsService;

import java.util.List;
import java.util.Scanner;

public class CriaUffmail {
    public static void processarCriacaoUffMail(Scanner sc, CsvReader csvReader,
                                                EmailGenerator emailService,
                                                CsvUpdater csvUpdater) {
        List<Aluno> alunos = csvReader.lerAlunos("src/main/resources/alunos.csv");

        System.out.print("Digite sua matrícula: ");
        String matricula = sc.nextLine();

        Aluno aluno = alunos.stream()
                .filter(a -> a.getMatricula().trim().equals(matricula.trim()) &&
                        a.getStatus().trim().equalsIgnoreCase("ativo") &&
                        (a.getUffmail() == null || a.getUffmail().trim().isEmpty()))
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("Aluno não encontrado, inativo ou já possui UFFMail!");
            return;
        }

        List<String> opcoes = emailService.gerarOpcoesEmail(aluno);

        System.out.println(aluno.getNome() + ", por favor escolha uma das opções abaixo para o seu UFFMail:");
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + " - " + opcoes.get(i));
        }

        int escolha;
        while (true) {
            try {
                escolha = sc.nextInt();
                if (escolha > 0 && escolha <= opcoes.size()) {
                    break;
                }
                System.out.println("Opção inválida. Tente novamente.");
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next();
            }
        }

        String emailEscolhido = opcoes.get(escolha - 1);

        if (!emailService.validarEmail(emailEscolhido)) {
            System.out.println("E-mail inválido!");
            return;
        }

        aluno.setUffmail(emailEscolhido);
        csvUpdater.atualizarUffMail("src/main/resources/alunos.csv", aluno.getMatricula(), emailEscolhido);

        System.out.println("A criação de seu e-mail (" + emailEscolhido + ") será feita nos próximos minutos.");
        SmsService.enviarSenha(aluno.getTelefone());
    }
}
