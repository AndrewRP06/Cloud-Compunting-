import java.util.ArrayList;

public class FogNode {
    private CloudServer cloudServer;
    private int idFog;
    private int contadorAltas = 0;
    private ArrayList<SensorData> buffer = new ArrayList<>();

    public FogNode(int idFog, CloudServer cloudServer) {
        this.idFog = idFog;
        this.cloudServer = cloudServer;
    }

    public void procesarDato(SensorData dato, int idEdge) {
        System.out.print("[FOG " + idFog + "] Dato recibido de EDGE " + idEdge + ": " + dato);

        if (dato.getTemperatura() > 30) {
            contadorAltas++;
            System.out.println(" TEMPERATURA ALTA (total altas fog " + idFog + ": " + contadorAltas + ")");
        } else {
            System.out.println();
        }

        buffer.add(dato);
        if (buffer.size() >= 5) {
            enviarLoteAlCloud();
        }
    }

    private void enviarLoteAlCloud() {
        System.out.println("[FOG " + idFog + "] Lote de 5 datos listo. Procesando antes de enviar al Cloud...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[FOG " + idFog + "] Enviando lote de 5 datos al Cloud:");
        for (SensorData dato : buffer) {
            System.out.println("  -> " + dato);
            cloudServer.guardarDato(dato);
        }
        System.out.println("[FOG " + idFog + "] Lote enviado correctamente.\n");

        buffer.clear();
    }

    public int getContadorAltas() {
        return contadorAltas;
    }

    public int getIdFog() {
        return idFog;
    }
}
