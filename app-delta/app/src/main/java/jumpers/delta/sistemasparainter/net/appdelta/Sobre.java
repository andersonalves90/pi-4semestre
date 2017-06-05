package jumpers.delta.sistemasparainter.net.appdelta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Sobre extends android.support.v4.app.Fragment {
    private TextView sobTitle;
    private ImageView sobIntegrante1;
    private TextView sobNome1;
    private ImageView sobIntegrante2;
    private TextView sobNome2;
    private ImageView sobIntegrante3;
    private TextView sobNome3;
    private ImageView sobIntegrante4;
    private TextView sobNome4;
    private TextView sobDescricao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sobre,
                container, false);

        sobTitle=(TextView) view.findViewById(R.id.sobTitle);
        sobIntegrante1=(ImageView) view.findViewById(R.id.sobIntegrante1);
        sobNome1=(TextView) view.findViewById(R.id.sobNome1);
        sobIntegrante2=(ImageView) view.findViewById(R.id.sobIntegrante2);
        sobNome2=(TextView) view.findViewById(R.id.sobNome2);
        sobIntegrante3=(ImageView) view.findViewById(R.id.sobIntegrante3);
        sobNome3=(TextView) view.findViewById(R.id.sobNome3);
        sobIntegrante4=(ImageView) view.findViewById(R.id.sobIntegrante4);
        sobNome4=(TextView) view.findViewById(R.id.sobNome4);
        sobDescricao=(TextView) view.findViewById(R.id.sobDescricao);

        return view;
    }

}