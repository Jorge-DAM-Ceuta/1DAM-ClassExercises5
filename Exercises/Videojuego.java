package EjerciciosT6;

import java.io.*;
import java.time.*;

public class Videojuego {
    
    private String titulo, generos, consola, edadRecomendada;
    private int  puntuaciones, maxJugadores;
    
    public Videojuego(){
        titulo="";
        maxJugadores=0;
        generos="";
        puntuaciones=0;
        consola="";
        edadRecomendada="";
    }
    
    public Videojuego(String ti, int mJ, String ge, int pu, String co, String eR){
        titulo=ti;
        maxJugadores=mJ;
        generos=ge;
        puntuaciones=pu;
        consola=co;
        edadRecomendada=eR;
    }
    
    public Videojuego(Videojuego otro){
        titulo=otro.titulo;
        maxJugadores=otro.maxJugadores;
        generos=otro.generos;
        puntuaciones=otro.puntuaciones;
        consola=otro.consola;
        edadRecomendada=otro.edadRecomendada;
    }
    
    public String toString(){
        return "El videojuego " + titulo + " del genero " + generos + " esta disponible para la consola " + consola + " a partir de " + edadRecomendada + " años. Tiene " + maxJugadores + " como máximo, ha recibido una puntuacion de " + puntuaciones;
    }
    
    public Videojuego [] ejercicio35(File f){
        Videojuego [] resultado=new Videojuego[1212];
        Videojuego videojuego=new Videojuego();
        
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String linea;
            String datos []=new String [6];
            int i=0;
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                datos=linea.split(",");
                
                videojuego=new Videojuego(datos[0], Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), datos[4], datos[5]);
                resultado[i]=videojuego;
            }
                
        }catch(IOException error){
            System.err.println(error);
        }
        
        return resultado;
    }
               
    public Videojuego [] ejercicio36(File f, File Fs){
        Videojuego [] resultado=new Videojuego[100];
        Videojuego videojuego=new Videojuego();
        
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String linea;
            String datos []=new String [6];
            int i=0;
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                datos=linea.split(",");
                
                if(datos[4].equals("Nintendo DS") && Integer.parseInt(datos[1])<=2){
                    videojuego=new Videojuego(datos[0], Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), datos[4], datos[5]);
                    resultado[i]=videojuego;
                }
            }
            
            FileWriter fw=new FileWriter(Fs);
            BufferedWriter bw=new BufferedWriter(fw);
            
            for(int j=0; j<resultado.length; j++){
                bw.write(resultado[j].toString());
                bw.newLine();
            }
            
        }catch(IOException error){
            System.err.println(error);
        }
        
            return resultado;
    }
    
    public void ejercicio37(File f){
        
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String linea;
            String datos []=new String [4];
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                datos=linea.split(",");
                
                if(Integer.parseInt(datos[3])==1){
                    System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3]);
                }
            }
            
            br.close();
            fr.close();
                
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                datos=linea.split(",");
                
                if(Integer.parseInt(datos[3])==2){
                    System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3]);
                }
            }
            
            br.close();
            fr.close();
            
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                datos=linea.split(",");
                
                if(Integer.parseInt(datos[3])==3){
                    System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3]);
                }
            }
            
            br.close();
            fr.close();
            
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            
            br.readLine();
            
            while((linea=br.readLine())!=null){
                datos=linea.split(",");
                
                if(Integer.parseInt(datos[3])==4){
                    System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3]);
                }
            }
            
            br.close();
            fr.close();
            
            
        }catch(IOException error){
            System.err.println(error);
        }
    }
    
    
    
    

    
    
    
}
   
