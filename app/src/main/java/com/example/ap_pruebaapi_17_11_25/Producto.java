package com.example.ap_pruebaapi_17_11_25;

public class Producto {
    public int idProducto;
    public int idEmpresa;
    public String producto1;
    public String descripcion;
    public double precio;
    public String unidadMedida;
    public String categoria;

    public Producto() {}


    public Producto(int idProducto, int idEmpresa, String producto1, String descripcion, double precio, String unidadMedida, String categoria) {
        this.idProducto = idProducto;
        this.idEmpresa = idEmpresa;
        this.producto1 = producto1;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
        this.categoria = categoria;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }

    public String getProducto1() { return producto1; }
    public void setProducto1(String producto1) { this.producto1 = producto1; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}