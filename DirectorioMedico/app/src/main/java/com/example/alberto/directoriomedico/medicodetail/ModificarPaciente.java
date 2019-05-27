package com.example.alberto.directoriomedico.medicodetail;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alberto.directoriomedico.R;

public class ModificarPaciente extends AppCompatActivity {
    private EditText et_codigo, et_nombre, et_peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_paciente);
        et_codigo = (EditText) findViewById(R.id.Txt_Codigo);
        et_nombre = (EditText) findViewById(R.id.Txt_Nombre);
        et_peso = (EditText) findViewById(R.id.Txt_peso);
    }

    public void Modificar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();


        String codigo = et_codigo.getText().toString();
        String nombre = et_nombre.getText().toString();
        String peso= et_peso.getText().toString();

        if(!codigo.isEmpty()&& !nombre.isEmpty() && !peso.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("peso",peso);

            int cantidad = BaseDatabase.update("pacientes", registro, "codigo="+codigo, null);
            BaseDatabase.close();
            if(cantidad==1){
                Toast.makeText(this, "Paciente Modificado Correctamente", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "Paciente no Existe", Toast.LENGTH_SHORT).show();

            }


        }else{
            Toast.makeText(this, "Debes llenar todos los datos", Toast.LENGTH_SHORT).show();

        }
    }
}
