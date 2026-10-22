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
    private Button btnAddVersion;
    private final List<String> versionDisplayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_versions, container, false);
        listViewVersions = view.findViewById(R.id.list_versions);
        btnAddVersion = view.findViewById(R.id.btn_add_version);

        loadAllMinecraftVersions();

        if (btnAddVersion != null) {
            btnAddVersion.setOnClickListener(v -> {
                // Действие при нажатии на кнопку установки версии
            });
        }

        return view;
    }

    private void loadAllMinecraftVersions() {
        versionDisplayList.clear();

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

        new Thread(() -> {
            try {
                URL url = new URL("https://launchermeta.mojang.com/mc/game/version_manifest_json.json");
                InputStreamReader reader = new InputStreamReader(url.openStream());
                StringBuilder builder = new StringBuilder();
                int data = reader.read();
                while (data != -1) {
                    builder.append((char) data);
                    data = reader.read();
                }
                reader.close();

                JSONObject jsonRoot = new JSONObject(builder.toString());
                JSONArray versionsArray = jsonRoot.getJSONArray("versions");

                for (int i = 0; i < versionsArray.length(); i++) {
                    JSONObject verObj = versionsArray.getJSONObject(i);
                    String id = verObj.getString("id");
                    String type = verObj.getString("type");

                    String label = id + " (" + type + ")";
                    if (!versionDisplayList.toString().contains(id)) {
                        versionDisplayList.add(label);
                    }
                }

                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                requireContext(),
                                android.R.layout.simple_list_item_1,
                                versionDisplayList
                        );
                        listViewVersions.setAdapter(adapter);
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
