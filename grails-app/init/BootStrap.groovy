
import com.itam.califica.Alumno
import com.itam.califica.Calificaciones

class BootStrap {

    def init = { servletContext ->
        
        Alumno a1 = new Alumno( "Geronimo", "Juarez", "Keinz", "97090522");
        a1.save();
        Alumno a2 = new Alumno( "Daniel", "Meza", "Gonzalez",  "99030220");
        a2.save();
        Alumno a3 = new Alumno( "Eduardo", "Hernandez", "Santamaria", "4540002");
        a3.save();
        Alumno a4 = new Alumno("Ferando", "Hernandez", "Santamaria", "4540002");
        a4.save();
     Alumno a5 = new Alumno("Hugo", "Samariz", "Santamaria", "4540002");
        a5.save();
     Alumno a6 = new Alumno("Sandra", "Chao", "Santamaria", "4540002");
        a6.save();
     Alumno a7 = new Alumno("Jaime", "Linn", "Santamaria", "4540002");
        a7.save();
     Alumno a8 = new Alumno("Patricio", "Pruneda", "Santamaria", "4540002");
        a8.save();
     
         Alumno a9 = new Alumno("Natalia", "Africa", "Santamaria", "4540002");
        a9.save();
        
         Alumno a = new Alumno("Natalia", "Minuto", "Santamaria", "4540002");
        a.save();
         a = new Alumno("Veronica", "Linares", "Santamaria", "4540002");
        a.save();
         a = new Alumno("Mauricio", "Amercia", "Santamaria", "4540002");
        a.save();
         a = new Alumno("Geronimo", "Noruega", "Santamaria", "4540002");
        a.save();
         a = new Alumno("Israel", "Lopez", "Santamaria", "4540002");
        a.save();
         a = new Alumno("Cesar", "Castillo", "Santamaria", "4540002");
        a.save();
         a = new Alumno("Mauricio", "Hernandez", "Santamaria", "4540002");
        a.save();
        
        Calificaciones c1 = new Calificaciones("G1","M1",a1,10)
        c1.save();
        Calificaciones c2 = new Calificaciones("G1","M1",a2,10)
        c2.save();
        Calificaciones c3 = new Calificaciones("G1","M1",a3,10)
        c3.save();
        Calificaciones c4 = new Calificaciones("G1","M2",a1,7)
        c4.save();
        Calificaciones c5 = new Calificaciones("G1","M2",a2,6)
        c5.save();
        Calificaciones c6 = new Calificaciones("G1","M2",a3,4)
        c6.save();
    }
    def destroy = {
    }
}
