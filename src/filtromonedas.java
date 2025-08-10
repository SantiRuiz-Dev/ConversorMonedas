import java.util.HashMap;
import java.util.Map;

public class filtromonedas {
    public static Map<String, Double> filtrar(Map<String, Double> tasas, String[] monedas) {
        Map<String, Double> filtradas = new HashMap<>();
        for (String moneda : monedas) {
            if (tasas.containsKey(moneda)) {
                filtradas.put(moneda, tasas.get(moneda));
            }
        }
        return filtradas;
    }
}
