public class EdgeNode {
    private FogNode fogNode;
    private int idEdge;

    public EdgeNode(int idEdge, FogNode fogNode) {
        this.idEdge = idEdge;
        this.fogNode = fogNode;
    }

    public void enviarDato() {
        String sensorId = "F" + fogNode.getIdFog() + "-E" + idEdge;
        double temperatura = 15 + Math.random() * 25;
        temperatura = Math.round(temperatura * 10.0) / 10.0;
        SensorData dato = new SensorData(sensorId, temperatura);

        System.out.println("[EDGE " + idEdge + " de FOG " + fogNode.getIdFog() + "] Dato generado: " + dato);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fogNode.procesarDato(dato, idEdge);
    }
}
