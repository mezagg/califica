package com.itam.califica

class Calificaciones {
    Integer id
    String grupo
    String materia
    static belongsTo = [alumno: Alumno]

    Double calificacion
    
    
    public Calificaciones(String grupo, String materia, Alumno a, Double calificacion ){
        this.grupo = grupo
        this.materia = materia
        this.alumno = a
        this.calificacion = calificacion
    }
    
    static constraints = {
    }
}
