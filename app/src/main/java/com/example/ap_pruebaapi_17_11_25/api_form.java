package com.example.ap_pruebaapi_17_11_25;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class api_form extends AppCompatActivity {

    private EditText txtIdEmpresa, txtProducto, txtDescripcion, txtPrecio, txtStock,
            txtUnidadMedida, txtFechaVencimiento, txtEstado, txtCategoria, txtIdCategoria;
    private Button btnAgregar;
    private ListView listViewData;

    private List<Producto> listaProductos;
    private ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_form);

        txtIdEmpresa = findViewById(R.id.txt_id_empresa);
        txtProducto = findViewById(R.id.txt_producto);
        txtDescripcion = findViewById(R.id.txt_descripcion);
        txtPrecio = findViewById(R.id.txt_precio);
        txtStock = findViewById(R.id.txt_stock);
        txtUnidadMedida = findViewById(R.id.txt_unidad_medida);
        txtFechaVencimiento = findViewById(R.id.txt_fecha_vencimiento);
        txtEstado = findViewById(R.id.txt_estado);
        txtCategoria = findViewById(R.id.txt_categoria);
        txtIdCategoria = findViewById(R.id.txt_id_categoria);

        btnAgregar = findViewById(R.id.btnAgregar);
        listViewData = findViewById(R.id.listViewData);

        listaProductos = new ArrayList<>();
        adapter = new ProductoAdapter(this, listaProductos);
        listViewData.setAdapter(adapter);

        btnAgregar.setOnClickListener(v -> agregarProducto());
    }

    private void agregarProducto() {
        Producto p = new Producto(
                txtIdEmpresa.getText().toString(),
                txtProducto.getText().toString(),
                txtDescripcion.getText().toString(),
                Double.parseDouble(txtPrecio.getText().toString()),
                Integer.parseInt(txtStock.getText().toString()),
                txtUnidadMedida.getText().toString(),
                txtFechaVencimiento.getText().toString(),
                txtEstado.getText().toString(),
                txtCategoria.getText().toString(),
                txtIdCategoria.getText().toString()
        );

        listaProductos.add(p);
        adapter.notifyDataSetChanged();

        txtIdEmpresa.setText("");
        txtProducto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtUnidadMedida.setText("");
        txtFechaVencimiento.setText("");
        txtEstado.setText("");
        txtCategoria.setText("");
        txtIdCategoria.setText("");
    }
}
