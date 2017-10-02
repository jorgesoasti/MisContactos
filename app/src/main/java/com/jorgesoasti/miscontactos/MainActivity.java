package com.jorgesoasti.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jorgesoasti.miscontactos.adapter.ContactoAdaptador;
import com.jorgesoasti.miscontactos.adapter.PageAdapter;
import com.jorgesoasti.miscontactos.fragment.PerfilFragment;
import com.jorgesoasti.miscontactos.fragment.RecyclerViewFragment;
import com.jorgesoasti.miscontactos.poyo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tlbToolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.vpViewPager);

        setUpViewPager();

        /*
        Toolbar miActionBar = findViewById(R.id.tlbMiActionBar);
        setSupportActionBar(miActionBar);
        */

        /* Recycler View

        */

        /*
        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        */

        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstListaContactos);
        lstContactos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pNombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.pTelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEmail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });
        */

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_contact_detail);
    }

}
