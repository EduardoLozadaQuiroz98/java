package articulo;

import java.io.*;
import java.util.ArrayList;

public class CRUD {
    private static final String FILE_NAME = "articulo.txt";

    public static void crearArticulo(Articulo articulo) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(articulo.getClave());
            out.println(articulo.getDescripcion());
            out.println(articulo.getPrecio());
            out.println(articulo.getExistencia());
            out.println(articulo.getDisponible());
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static Articulo leerArticulo(String clave) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(clave)) {
                    String descripcion = br.readLine();
                    double precio = Double.parseDouble(br.readLine());
                    int existencia = Integer.parseInt(br.readLine());
                    int disponible = Integer.parseInt(br.readLine());
                    return new Articulo(clave, descripcion, precio, existencia, disponible);
                } else {
                    br.readLine(); 
                    br.readLine(); 
                    br.readLine();
                    br.readLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

    public static void actualizarArticulo(Articulo articulo) {
        ArrayList<Articulo> articulos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String clave = line;
                String descripcion = br.readLine();
                double precio = Double.parseDouble(br.readLine());
                int existencia = Integer.parseInt(br.readLine());
                int disponible = Integer.parseInt(br.readLine());
                if (clave.equals(articulo.getClave())) {
                    articulos.add(articulo);
                } else {
                    articulos.add(new Articulo(clave, descripcion, precio, existencia, disponible));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        try (FileWriter fw = new FileWriter(FILE_NAME);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Articulo a : articulos) {
                out.println(a.getClave());
                out.println(a.getDescripcion());
                out.println(a.getPrecio());
                out.println(a.getExistencia());
                out.println(a.getDisponible());
            }
        } catch (IOException e) {
            System.err.println("Error al escribír el archivo: " + e.getMessage());
        }
    }

    public static void borrarArticulo(String clave) {
        Articulo articulo = leerArticulo (clave);
        if (articulo !=null){
            articulo.setDisponible(0);
            actualizarArticulo(articulo);
        }
    }

    public static ArrayList<Articulo> leerTodosLosArticulos() {
        ArrayList<Articulo> articulos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String clave = line;
                String descripcion = br.readLine();
                double precio = Double.parseDouble(br.readLine());
                int existencia = Integer.parseInt(br.readLine());
                int disponible = Integer.parseInt(br.readLine());
                articulos.add(new Articulo(clave, descripcion, precio, existencia, disponible));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return articulos;
    }
    
    
    
    public static ArrayList<Articulo> leerArticulosDisponibles() {
        ArrayList<Articulo> articulosDisponibles = new ArrayList<>();
        for (Articulo articulo : leerTodosLosArticulos()) {
            if (articulo.getDisponible() == 1) {
                articulosDisponibles.add(articulo);
            }
        }
        return articulosDisponibles;
    }

    public static ArrayList<Articulo> leerArticulosNoDisponibles() {
            ArrayList<Articulo> articulosNoDisponibles = new ArrayList<>();
            for (Articulo articulo : leerTodosLosArticulos()) {
                if (articulo.getDisponible() == 0) {
                    articulosNoDisponibles.add(articulo);
                }
            }
        return articulosNoDisponibles;
    }
    }
