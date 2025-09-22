import java.util.ArrayList;
import java.util.List;

public class ListaMaterias {
    private List<String> materias;

    public ListaMaterias(){
        materias = new ArrayList<>();
    }

    public void agregar(String materia){
        materias.add(materia);
    }

    public boolean contiene(String materia){
        for (String m : materias) {
            if (m.equalsIgnoreCase(materia)){
                return true;
            }
        }
        return false;
    }

    public void imprimir(){
        System.out.println("Materias: " + materias);
    }
}
