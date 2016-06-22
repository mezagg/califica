package com.itam.califica

class Alumno {
    
    Integer id
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    String matricula
    
    public Alumno(Integer id, String nombre, String ap, String am, String m){
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = ap;
        this.apellidoMaterno = am;
        this.matricula = m;
    }
    
    
    static constraints = {
    }
}
