package com.duulat.duutlaunch.fragments; // Укажи свой пакет проекта

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.duulat.duutlaunch.R; // Проверь путь к ресурсам

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnPlay = view.findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(v -> {
            // Здесь будет логика запуска игры (проверка Java и старт движка Mojo)
            Toast.makeText(getContext(), "Запуск Minecraft...", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
