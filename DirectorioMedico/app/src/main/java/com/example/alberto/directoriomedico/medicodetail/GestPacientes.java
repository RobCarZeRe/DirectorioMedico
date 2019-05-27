package com.example.alberto.directoriomedico.medicodetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alberto.directoriomedico.R;

public class GestPacientes extends AppCompatActivity {
    String docod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gest_pacientes);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some")!= null){
                //Toast.makeText(getApplicationContext(), "data:" + bundle.getString("some"),Toast.LENGTH_SHORT).show();
                docod = bundle.getString("some");
            }
        }

    }

    public void AcAgregar(View view){
        Intent miIntent=new Intent(GestPacientes.this,AgregarPaciente.class);
        miIntent.putExtra("some", docod);
        startActivity(miIntent);
    }
    public void AcBuscar(View view){
        Intent miIntent=new Intent(GestPacientes.this,BuscarPaciente.class);
        startActivity(miIntent);
    }

    public void Aclistar(View view){
        Intent miIntent=new Intent(GestPacientes.this,ListarPaciente.class);
        miIntent.putExtra("some", docod);
        startActivity(miIntent);
    }

    public void Aceliminar(View view){
        Intent miIntent=new Intent(GestPacientes.this,EliminarPaciente.class);

        startActivity(miIntent);
    }
    public void AcMod(View view){
        Intent miIntent=new Intent(GestPacientes.this,ModificarPaciente.class);
        startActivity(miIntent);
    }
}
