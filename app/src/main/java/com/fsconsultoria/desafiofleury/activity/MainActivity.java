package com.fsconsultoria.desafiofleury.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.fsconsultoria.desafiofleury.R;
import com.fsconsultoria.desafiofleury.adapter.AdapterExames;
import com.fsconsultoria.desafiofleury.model.ListExames;
import com.fsconsultoria.desafiofleury.model.PojoExame;
import com.fsconsultoria.desafiofleury.service.Client;
import com.fsconsultoria.desafiofleury.service.GetApi;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AdapterExames adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerExames);

        //adapter = new AdapterExames(listExamesR, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);





       GetApi service = Client.getClient().create(GetApi.class);

        Call<ListExames> call = service.getAllResults();
        call.enqueue(new Callback<ListExames>() {
            @Override
            public void onResponse(Call<ListExames> call, Response<ListExames> response) {
                generateListExames(response.body().getExames());
            }

            @Override
            public void onFailure(Call<ListExames> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ocorreu um erro, tente mais tarde!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateListExames(ArrayList<PojoExame> listExamesR) {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerExames);

        adapter = new AdapterExames(listExamesR, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

}
