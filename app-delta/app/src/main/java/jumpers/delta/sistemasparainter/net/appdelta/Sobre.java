package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Sobre extends AppCompatActivity {
    private TextView sobTitle;
    private ImageView sobIntegranteB;
    private TextView sobNomeB;
    private ImageView sobIntegranteA;
    private TextView sobNomeA;
    private TextView sobDescricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        sobTitle=(TextView) findViewById(R.id.sobTitle);
        sobIntegranteA=(ImageView) findViewById(R.id.sobIntegranteA);
        sobNomeA=(TextView) findViewById(R.id.sobNomeA);
        sobIntegranteB=(ImageView) findViewById(R.id.sobIntegranteB);
        sobNomeB=(TextView) findViewById(R.id.sobNomeB);
        sobDescricao=(TextView) findViewById(R.id.sobDescricao);
    }
}
