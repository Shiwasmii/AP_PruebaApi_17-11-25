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

        if (producto != null) {

            TextView txtIdProducto = convertView.findViewById(R.id.txtIdProducto);
            TextView txtIdEmpresa = convertView.findViewById(R.id.txtIdEmpresa);
            TextView txtProducto = convertView.findViewById(R.id.txtProducto);
            TextView txtDescripcion = convertView.findViewById(R.id.txtDescripcion);
            TextView txtPrecio = convertView.findViewById(R.id.txtPrecio);
            TextView txtUnidadMedida = convertView.findViewById(R.id.txtUnidadMedida);
            TextView txtCategoria = convertView.findViewById(R.id.txtCategoria);

            txtIdProducto.setText("ID: " + producto.getIdProducto());
            txtIdEmpresa.setText("Empresa ID: " + producto.getIdEmpresa());

            txtProducto.setText(producto.getProducto1());

            txtDescripcion.setText(producto.getDescripcion());
            txtPrecio.setText("Precio: " + producto.getPrecio());
            txtUnidadMedida.setText("Unidad: " + producto.getUnidadMedida());
            txtCategoria.setText("Categoría: " + producto.getCategoria());
        }

        return convertView;
    }
}