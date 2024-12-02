package br.uff.uffgeradoremail.service;

import br.uff.uffgeradoremail.model.Aluno;
import com.opencsv.CSVReader;

import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;

public class CsvReader {
    public List<Aluno> lerAlunos(String filePath) {
        List<Aluno> alunos = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] proxLinha;
            reader.readNext();
            while ((proxLinha = reader.readNext()) != null) {
                Aluno aluno = new Aluno(proxLinha[0], proxLinha[1], proxLinha[2], proxLinha[3], proxLinha[4], proxLinha[5]);
                alunos.add(aluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alunos;
    }
}
