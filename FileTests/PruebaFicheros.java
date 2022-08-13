package PruebasFicheros;

import java.io.*;
import java.time.LocalDate;
import java.util.logging.*;

public class PruebaFicheros {

//Ficheros binarios
    public static void pruebaFOS() {
        try {
            FileOutputStream FOS = new FileOutputStream("/home/jorge/FileTest.bin");
            FOS.write((byte) 'h');
            FOS.write((byte) 'o');
            FOS.write((byte) 'l');
            FOS.write((byte) 'a');
            FOS.close();
        } catch (IOException errorData) {
            System.err.println(errorData.toString());
        }
    }

    public static void pruebaFOS(String nFichero) {
        try {
            FileOutputStream FOS = new FileOutputStream("/home/jorge/" + nFichero);
            FOS.write((byte) 'h');
            FOS.write((byte) 'o');
            FOS.write((byte) 'l');
            FOS.write((byte) 'a');
            FOS.close();
        } catch (IOException errorData) {
            System.err.println(errorData.toString());
        }
    }

    public static void pruebaFOS(String ruta, String nFichero) {

        if (ruta.charAt(0) == '/') {
            if (ruta.charAt(ruta.length() - 1) == '/' || nFichero.charAt(0) == '/') {
                try {
                    FileOutputStream FOS = new FileOutputStream(ruta + nFichero);
                    FOS.write((byte) 'h');
                    FOS.write((byte) 'o');
                    FOS.write((byte) 'l');
                    FOS.write((byte) 'a');
                    FOS.close();
                } catch (IOException errorData) {
                    System.err.println(errorData.toString());
                }
            }
        } else {
            System.err.println("Por favor, escribe correctamente la ruta empezando por una /");
        }
    }

    public static void pruebaFIS(String ruta) {
        int i;
        if (ruta.charAt(0) == '/' && ruta.endsWith(".bin")) {
            try {
                FileInputStream FIS = new FileInputStream(ruta);
                while ((i = FIS.read()) != -1) {
                    System.out.print((char) i);
                }
                FIS.close();
            } catch (IOException error) {
                System.err.println(error);
            }
        }
    }

    public static void pruebaBOS(String ruta) {
        if (ruta.charAt(0) == '/' && ruta.endsWith(".bin")) {
            try {
                FileOutputStream FOS = new FileOutputStream(ruta);
                BufferedOutputStream BOS = new BufferedOutputStream(FOS);
                BOS.write((byte) 'a');
                BOS.write((byte) 'b');
                BOS.write((byte) 'c');
                BOS.write((byte) 'd');
                BOS.write((byte) 'e');
                BOS.close();
                FOS.close();
            } catch (IOException error) {
                System.err.println(error);
            }
        }
    }

    public static void pruebaBIS(String ruta) {
        int i;

        if (ruta.charAt(0) == '/' && ruta.endsWith(".bin")) {
            try {
                FileInputStream FIS = new FileInputStream(ruta);
                BufferedInputStream BIS = new BufferedInputStream(FIS);
                while ((i = BIS.read()) != -1) {
                    System.out.print((char) i);
                }
                BIS.close();
                FIS.close();
            } catch (IOException error) {
                System.err.println(error);
            }
        }
    }

    public static void pruebaDOS(String ruta) {
        if (ruta.charAt(0) == '/' && ruta.endsWith(".bin")) {
            try {
                FileOutputStream FOS = new FileOutputStream(ruta);
                DataOutputStream DOS = new DataOutputStream(FOS);
                DOS.writeUTF("Escribiendo\n");
                DOS.writeUTF("Escribiendo un byte");
                DOS.writeByte(1);
                DOS.writeUTF("Escribiendo un numero especial: ");
                DOS.writeDouble(3.14);
                DOS.writeUTF("\n");
                DOS.writeInt(1);
                DOS.writeChar(' ');
                DOS.writeInt(2);
                DOS.writeChar(' ');
                DOS.writeInt(3);
                DOS.writeChar(' ');
                DOS.writeInt(4);
                DOS.close();
                FOS.close();
            } catch (IOException error) {
                System.err.println(error);
            }
        }
    }

