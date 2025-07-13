/**
 *
 * @author Marcelo Alfredo Paz Pezo
 */
package com.mycompany.rest.service;

import com.mycompany.rest.model.Parcela;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class ParcelaService {
    private final Map<String, Parcela> parcelas = new ConcurrentHashMap<>();

    public ParcelaService() {
        // Datos de ejemplo para probar
        parcelas.put("ROL-001", new Parcela("ROL-001", 0.8, 0.2, 30.0, 10.5));
        parcelas.put("ROL-002", new Parcela("ROL-002", 0.7, 0.9, 28.0, 5.2));
        parcelas.put("ROL-003", new Parcela("ROL-003", 0.3, 0.3, 26.0, 12.0));
    }

    public List<Parcela> listarTodas() {
        return new ArrayList<>(parcelas.values());
    }

    public Optional<Parcela> obtenerPorRol(String rol) {
        return Optional.ofNullable(parcelas.get(rol));
    }

    public Parcela agregarParcela(Parcela parcela) {
        parcelas.put(parcela.getROL(), parcela);
        return parcela;
    }

    public long contarParcelasPropensasAIncendio() {
        return parcelas.values().stream()
            .filter(p -> p.getIndiceCombustible() >= 0.60 &&
                         p.getIndiceHumedad() <= 0.40 &&
                         p.getTemperaturaZona() >= 25.0)
            .count();
    }
    
    public Optional<Parcela> aplicarCortaFuego(String rol, double nuevoIndice) {
        Optional<Parcela> parcelaOpt = obtenerPorRol(rol);
        if (parcelaOpt.isPresent()) {
            Parcela p = parcelaOpt.get();
            p.setIndiceCombustible(Math.max(0.0, nuevoIndice));
            return Optional.of(p);
        }
        return Optional.empty();
    }
}