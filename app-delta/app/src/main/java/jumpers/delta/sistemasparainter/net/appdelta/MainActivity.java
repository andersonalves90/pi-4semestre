package jumpers.delta.sistemasparainter.net.appdelta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import jumpers.delta.sistemasparainter.net.appdelta.entities.CarrinhoSingleton;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Produto;


public class MainActivity extends AppCompatActivity {
        ImageView maiImageP;
        TextView maiProduto;
        Button maiEntrar;
        private SharedPreferences prefs;
    @Override
    // home
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maiImageP = (ImageView) findViewById(R.id.maiImageP);
        maiProduto = (TextView) findViewById(R.id.maiProduto);
        maiEntrar = (Button) findViewById(R.id.maiEntrar);

        prefs = getSharedPreferences("maiImagePConfig",
                MODE_PRIVATE);

        final SharedPreferences.Editor editor = prefs.edit();

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

    }
}
