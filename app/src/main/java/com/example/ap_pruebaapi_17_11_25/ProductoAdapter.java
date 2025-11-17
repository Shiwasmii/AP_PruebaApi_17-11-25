package com.example.ap_pruebaapi_17_11_25;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {

    public ProductoAdapter(Context context, List<Producto> productos) {
        super(context, 0, productos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto producto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_producto, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.txtIdEmpresa)).setText("ID Empresa: " + producto.getIdEmpresa());
        ((TextView) convertView.findViewById(R.id.txtProducto)).setText("Producto: " + producto.getProducto());
        ((TextView) convertView.findViewById(R.id.txtDescripcion)).setText("Descripción: " + producto.getDescripcion());
        ((TextView) convertView.findViewById(R.id.txtPrecio)).setText("Precio: " + producto.getPrecio());
        ((TextView) convertView.findViewById(R.id.txtStock)).setText("Cantidad Stock: " + producto.getStock());
        ((TextView) convertView.findViewById(R.id.txtUnidadMedida)).setText("Unidad de Medida: " + producto.getUnidadMedida());
        ((TextView) convertView.findViewById(R.id.txtFechaVencimiento)).setText("Fecha de Vencimiento: " + producto.getFechaVencimiento());
        ((TextView) convertView.findViewById(R.id.txtEstado)).setText("Estado: " + producto.getEstado());
        ((TextView) convertView.findViewById(R.id.txtCategoria)).setText("Categoría: " + producto.getCategoria());
        ((TextView) convertView.findViewById(R.id.txtIdCategoria)).setText("ID Categoría: " + producto.getIdCategoria());

        return convertView;
    }
}
