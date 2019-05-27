package com.example.alberto.directoriomedico.medicodetail;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alberto.directoriomedico.R;

public class BuscarPaciente extends AppCompatActivity {
    private EditText et_codigo, et_nombre, et_peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_paciente);
        et_codigo = (EditText) findViewById(R.id.Txt_Codigo);
        et_nombre = (EditText) findViewById(R.id.Txt_Nombre);
        et_peso = (EditText) findViewById(R.id.Txt_peso);

        et_nombre.setEnabled(false);
        et_peso.setEnabled(false);

    }

    public void buscar(View view){

        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery(
                    "select nombre, peso from pacientes where codigo ="+codigo, null);
            if(fila.moveToFirst()){
                et_nombre.setText(fila.getString(0));
                et_peso.setText(fila.getString(1));
                BaseDeDatabase.close();

            }else{
                Toast.makeText(this, "No Existe el paciente", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }
        }else{
            Toast.makeText(this, "Debes Introducir el codigo del paciente", Toast.LENGTH_SHORT).show();

        }

    }
}
