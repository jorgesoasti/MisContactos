package com.jorgesoasti.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pNombre));
        String telefono = parametros.getString(getResources().getString(R.string.pTelefono));
        String email = parametros.getString(getResources().getString(R.string.pEmail));

        tvNombre = findViewById(R.id.tvNombrePersona);
        tvTelefono = findViewById(R.id.tvTelefonoPersona);
        tvEmail = findViewById(R.id.tvEmailPersona);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);

        //Transisiones
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //Slide slide = new Slide(); de abajo hacia arriba
            Slide slide = new Slide(Gravity.RIGHT); //desde la derecha
            slide.setDuration(1000);
            getWindow().setEnterTransition(slide); //cuando entra la actividad
            //cuando esta terminando la transicion
            slide.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    Toast.makeText(DetalleContacto.this, "Empezando", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    Toast.makeText(DetalleContacto.this, "Terminado", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });

            getWindow().setReenterTransition(new Fade()); //cuando regresa a la actividad anterior

        }else{

        }
    }

    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();
        Intent llamadaIntent = new Intent(Intent.ACTION_CALL);
        llamadaIntent.setData(Uri.parse("tel:" + telefono));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(llamadaIntent);
    }

    public void enviarEmail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }

}
