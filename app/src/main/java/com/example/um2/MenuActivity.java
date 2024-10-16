package com.example.um2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class MenuActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu, container, false);

        Button testVocacionalButton = view.findViewById(R.id.Test);
        testVocacionalButton.setOnClickListener(v -> {
            Fragment fragment = new TestVocacionalActivity();
            loadFragment(fragment);
        });

        Button cursosButton = view.findViewById(R.id.Cursos);
        cursosButton.setOnClickListener(v -> {
            Fragment fragment = new CursosActivity();
            loadFragment(fragment);
        });

        Button universidadesButton = view.findViewById(R.id.Universidades);
        universidadesButton.setOnClickListener(v -> {
            Fragment fragment = new UniversidadesActivity();
            loadFragment(fragment);
        });

        Button carrerasButton = view.findViewById(R.id.Carreras);
        carrerasButton.setOnClickListener(v -> {
            Fragment fragment = new CarrerasActivity();
            loadFragment(fragment);
        });

        Button donacionesButton = view.findViewById(R.id.Donaciones);
        donacionesButton.setOnClickListener(v -> {
            Fragment fragment = new DonacionesActivity();
            loadFragment(fragment);
        });

        return view;
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

