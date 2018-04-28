package applabs.myclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText address;
    EditText port;
    Button btn;
    TextView resp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClientSocket socRunner=new ClientSocket(address.getText().toString(),Integer.valueOf(port.getText().toString()),resp);
                socRunner.execute();
            }
        });
    }

    public void initViews()
    {
        address= (EditText) findViewById(R.id.ip);
        port= (EditText) findViewById(R.id.port);
        btn= (Button) findViewById(R.id.conBtn);
        resp= (TextView) findViewById(R.id.resp);

    }

}
