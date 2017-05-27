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

        View view = inflater.inflate(R.layout.activity_sobre, container, false);
        sobTitle=(TextView) view.findViewById(R.id.sobTitle);
        sobIntegranteA=(ImageView) view.findViewById(R.id.sobIntegranteA);
        sobNomeA=(TextView) view.findViewById(R.id.sobNomeA);
        sobIntegranteB=(ImageView) view.findViewById(R.id.sobIntegranteB);
        sobNomeB=(TextView) view.findViewById(R.id.sobNomeB);
        sobDescricao=(TextView) view.findViewById(R.id.sobDescricao);
        //teste

        return view;
    }
}
