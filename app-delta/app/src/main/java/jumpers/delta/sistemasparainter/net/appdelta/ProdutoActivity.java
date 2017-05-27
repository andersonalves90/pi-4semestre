package jumpers.delta.sistemasparainter.net.appdelta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProdutoActivity extends android.support.v4.app.Fragment {
    private ImageView proImagemP;
    private TextView proPrecoA;
    private TextView proPrecoD;
    private TextView proNomeProduto;
    private TextView  proDescrição;
    private Button proBtnComprar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_produto, container, false);
        proImagemP=(ImageView) view.findViewById(R.id.proImagemP);
        proPrecoA=(TextView) view.findViewById(R.id.proPrecoA);
        proPrecoD=(TextView) view.findViewById(R.id.proPrecoD);
        proNomeProduto=(TextView) view.findViewById(R.id.proNomeProduto);
        proDescrição=(TextView) view.findViewById(R.id.proDescrição);
        proBtnComprar=(Button) view.findViewById(R.id.proBtnComprar);

        return view;
    }
}
