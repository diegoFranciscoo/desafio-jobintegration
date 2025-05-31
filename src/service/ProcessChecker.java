package service;

import java.util.Random;

public class ProcessChecker {
    public String checkProcess() {
        Random random = new Random();
        return random.nextBoolean() ? "Processo ativo" : "Processo inativo";
    }
}
