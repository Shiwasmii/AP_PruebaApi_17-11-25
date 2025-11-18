package com.example.ap_pruebaapi_17_11_25;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class api_form extends AppCompatActivity {

    // Variables de la interfaz
    private EditText txtIdProducto, txtProducto, txtDescripcion,
            txtPrecio, txtUnidadMedida, txtCategoria;

    private Button btnAgregar;
    private ListView listViewData;

    private List<Producto> listaProductos;
    private ProductoAdapter adapter;

    // URL DE TU API
    private static final String URL_API = "http://demoapi.somee.com/api/productos";
    private RequestQueue requestQueue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_form);

        // Inicialización de vistas
        txtIdProducto = findViewById(R.id.txt_id_producto);
        txtProducto = findViewById(R.id.txt_producto);
        txtDescripcion = findViewById(R.id.txt_descripcion);
        txtPrecio = findViewById(R.id.txt_precio);
        txtUnidadMedida = findViewById(R.id.txt_unidad_medida);
        txtCategoria = findViewById(R.id.txt_categoria);

        btnAgregar = findViewById(R.id.btnAgregar);
        listViewData = findViewById(R.id.listViewData);

        // Inicialización de Volley y Lista
        requestQueue = Volley.newRequestQueue(this);
        listaProductos = new ArrayList<>();
        adapter = new ProductoAdapter(this, listaProductos);
        listViewData.setAdapter(adapter);

        // Cargar datos al iniciar
        listarProductos();

        btnAgregar.setOnClickListener(v -> agregarProducto());
    }

    // --- MÉTODO GET (Listar) ---
    private void listarProductos() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL_API,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listaProductos.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject obj = response.getJSONObject(i);
                                Producto p = new Producto();

                                p.setIdProducto(obj.optInt("idProducto"));
                                p.setIdEmpresa(obj.optInt("idEmpresa"));
                                p.setProducto1(obj.optString("producto1"));
                                p.setDescripcion(obj.optString("descripcion"));
                                p.setPrecio(obj.optDouble("precio"));
                                p.setUnidadMedida(obj.optString("unidadMedida"));
                                p.setCategoria(obj.optString("categoria"));

                                listaProductos.add(p);
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(api_form.this, "Error al cargar: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    // --- MÉTODO POST (Agregar) ---
    private void agregarProducto() {
        // Validamos que haya nombre y precio (NO ID)
        if (txtProducto.getText().toString().isEmpty() ||
                txtPrecio.getText().toString().isEmpty()) {
            Toast.makeText(this, "Completa Nombre y Precio", Toast.LENGTH_SHORT).show();
            return;
        }

        JSONObject jsonBody = new JSONObject();
        try {
            // REQUERIMIENTO: idEmpresa siempre es 1
            jsonBody.put("idEmpresa", 1);

            // REQUERIMIENTO: NO enviamos idProducto (es autoincremental)

            jsonBody.put("producto1", txtProducto.getText().toString());
            jsonBody.put("descripcion", txtDescripcion.getText().toString());
            jsonBody.put("precio", Double.parseDouble(txtPrecio.getText().toString()));
            jsonBody.put("unidadMedida", txtUnidadMedida.getText().toString());
            jsonBody.put("categoria", txtCategoria.getText().toString());

        } catch (JSONException | NumberFormatException e) {
            Toast.makeText(this, "Error en datos numéricos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Petición POST
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                URL_API,
                jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(api_form.this, "Agregado con éxito", Toast.LENGTH_SHORT).show();
                        limpiarCampos();
                        listarProductos(); // Refrescar lista
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(api_form.this, "Error API: " + error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        requestQueue.add(request);
    }

    private void limpiarCampos() {
        txtIdProducto.setText(""); // Limpiamos visualmente aunque no lo usemos
        txtProducto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtUnidadMedida.setText("");
        txtCategoria.setText("");
        txtProducto.requestFocus(); // Foco en el nombre del producto
    }
}