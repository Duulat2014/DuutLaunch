package git.artdeell.mojo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import git.artdeell.mojo.R;

public class SkinFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skin, container, false);

        EditText editUsername = view.findViewById(R.id.edit_skin_username);
        Button btnLoadSkin = view.findViewById(R.id.btn_load_skin);
        Button btnPickFile = view.findViewById(R.id.btn_pick_file);

        btnLoadSkin.setOnClickListener(v -> {
            String username = editUsername.getText().toString();
            Toast.makeText(getContext(), "Загрузка скина для: " + username, Toast.LENGTH_SHORT).show();
        });

        btnPickFile.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Открытие выбора файла скина...", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
