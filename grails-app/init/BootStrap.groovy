import com.itam.califica.Alumno

class BootStrap {

    def init = { servletContext ->
        
        Alumno a1 = new Alumno(1, "Gerardo", "Meza", "Gonzalez", "97090522");
        a1.save();
        Alumno a2 = new Alumno(1, "Daniel", "Meza", "Gonzalez", "990302202");
        a2.save();
        Alumno a3 = new Alumno(1, "Eduardo", "Meza", "Gonzalez", "454000230");
        a3.save();
    }
    def destroy = {
    }
}
