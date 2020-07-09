package com.niccode.pets.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.niccode.pets.MainActivity;
import com.niccode.pets.R;
import com.niccode.pets.javamail.JavaMail;

public class contacto extends AppCompatActivity {

    EditText nombre;
    EditText email;
    EditText mensaje;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(contacto.this, MainActivity.class);
               startActivity(i);
            }
        });

        nombre     = (EditText) findViewById(R.id.nombreCon);
        email      = (EditText) findViewById(R.id.email);
        mensaje    = (EditText) findViewById(R.id.mensaje);
        enviar     = (Button)   findViewById(R.id.send);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }

    private void sendMail() {
        String subject  = nombre.getText().toString();
        String mail     = email.getText().toString();
        String body     = mensaje.getText().toString();

        JavaMail sendmail = new JavaMail(this, mail, subject , body);
        sendmail.execute();

    }

}