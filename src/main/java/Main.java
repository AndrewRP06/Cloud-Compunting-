import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CloudServer cloudServer = new CloudServer();
        ArrayList<FogNode> fogs = new ArrayList<>();
        ArrayList<EdgeNode> edges = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            FogNode fog = new FogNode(i, cloudServer);
            fogs.add(fog);
            for (int j = 1; j <= 5; j++) {
                edges.add(new EdgeNode(j, fog));
            }
        }

        boolean limiteAlcanzado = false;
        while (!limiteAlcanzado) {
            for (EdgeNode edge : edges) {
                edge.enviarDato();

                for (FogNode f : fogs) {
                    if (f.getContadorAltas() >= 20) {
                        limiteAlcanzado = true;
                        System.out.println("\nLimite de 20 temperaturas altas alcanzado en FOG " + f.getIdFog());
                        break;
                    }
                }
                if (limiteAlcanzado) break;
            }
        }

        cloudServer.mostrarResumen();
    }
}
