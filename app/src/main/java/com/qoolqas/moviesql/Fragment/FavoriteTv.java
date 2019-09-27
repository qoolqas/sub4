package com.qoolqas.moviesql.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.qoolqas.moviesql.Adapter.TvAdapter;
import com.qoolqas.moviesql.Data.TvShow;
import com.qoolqas.moviesql.R;
import com.qoolqas.moviesql.VM.TvModel;

public class FavoriteTv extends Fragment {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TvAdapter tvAdapter;
    private TvModel tvModel;

    public FavoriteTv(){}


    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_favorite_tv,container,false);
        return v;
    }


}
