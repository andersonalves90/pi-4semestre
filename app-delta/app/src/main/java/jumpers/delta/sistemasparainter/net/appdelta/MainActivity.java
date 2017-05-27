package jumpers.delta.sistemasparainter.net.appdelta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import jumpers.delta.sistemasparainter.net.appdelta.entities.CarrinhoSingleton;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Produto;

import static android.content.Context.MODE_PRIVATE;


public class MainActivity extends android.support.v4.app.Fragment {
    ImageView maiImageP;
    TextView maiProduto;
    Button maiEntrar;
    private SharedPreferences prefs;
    @Override
    // home
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);
        maiImageP = (ImageView) view.findViewById(R.id.maiImageP);
        maiProduto = (TextView) view.findViewById(R.id.maiProduto);
        maiEntrar = (Button) view.findViewById(R.id.maiEntrar);

        //prefs = getSharedPreferences("maiImagePConfig", MODE_PRIVATE);

        //final SharedPreferences.Editor editor = prefs.edit();

        /*
        maiEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,ProdutoActivity.class);
            //pagina indo para produto add o produto;
            Produto produto = new Produto();
            CarrinhoSingleton.getInstance().getProdutosNoCarrinho().add(produto);
            startActivity(intent);
            }
        });
        */

        return view;

    }

    //private SharedPreferences getSharedPreferences(String maiImagePConfig, int modePrivate) {}
}
