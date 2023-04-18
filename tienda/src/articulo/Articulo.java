package articulo;
public class Articulo {
    private String clave;
    private String descripcion;
    private double precio;
    private int existencia;
    private int disponible;

    public Articulo(String clave, String descripcion, double precio, int existencia, int disponible) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.disponible = disponible;
    }
    

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getExistencia() { return existencia; }
    public void setExistencia(int existencia) { this.existencia = existencia; }
    
    public int getDisponible() { return disponible; }
    public void setDisponible (int disponible) { this.disponible = disponible; }


    @Override
    public String toString() {
    return "Articulo{\n" +
            "  clave='" + clave + "',\n" +
            "  descripcion='" + descripcion + "',\n" +
            "  precio=" + precio + ",\n" +
            "  existencia=" + existencia + "\n" +
            "  disponible=" + (disponible == 1 ? "Si" : "No") + "\n" +
            '}';
}
}