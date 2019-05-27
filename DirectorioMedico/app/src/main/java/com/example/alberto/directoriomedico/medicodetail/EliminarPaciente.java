package com.example.alberto.directoriomedico.medicodetail;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alberto.directoriomedico.R;

public class EliminarPaciente extends AppCompatActivity {
    private EditText et_codigo, et_nombre, et_peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_paciente);
        et_codigo = (EditText) findViewById(R.id.Txt_Codigo);
        et_nombre = (EditText) findViewById(R.id.Txt_Nombre);
        et_peso = (EditText) findViewById(R.id.Txt_peso);
        et_nombre.setEnabled(false);
        et_peso.setEnabled(false);
    }

    public void Eliminar(View view){

        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        if(!codigo.isEmpty()){
            int cantidad = BaseDatabase.delete("pacientes", "codigo="+codigo, null);
            BaseDatabase.close();
            et_codigo.setText("");
            et_nombre.setText("");
            et_peso.setText("");
            if(cantidad == 1){
                Toast.makeText(this, "Paciente eliminado exitosamente", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "El paciente no Existe", Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(this, "Debes Introducir el codigo del paciente", Toast.LENGTH_SHORT).show();

        }
    }
}
