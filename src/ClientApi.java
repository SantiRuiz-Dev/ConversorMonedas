import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientApi {
    public static String obtenerTasas(String monedaBase) throws Exception {
        String apiKey = "6a18959a16248672a7370237"; //
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;

        URL url = new URL(direccion);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        StringBuilder respuesta = new StringBuilder();

        while ((linea = lector.readLine()) != null) {
            respuesta.append(linea);
        }
        lector.close();
        return respuesta.toString();
    }
}
