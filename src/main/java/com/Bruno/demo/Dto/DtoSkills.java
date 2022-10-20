/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author bruno
 */
public class DtoSkills {

    @NotBlank
    private String nombreS;
    @NotBlank
    private int porcentaje;

    public DtoSkills() {
    }

    public DtoSkills(String nombreS, int porcentaje) {
        this.nombreS = nombreS;
        this.porcentaje = porcentaje;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
