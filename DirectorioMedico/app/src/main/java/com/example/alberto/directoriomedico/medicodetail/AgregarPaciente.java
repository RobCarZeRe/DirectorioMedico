package com.example.alberto.directoriomedico.medicodetail;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alberto.directoriomedico.MainActivity;
import com.example.alberto.directoriomedico.R;

import java.util.ArrayList;

public class AgregarPaciente extends AppCompatActivity {

    private EditText et_codigo, et_nombre, et_peso;
    String codoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_paciente);

        et_codigo = (EditText) findViewById(R.id.Txt_Codigo);
        et_nombre = (EditText) findViewById(R.id.Txt_Nombre);
        et_peso = (EditText) findViewById(R.id.Txt_peso);




    }

    public void Registrar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(AgregarPaciente.this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String nombre = et_nombre.getText().toString();
        String peso= et_peso.getText().toString();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some")!= null){
                //Toast.makeText(getApplicationContext(), "data:" + bundle.getString("some"),Toast.LENGTH_SHORT).show();
                codoc = bundle.getString("some");
            }
        }


        if(!codigo.isEmpty() && !nombre.isEmpty() && !peso.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("peso",peso);
            registro.put("codoc",codoc);

            BaseDeDatos.insert("pacientes", null, registro);
            BaseDeDatos.close();
            et_codigo.setText("");
            et_nombre.setText("");
            et_peso.setText("");

            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Debes Llenar todos los campos", Toast.LENGTH_SHORT).show();

        }
    }

}
