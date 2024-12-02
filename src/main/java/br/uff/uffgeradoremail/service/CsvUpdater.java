package br.uff.uffgeradoremail.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class CsvUpdater {
    public void atualizarUffMail(String filePath, String matricula, String uffmail) {
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> linhas = reader.readAll();
            reader.close();

            for (String[] linha : linhas) {
                if (linha[1].equals(matricula)) {
                    linha[4] = uffmail;
                    break;
                }
            }

            CSVWriter writer = new CSVWriter(new FileWriter(filePath));
            writer.writeAll(linhas);
            writer.close();

        } catch (Exception e) {
            System.err.println("Erro ao atualizar o arquivo CSV: " + e.getMessage());
        }
    }
}