    public static void pruebaDIS(String ruta) {

        if (ruta.charAt(0) == '/' && ruta.endsWith(".bin")) {
            try {
                FileInputStream FIS = new FileInputStream(ruta);
                DataInputStream DIS = new DataInputStream(FIS);
                System.out.print(DIS.readUTF());
                System.out.print(DIS.readUTF());
                System.out.print(DIS.readByte());
                System.out.print(DIS.readUTF());
                System.out.print(DIS.readDouble());
                System.out.print(DIS.readUTF());
                System.out.print(DIS.readInt());
                System.out.print(DIS.readChar());
                System.out.print(DIS.readInt());
                System.out.print(DIS.readChar());
                System.out.print(DIS.readInt());
                System.out.print(DIS.readChar());
                System.out.print(DIS.readInt());
                DIS.close();
                FIS.close();
            } catch (IOException error) {
                System.err.println(error);
            }
        }
    }

    public static void pruebaByteOS(String ruta) {
        if (ruta.charAt(0) == '/' && ruta.endsWith(".bin")) {

            try {
                FileOutputStream FOS = new FileOutputStream(ruta);
                ByteArrayOutputStream BAOS = new ByteArrayOutputStream(100);
                BAOS.write((byte) 'J');
                BAOS.write((byte) 'A');
                BAOS.write((byte) 'V');
                BAOS.write((byte) 'A');
                BAOS.writeTo(FOS);
                BAOS.flush();
                BAOS.close();
                FOS.close();
            } catch (IOException ioe) {
                System.err.println(ioe);
            }
        }
    }

