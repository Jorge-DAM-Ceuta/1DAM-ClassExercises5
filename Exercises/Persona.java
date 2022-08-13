package EjerciciosT6;

import java.io.*;
import java.time.*;

public class Persona {
    
    private String nombre, apellido;
    private LocalDate fecha;
    private int eleccion;

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.fecha = LocalDate.now();
        this.eleccion = 0;
    }
    
    public Persona(String nombre, String apellido, String fecha, int eleccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = LocalDate.now();
        this.eleccion = eleccion;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getEleccion() {
        return eleccion;
    }

    public void setEleccion(int eleccion) {
        this.eleccion = eleccion;
    }
    
    
    public void ejercicio38(Persona [] array, String ruta){
        File f=new File(ruta);
        
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            
            String [] datos=new String [4];
            String linea;
            
            br.readLine();
            Persona p;
            int i=0;
            while((linea=br.readLine())!=null){
                datos=linea.split(",");
                p = new Persona(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]));
                array[i]=p;
                i++;
            }
            //ok
            
            
        }catch(IOException error){
            System.out.println(error);
        }
    }
    
    
    public void bubble(Persona [] array){
        boolean ordenado=false;
        while(!ordenado){
            ordenado=true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i].fecha.isAfter(array[i+1].fecha)) {
                    permuta(array,i,i+1);
                    ordenado=false;
                }
            }
        }
    }

    private void permuta(Persona [] array, int i, int j) {
        Persona backup;
        backup=array[j];
        array[j]=array[i];
        array[i]=backup;
    }
    
    
}
