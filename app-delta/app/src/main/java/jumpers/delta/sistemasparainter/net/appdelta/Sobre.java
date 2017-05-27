package jumpers.delta.sistemasparainter.net.appdelta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Sobre extends android.support.v4.app.Fragment {
    private TextView sobTitle;
    private ImageView sobIntegranteB;
    private TextView sobNomeB;
    private ImageView sobIntegranteA;
    private TextView sobNomeA;
    private TextView sobDescricao;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

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
