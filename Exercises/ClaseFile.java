package EjerciciosT6;

import java.io.*;

public class ClaseFile {
    
    public static void leeFichero(String ruta){
        
        File f=new File (ruta);
        
        if(f.isFile() && f.canRead()){
            try{ 
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    if(linea.contains("barco") || linea.contains("pirata")){
                        System.out.println(linea);
                    }
                }
                br.close();
                fr.close();
            }catch(IOException error){
                System.out.println(error);
            }
        }
    }
    
    public static void rywFichero(String ruta, String ruta1){
        
        File f=new File (ruta);
        
        if(f.isFile() && f.canRead() && f.canRead()){
            try{ 
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                FileWriter fw=new FileWriter(ruta1);
                String linea;
                while((linea=br.readLine())!=null){
                    if(linea.contains("mar")){
                        fw.write(linea + "\n");
                    }
                }
                br.close();
                fr.close();
                fw.close();
            }catch(IOException error){
                System.out.println(error);
            }
        }
    }
    
    public static void edadNombre(String ruta){
        
        File f=new File (ruta);
        
        if(f.isFile() && f.canRead()){
            try{ 
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                String linea;
                String [] datos=new String [5];
                
                br.read();
                while((linea=br.readLine())!=null){
                    
                    datos=linea.split(" ");
                    if(Integer.parseInt(datos[3])<=20){
                        System.out.println(datos[0]);
                    }
                }
                br.close();
                fr.close();
            }catch(IOException error){
                System.out.println(error);
            }
        }
    }
    
    public static void leeDatos(String ruta){
        
        File f=new File (ruta);
    
        if(f.isFile() && f.canRead()){
            try{ 
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                String linea;
                String [] datos=new String [5];
                
                br.readLine();
                
                while((linea=br.readLine())!=null){
                    
                    datos=linea.split(" ");
                    
                    if(datos[1].startsWith("C")){
                        System.out.println("Usuario: " + datos[0] + " " + "Email: " + datos[4]);
                        System.out.println("-------------------------------------------");
                    }
                }
                br.close();
                fr.close();
            }catch(IOException error){
                System.out.println(error);
            }
        }else{
            System.out.println("Error con la apertura / El fichero no existe");
        }
    }
    
    public static void scriptSQL(String rutaE, String rutaS){
        
        File f1=new File (rutaE);
        File f2=new File (rutaS);
    
        if(f1.isFile() && f1.canRead()){
            try{ 
                FileReader fr=new FileReader(f1);
                BufferedReader br=new BufferedReader(fr);
                FileWriter fw=new FileWriter(f2);
                BufferedWriter bw=new BufferedWriter(fw);
                
                String linea, name, lastname, age;
                String [] datos=new String [5];
                
                br.readLine();
                
                while((linea=br.readLine())!=null){
                    
                    datos=linea.split(" ");
                    
                    name=datos[0];
                    lastname=datos[1];
                    age=datos[3];
                    
                    bw.write("Insert INTO personal (FirstName, LastName, Age) VALUES('" + name + "', '" + lastname + "', " + age + ");");
                    bw.newLine();
                
                }
                br.close();
                fr.close();
                bw.close();
                fw.close();

            }catch(IOException error){
                System.out.println(error);
            }
        }else{
            System.out.println("Error con la apertura / El fichero no existe");
        }
    }
    
    public static String [] almacenaCiudades(String ruta){
        
        File f=new File (ruta);
        String [] almacenaje=new String [100];

        if(f.isFile() && f.canRead()){
            try{ 
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                
                String linea;
                String [] datos=new String [3];
                
                br.readLine();
                int i=0;
                
                while((linea=br.readLine())!=null){
                    
                    datos=linea.split(",");
                    
                    if(datos[2].equals("si") && i<100){
                        almacenaje[i]=datos[0];
                        i++;
                    }
                    
                }
                
                br.close();
                fr.close();
            }catch(IOException error){
                System.out.println(error);
            }
        }else{
            System.out.println("Error con la apertura / El fichero no existe");
        }
        
        return almacenaje;
    }
    
    
}
