/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 *
 * @author AlienWare
 */
public class DirectoryBasic {
    public static void main(String[] args) throws IOException {

        //----------------------------------------------------------------
        //Atributos basicos de archivos.
        Path file = Paths.get("C:\\Users\\AlienWare\\Pictures\\kali.png");

        try {
            System.out.println("Atributos basicos de archivos");
            BasicFileAttributes attr;
            attr = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("creationTime: " + attr.creationTime());
            System.out.println("lastAccessTime: " + attr.lastAccessTime());
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

            System.out.println("isDirectory: " + attr.isDirectory());
            System.out.println("isOther: " + attr.isOther());
            System.out.println("isRegularFile: " + attr.isRegularFile());
            System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
            System.out.println("size: " + attr.size());
            //metodo fileKey devuelve un objeto que identifica de forma
            //exclusiva el archivo o null si no hay clave de archivps disponibles
            System.out.println("fileKey: " + attr.fileKey());

            //-------------------------------------
            //Establecer sello de tiempo
            //esta opcion estalbece la ultima hora en milisegundos
            System.out.println("");
            System.out.println("Establecer sello de tiempo/Hora del atributo en milisegundos");
            long currentTime = System.currentTimeMillis();
            FileTime ft = FileTime.fromMillis(currentTime);
            Files.setLastModifiedTime(file, ft);
            System.out.println("File Milisegundos: " + ft);
        } catch (IOException e) {
            System.err.println("Errir en la lectura de atributo" + e.getMessage());
        }
    }
}
