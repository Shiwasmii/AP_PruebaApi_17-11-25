package com.example.ap_pruebaapi_17_11_25;

public class Producto {
    private String idEmpresa;
    private String producto;
    private String descripcion;
    private double precio;
    private int stock;
    private String unidadMedida;
    private String fechaVencimiento;
    private String estado;
    private String categoria;
    private String idCategoria;

    public Producto(String idEmpresa, String producto, String descripcion, double precio, int stock,
                    String unidadMedida, String fechaVencimiento, String estado,
                    String categoria, String idCategoria) {
        this.idEmpresa = idEmpresa;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.categoria = categoria;
        this.idCategoria = idCategoria;
    }

    // Getters
    public String getIdEmpresa() { return idEmpresa; }
    public String getProducto() { return producto; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getUnidadMedida() { return unidadMedida; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public String getEstado() { return estado; }
    public String getCategoria() { return categoria; }
    public String getIdCategoria() { return idCategoria; }
}
