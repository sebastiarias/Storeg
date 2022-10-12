package com.example.storeg;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import exportkit.figma.R;
import exportkit.figma.home_activity;
import exportkit.figma.login_activity;

public class MainActivity  extends AppCompatActivity {

    EditText usuario,contraseña,confirmar_contraseña;
    Button registro,tienes_cuenta;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        usuario = findViewById(R.id.usuario1);
        contraseña = findViewById(R.id.contraseña1);
        registro = findViewById(R.id.registro);
        tienes_cuenta = findViewById(R.id.tienes_cuenta);
        DB = new DBHelper(this);


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = contraseña.getText().toString();
                String repass = confirmar_contraseña.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(MainActivity.this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), home_activity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "Registro Fallido", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "El Usuario ya Existe", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "La Contraseña no Coincide", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        tienes_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login_activity.class);
                startActivity(intent);
            }
        });
    }
}
