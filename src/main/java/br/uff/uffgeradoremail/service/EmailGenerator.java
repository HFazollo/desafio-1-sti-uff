package br.uff.uffgeradoremail.service;

import br.uff.uffgeradoremail.model.Aluno;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmailGenerator {
    public List<String> gerarOpcoesEmail(Aluno aluno) {
        String[] nomePartes = aluno.getNome().toLowerCase().split(" ");
        Set<String> opcoesEmail = new HashSet<>();

        if (nomePartes.length > 1) {
            opcoesEmail.add(nomePartes[0] + "_" + nomePartes[nomePartes.length - 1] + "@id.uff.br");
        }

        opcoesEmail.add(nomePartes[0] + nomePartes[nomePartes.length - 1].charAt(0) + "@id.uff.br");

        opcoesEmail.add(nomePartes[0] + "@id.uff.br");

        if (nomePartes.length > 1) {
            opcoesEmail.add(nomePartes[0] + nomePartes[nomePartes.length - 1] + "@id.uff.br");
        }

        String iniciais = nomePartes[0].charAt(0) +
                (nomePartes.length > 1 ? String.valueOf(nomePartes[nomePartes.length - 1].charAt(0)) : "") +
                "@id.uff.br";
        opcoesEmail.add(iniciais);

        return new ArrayList<>(opcoesEmail);
    }

    public boolean validarEmail(String email) {
        return email != null &&
                email.matches("^[a-z0-9_]+@id\\.uff\\.br$") &&
                email.length() <= 30;
    }
}