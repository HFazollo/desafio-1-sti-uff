package br.uff.uffgeradoremail.util;

import java.util.Random;

public class SmsService {
    public static void enviarSenha(String telefone) {
        String senha = gerarSenha();
        System.out.println("Um SMS foi enviado para " + telefone + " com a senha: " + senha);
    }

    private static String gerarSenha() {
        Random random = new Random();
        int senha = 100000 + random.nextInt(900000);
        return String.valueOf(senha);
    }
}
