package eccgo.jonathansilvaviana.com.br.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SemNetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_net);
    }


    Button bt_index = (Button)findViewById(R.id.button);


    public void getBt_index() {
        bt_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemNetActivity.this, MainActivity.class));
            }
        });
    }


}