    public static void pruebaByteIS(String ruta) {
        if (ruta.charAt(0) == '/' && ruta.endsWith(".bin")) {

            try {
                FileInputStream FIS = new FileInputStream(ruta);
                byte[] buffer = FIS.readAllBytes();
                ByteArrayInputStream BAIS = new ByteArrayInputStream(buffer);
                int i = 0;
                while ((i = BAIS.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (FileNotFoundException ex) {
                System.err.println(ex);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void pruebaPrint() {
        PrintStream ps = new PrintStream(System.out);
        ps.print("DAMC");
        ps.close();
    }

    public static void pruebaPrint(String ruta) {
        try {
            FileOutputStream FOS = new FileOutputStream(ruta);
            PrintStream ps = new PrintStream(FOS);
            ps.print("DAM");
            ps.close();
            FOS.close();
        } catch (IOException error) {
            System.err.println(error);
        }
    }

    public static void pruebaSequence(String ruta1, String ruta2) {
        if ((ruta1.charAt(0) == '/' && ruta1.endsWith(".bin")) && (ruta2.charAt(0) == '/' && ruta2.endsWith(".bin"))) {
            try {
                int i;
                FileInputStream FIS = new FileInputStream(ruta1);
                FileInputStream FIS2 = new FileInputStream(ruta2);
                DataInputStream DIS = new DataInputStream(FIS2);
                byte[] array = FIS.readAllBytes();
                ByteArrayInputStream BAIS = new ByteArrayInputStream(array);
                SequenceInputStream SIS = new SequenceInputStream(BAIS, DIS);

                while ((i = SIS.read()) != -1) {
                    System.out.println((char) i);
                }
                FIS.close();
                FIS2.close();
                DIS.close();
                BAIS.close();
                SIS.close();
            } catch (IOException error) {
                System.err.println(error);
            }
        }
    }

//Ficheros de texto
    public static void testFW(File f) {
        if(f.isFile() && f.canRead() && f.canWrite()){
            try {
                FileWriter fw = new FileWriter(f);
                fw.write("Examen de programacion - Tema 6\n");
                fw.write("Dia 28 de marzo de 2022.");
                fw.close();
            } catch (IOException error) {
                System.err.println(error.toString());
            }
        }
    }

    public static void testFW(File f, String contenido) {
        if(f.isFile() && f.canRead() && f.canWrite()){
            try {
                FileWriter fw = new FileWriter(f);
                fw.write(contenido);
                fw.close();
            } catch (IOException error) {
                System.err.println(error.toString());
            }
        }
    }

    public static void testFR(File f) {
        if(f.isFile() && f.canRead() && f.canWrite()){
            try {
                FileReader fr = new FileReader(f);
                int i;
                while ((i = fr.read()) != -1) {
                    System.out.print((char) i);
                }
                fr.close();
            } catch (IOException error) {
                System.err.println(error.toString());
            }
        }
    }

    public static void testBW(File f) {
        if(f.isFile() && f.canRead() && f.canWrite()){
            try {
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Instrumental necesario:\n");
                bw.newLine();
                bw.write("-Equipo portatil");
                bw.newLine();
                bw.write("-Cable de red RJ-45");
                bw.newLine();
                bw.write("-Unidad de almacenamiento externa USB");
                bw.close();
                fw.close();
            } catch (IOException error) {
                System.err.println(error.toString());
            }
        }
    }

    public static void testBR(File f, String opcion) {
        if(f.isFile() && f.canRead() && f.canWrite()){

            switch (opcion) {

                case "Lectura simple":
                    try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    int i;
                    while ((i = br.read()) != -1) {
                        System.out.print((char) i);
                    }
                    br.close();
                    fr.close();
                } catch (IOException error) {
                    System.err.println(error.toString());
                }
                break;

                case "Lectura por linea":
                    try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String lineaActual;
                    while ((lineaActual = br.readLine()) != null) {
                        System.out.print(lineaActual);
                    }
                    br.close();
                    fr.close();
                } catch (IOException error) {
                    System.err.println(error.toString());
                }
                break;
            }
        }
    }

    public static String[] testBR(File f) {
        String[] array = new String[3];

        if(f.isFile() && f.canRead() && f.canWrite()){
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String lineaActual;
                int i = 0;
                while ((lineaActual = br.readLine()) != null) {
                    if (lineaActual.charAt(0) == '-') {
                        array[i] = lineaActual;
                        i++;
                    }
                }
                br.close();
                fr.close();
            } catch (IOException error) {
                System.err.println(error.toString());
            }
        }
        return array;
    }

    public static void testCAW(File f) {
            
        if(f.isFile() && f.canRead() && f.canWrite()){
            try {
                LocalDate fecha = LocalDate.now();
                CharArrayWriter caw = new CharArrayWriter();
                FileWriter fw = new FileWriter(f);
                caw.write(fecha.toString());
                caw.writeTo(fw);
                fw.close();
                caw.close();
            } catch (IOException error) {
                System.err.println(error);
            }
        }
    }

    public static void testCAR(File f) {
        if(f.isFile() && f.canRead() && f.canWrite()){
            
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                char[] array = new char[100];
                int i, j = 0;
                while ((i = br.read()) != -1) {
                    array[j] = (char) i;
                    j++;
                }
                CharArrayReader car = new CharArrayReader(array);
                while ((i = car.read()) != -1) {
                    System.out.print((char) i);
                }
                fr.close();
                br.close();
                car.close();
             }catch (FileNotFoundException ex) {
                System.err.println(ex);
             }catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static void testPrint(File f, String opcion){
            
        if(f.isFile() && f.canRead() && f.canWrite()){
            switch(opcion){
                
                case "Escritura en codigo":
                    try{
                        FileWriter fw=new FileWriter(f);
                        PrintWriter pw=new PrintWriter(fw);
                        pw.print("Que harto estoy de ficheros");
                        pw.flush();
                        fw.close();
                        pw.close();
                    }catch(IOException error){
                        System.out.println(error);
                    }
                break;
                
                case "Escritura por consola":
                    PrintWriter pw=new PrintWriter(System.out);
                    pw.print("Escribiendo en consola...");
                    pw.flush();
                    pw.close();
                break;
            }
        }
    }
    
    public static void testLNR(File f){
        if(f.isFile() && f.canRead() && f.canWrite()){
            try{
                FileReader fr=new FileReader(f);
                LineNumberReader lnr=new LineNumberReader(fr);
                lnr.setLineNumber(9);
                String linea;
                while((linea = lnr.readLine())!=null){
                    System.out.println(lnr.getLineNumber() + "-" + lnr.readLine());
                }
                lnr.close();
                fr.close();
            }catch(IOException error){
                System.out.println(error);
            }
        }    
    }

    public static String testSW(File f){
        char[] buffer = new char[1024];
        Writer stringWriter = new StringWriter();  
        
        if(f.isFile() && f.canRead() && f.canWrite()){

            try {
                FileReader fReader = new FileReader(f);
                BufferedReader bReader = new BufferedReader(fReader);
                int n;
                while ((n = bReader.read(buffer)) != -1) {
                    stringWriter.write(buffer, 0, n);
                }
                bReader.close();
                stringWriter.close();
                fReader.close();
            }catch(IOException ioe){
                System.err.println(ioe.toString());
            }
        }
            return stringWriter.toString();
    }
    
    public static void testSR(File f){
        if(f.isFile() && f.canRead() && f.canWrite()){

            try {
                StringReader sr=new StringReader(testSW(f));
                int i;
                while((i=sr.read())!=-1){
                    System.out.print((char)i);
                }
                sr.close();
            }catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
