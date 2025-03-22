package com.api.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre_completo") //Definimos el nombre de la columna
    private String nombre;
    private String apellido;
    private int edad;

    @ManyToOne  //Definimos la relación que se tiene según el caso, de uno a muchos
    @JoinColumn (name = "id_pais")
    private Pais pais;
    @ManyToOne
    @JoinColumn (name = "id_estado")
    private Estado estado;
    
    
    //Generamos nuestro método constructor
    public Persona(){
    }

    public Persona(String nombre, String apellido, int edad, Pais pais, Estado estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.estado = estado;
    }

    //Generamos Getter y Setter de nuestra clase
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
