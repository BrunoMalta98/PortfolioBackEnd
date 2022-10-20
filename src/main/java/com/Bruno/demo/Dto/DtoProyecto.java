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
public class DtoProyecto {
    
    @NotBlank
    private String nombreP;
    @NotBlank
    private String lenguajes;
    @NotBlank
    private String link;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imgP;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreP, String lenguajes, String link, String descripcion, String imgP) {
        this.nombreP = nombreP;
        this.lenguajes = lenguajes;
        this.link = link;
        this.descripcion = descripcion;
        this.imgP = imgP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
    
}
