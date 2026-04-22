import java.util.ArrayList;

public class CloudServer {
    private ArrayList<SensorData> datos = new ArrayList<>();

    public void guardarDato(SensorData dato) {
        datos.add(dato);
    }

    public void mostrarResumen() {
        System.out.println("\n===== RESUMEN CLOUD SERVER =====");
        System.out.println("Total de datos recibidos: " + datos.size());
        for (SensorData dato : datos) {
            System.out.println(dato);
        }
        System.out.println("================================\n");
    }
}