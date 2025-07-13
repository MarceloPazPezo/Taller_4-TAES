/**
 *
 * @author Marcelo Alfredo Paz Pezo
 */
package com.mycompany.rest.model;

public class Parcela {
    private String ROL;
    private double indiceCombustible; // 0.0 (agua) a 1.0 (bencina 97)
    private double indiceHumedad; // 0.0 (seco) a 1.0 (saturado)
    private double temperaturaZona;
    private double hectareas;

    public Parcela() {
    }
    
    public Parcela(String ROL, double indiceCombustible, double indiceHumedad, double temperaturaZona, double hectareas) {
        this.ROL = ROL;
        this.indiceCombustible = indiceCombustible;
        this.indiceHumedad = indiceHumedad;
        this.temperaturaZona = temperaturaZona;
        this.hectareas = hectareas;
    }

    public String getROL() {
        return ROL;
    }

    public void setROL(String ROL) {
        this.ROL = ROL;
    }

    public double getIndiceCombustible() {
        return indiceCombustible;
    }

    public void setIndiceCombustible(double indiceCombustible) {
        this.indiceCombustible = indiceCombustible;
    }

    public double getIndiceHumedad() {
        return indiceHumedad;
    }

    public void setIndiceHumedad(double indiceHumedad) {
        this.indiceHumedad = indiceHumedad;
    }

    public double getTemperaturaZona() {
        return temperaturaZona;
    }

    public void setTemperaturaZona(double temperaturaZona) {
        this.temperaturaZona = temperaturaZona;
    }

    public double getHectareas() {
        return hectareas;
    }

    public void setHectareas(double hectareas) {
        this.hectareas = hectareas;
    }
}
