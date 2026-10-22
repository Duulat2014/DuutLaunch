package git.artdeell.mojo.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import git.artdeell.mojo.R;
// Импортируем родные экраны настроек Mojo, если они есть в проекте:
// Например: git.artdeell.mojo.CustomControlsActivity и т.д.

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Spinner spinnerTheme = view.findViewById(R.id.spinner_theme);
        Button btnGraphics = view.findViewById(R.id.btn_graphics_settings);
        Button btnControls = view.findViewById(R.id.btn_controls_settings);
        Button btnJava = view.findViewById(R.id.btn_java_settings);
        Button btnOther = view.findViewById(R.id.btn_other_settings);

        // Настройка тем
        String[] themes = {"Системная", "Светлая", "Темная"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, themes);
        spinnerTheme.setAdapter(adapter);

        SharedPreferences prefs = requireContext().getSharedPreferences("launcher_prefs", Context.MODE_PRIVATE);
        int currentMode = prefs.getInt("selected_theme", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        spinnerTheme.setSelection(currentMode == AppCompatDelegate.MODE_NIGHT_NO ? 1 : (currentMode == AppCompatDelegate.MODE_NIGHT_YES ? 2 : 0));

        spinnerTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int mode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
                if (position == 1) mode = AppCompatDelegate.MODE_NIGHT_NO;
                else if (position == 2) mode = AppCompatDelegate.MODE_NIGHT_YES;

                AppCompatDelegate.setDefaultNightMode(mode);
                prefs.edit().putInt("selected_theme", mode).apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        package git.artdeell.mojo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import git.artdeell.mojo.R;
import git.artdeell.mojo.Tools;

public class VersionsFragment extends Fragment {

    private ListView listViewVersions;
    private Button btnInstallVersion;
    private final List<String> versionDisplayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_versions, container, false);
        listViewVersions = view.findViewById(R.id.list_versions);
        btnInstallVersion = view.findViewById(R.id.btn_install_version);

        loadAllMinecraftVersions();

        if (btnInstallVersion != null) {
            btnInstallVersion.setOnClickListener(v -> {
                // Действие по установке выбранной версии
            });
        }

        return view;
    }

    private void loadAllMinecraftVersions() {
        versionDisplayList.clear();

        // 1. Сначала добавляем уже установленные локально версии
        try {
            File versionsDir = new File(Tools.DIR_GAME, "versions");
            if (versionsDir.exists() && versionsDir.isDirectory()) {
                File[] files = versionsDir.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isDirectory()) {
                            versionDisplayList.add("[Установлена] " + f.getName());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                // Подключаем переходы к родным системным экранам настроек Mojo
        btnGraphics.setOnClickListener(v -> {
            try {
                // Вызываем родную активность настроек графики Mojo
                requireContext().startActivity(new android.content.Intent(requireContext(), git.artdeell.mojo.GraphicsActivity.class));
            } catch (Exception e) {
                // Если имя класса отличается, используем универсальный вызов инфлейта настроек
                android.widget.Toast.makeText(getContext(), "Настройки графики", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        btnControls.setOnClickListener(v -> {
            try {
                requireContext().startActivity(new android.content.Intent(requireContext(), git.artdeell.mojo.ControlSettingsActivity.class));
            } catch (Exception e) {}
        });

        btnJava.setOnClickListener(v -> {
            try {
                requireContext().startActivity(new android.content.Intent(requireContext(), git.artdeell.mojo.JavaPreferencesActivity.class));
            } catch (Exception e) {}
        });

        btnOther.setOnClickListener(v -> {
            try {
                requireContext().startActivity(new android.content.Intent(requireContext(), git.artdeell.mojo.GlobalPreferencesActivity.class));
            } catch (Exception e) {}
        });
        
        return view;
    }
}
