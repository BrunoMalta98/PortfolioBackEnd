/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Bruno.demo.Entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Persona {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50,message = "no cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50,message = "no cumple con la longitud")
    private String apellido;
    @NotNull
    @Size(min = 1, max = 100,message = "no cumple con la longitud")
    private String titulo;
    @NotNull
    @Size(min = 1, max = 200,message = "no cumple con la longitud")
    private String universidades;
    @NotNull
    @Size(min = 1, max = 700,message = "no cumple con la longitud")
    private String descripcion;
    
    
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String universidades, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.universidades = universidades;
        this.descripcion = descripcion;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
