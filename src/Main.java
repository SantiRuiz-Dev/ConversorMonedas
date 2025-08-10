import com.google.gson.Gson;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
                 //datos de la API
                String json = ClientApi.obtenerTasas("USD");

                //Convertir JSON a objeto Java
                Gson gson = new Gson();
                datosMoneda datos = gson.fromJson(json, datosMoneda.class);

                //mostrar información general
                System.out.println("Moneda base: " + datos.base_code);
                System.out.println("Última actualización: " + datos.time_last_update_utc);

                // filtrar monedas de interés
                String[] monedasInteres = {"EUR", "COP", "JPY", "MXN"};
                Map<String, Double> tasasFiltradas = filtromonedas.filtrar(datos.conversion_rates, monedasInteres);

                // mostrar resultados filtrados
                System.out.println("\n=== Tasas filtradas ===");
                for (Map.Entry<String, Double> entrada : tasasFiltradas.entrySet()) {
                    System.out.println("1 " + datos.base_code + " = " + entrada.getValue() + " " + entrada.getKey());
                }

            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
