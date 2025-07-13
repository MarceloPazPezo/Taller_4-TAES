
/**
 *
 * @author Marcelo Alfredo Paz Pezo
 */
package com.mycompany.rest.controller;

import com.mycompany.rest.model.Parcela;
import com.mycompany.rest.service.ParcelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parcelas")
public class ParcelaController {

    @Autowired
    private ParcelaService parcelaService;

    @GetMapping
    public List<Parcela> listarTodasLasParcelas() {
        return parcelaService.listarTodas();
    }

    @GetMapping("/{rol}")
    public ResponseEntity<Parcela> obtenerParcelaPorRol(@PathVariable String rol) {
        return parcelaService.obtenerPorRol(rol)
                .map(parcela -> ResponseEntity.ok(parcela))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Parcela agregarParcela(@RequestBody Parcela parcela) {
        return parcelaService.agregarParcela(parcela);
    }

    @GetMapping("/propensas/cantidad")
    public long contarParcelasPropensas() {
        return parcelaService.contarParcelasPropensasAIncendio();
    }

    @PutMapping("/{rol}/cortafuegos")
    public ResponseEntity<Parcela> aplicarCortafuegos(@PathVariable String rol, @RequestBody Map<String, Double> body) {
        double nuevoIndice = body.get("nuevoIndiceCombustible");
        return parcelaService.aplicarCortaFuego(rol, nuevoIndice)
                .map(parcela -> ResponseEntity.ok(parcela))
                .orElse(ResponseEntity.notFound().build());
    }
}