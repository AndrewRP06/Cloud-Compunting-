public class FogNode {
    private CloudServer cloudServer;
    private int idFog;
    private int contadorAltas = 0;

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

        cloudServer.guardarDato(dato);
    }

    public int getContadorAltas() {
        return contadorAltas;
    }

    public int getIdFog() {
        return idFog;
    }
}