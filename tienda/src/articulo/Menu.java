package articulo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Crear artículo");
            System.out.println("2. Leer artículo");
            System.out.println("3. Actualizar artículo");
            System.out.println("4. Borrar artículo");
            System.out.println("5. Leer todos los artículos");
            System.out.println("6. Mostrar artículos disponibles");
            System.out.println("7. Mostrar artículos NO disponibles");
            System.out.println("8. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            
            switch (opcion) {
                case 1: {
                    System.out.print("Ingrese la clave: ");
                    String clave = scanner.nextLine();

                    if (CRUD.leerArticulo(clave) == null) {
                        System.out.print("Ingrese la descripción: ");
                        String descripcion = scanner.nextLine();
                        System.out.print("Ingrese el precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Ingrese la existencia: ");
                        int existencia = scanner.nextInt();
                        System.out.print("¿El articulo esta disbonible? 1=Disponible, 0=No disponible: ");
                        int disponible = scanner.nextInt();
                        scanner.nextLine();

                        Articulo articulo = new Articulo(clave, descripcion, precio, existencia, disponible);
                        CRUD.crearArticulo(articulo);
                        System.out.println("Artículo creado con éxito.\n");
                    } else {
                        System.out.println("Ya existe un artículo con esa clave. Intente nuevamente.\n");
                    }
                    break;
                }
                 // Caso para leer un artículo
                case 2: {
                    System.out.print("Ingrese la clave del artículo a leer: ");
                    String clave = scanner.nextLine();
                    Articulo articulo = CRUD.leerArticulo(clave);
                    if (articulo != null) {
                        System.out.println(articulo);
                    } else {
                        System.out.println("Artículo no encontrado.\n");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Ingrese la clave del artículo a actualizar: ");
                    String clave = scanner.nextLine();
                    Articulo articulo = CRUD.leerArticulo(clave);
                    if (articulo != null) {
                        System.out.print("Ingrese la nueva descripción: ");
                        String descripcion = scanner.nextLine();
                        System.out.print("Ingrese el nuevo precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Ingrese la nueva existencia: ");
                        int existencia = scanner.nextInt();
                        System.out.print("¿El articulo esta disbonible? 1=Disponible, 0=No disponible: ");
                        int disponible = scanner.nextInt();
                        scanner.nextLine();

                        articulo.setDescripcion(descripcion);
                        articulo.setPrecio(precio);
                        articulo.setExistencia(existencia);
                        articulo.setDisponible(disponible);
                        CRUD.actualizarArticulo(articulo);
                        System.out.println("Artículo actualizado con éxito.\n");
                    } else {
                        System.out.println("Artículo no encontrado.\n");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Ingrese la clave del artículo a borrar: ");
                    String clave = scanner.nextLine();
                    CRUD.borrarArticulo(clave);
                    System.out.println("Artículo borrado con éxito.\n");
                    break;
                }
                // Caso para leer todos los artículos
                case 5: {
                    ArrayList<Articulo> articulos = CRUD.leerTodosLosArticulos();
                    for (Articulo articulo : articulos) {
                        System.out.println(articulo);
                    }
                    break;
                }
                // caso para salir del programa
                case 6: {
                    ArrayList<Articulo> articulosDisponibles = CRUD.leerArticulosDisponibles();
                    for (Articulo articulo : articulosDisponibles) {
                        System.out.println(articulo);
                    }
                    break;
                }
                
                case 7: {
                    ArrayList<Articulo> articulosNoDisponibles = CRUD.leerArticulosNoDisponibles();
                    for (Articulo articulo : articulosNoDisponibles) {
                        System.out.println(articulo);
                    }
                    break;
                }

                case 8: {
                    System.out.println("Saliendo del programa...");
                    break;
                }
                default: {
                    System.out.println("Opción no válida.\n");
                }
            }
        } while (opcion != 8);

        scanner.close();
    }
}