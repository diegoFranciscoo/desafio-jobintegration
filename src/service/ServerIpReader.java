package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerIpReader {

    public List<String> readIpServers(String filePath) {
        List<String> ips = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ips.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return ips;
    }
}
