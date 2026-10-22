package git.artdeell.mojo.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import git.artdeell.mojo.R;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Spinner spinnerTheme = view.findViewById(R.id.spinner_theme);

        // Варианты тем
        String[] themes = {"Системная", "Светлая", "Темная"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, themes);
        spinnerTheme.setAdapter(adapter);

        // Устанавливаем текущий выбор
        SharedPreferences prefs = requireContext().getSharedPreferences("launcher_prefs", Context.MODE_PRIVATE);
        int currentMode = prefs.getInt("selected_theme", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        if (currentMode == AppCompatDelegate.MODE_NIGHT_NO) {
            spinnerTheme.setSelection(1);
        } else if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            spinnerTheme.setSelection(2);
        } else {
            spinnerTheme.setSelection(0);
        }

        // Обработка выбора темы
        spinnerTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int mode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
                if (position == 1) {
                    mode = AppCompatDelegate.MODE_NIGHT_NO;
                } else if (position == 2) {
                    mode = AppCompatDelegate.MODE_NIGHT_YES;
                }

                AppCompatDelegate.setDefaultNightMode(mode);
                prefs.edit().putInt("selected_theme", mode).apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        return view;
    }
}
