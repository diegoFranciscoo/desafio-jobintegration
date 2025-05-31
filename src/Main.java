import service.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "servidores.txt";
        String logFile = "log.txt";

        ServerIpReader serverIpReader = new ServerIpReader();
        PingServerService ping = new PingServerService();
        ProcessChecker processChecker = new ProcessChecker();
        LogService log = new LogService(logFile);
        NotificationService notification = new NotificationService();

        var servers = serverIpReader.readIpServers(filePath);

        for (String ip : servers) {
            boolean accessible = ping.isAccessible(ip);

            if (accessible){
                String processStatus = processChecker.checkProcess();

                log.log("Servidor: " + ip + " | Status: Online" + " | Processo: " + processStatus);

                if (processStatus.equalsIgnoreCase("Processo inativo")) notification.notifyTeam(ip);
            }else {
                log.log("Servidor: " + ip +
                        " | Status: Offline" +
                        " | Processo: Indisponível");
            }
        }
    }
}
