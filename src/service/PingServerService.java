package service;

import java.io.IOException;
import java.net.InetAddress;

public class PingServerService {

    public boolean isAccessible(String ip){
        String os = System.getProperty("os.name").toLowerCase();
        String command;

        if (os.contains("win")) {
            command = "ping -n 1 " + ip;
        } else {
            command = "ping -c 1 " + ip;
        }

        try {
            Process process = Runtime.getRuntime().exec(command);
            int returnVal = process.waitFor();
            return (returnVal == 0);
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }
}
