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
public class DtoPersona {
    
   
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String titulo;
    @NotBlank
    private String universidades;
    @NotBlank
    private String descripcion;
    
    private String img;
    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String titulo, String universidades, String descripcion,String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.universidades = universidades;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidades() {
        return universidades;
    }

    public void setUniversidades(String universidades) {
        this.universidades = universidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
