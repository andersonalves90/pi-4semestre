package jumpers.delta.sistemasparainter.net.appdelta;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ProdutoActivity extends AppCompatActivity {
    private ImageView proImagemP;
    private TextView proPrecoA;
    private TextView proPrecoD;
    private TextView proNomeProduto;
    private TextView  proDescrição;
    private Button proBtnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        proImagemP=(ImageView) findViewById(R.id.proImagemP);
        proPrecoA=(TextView) findViewById(R.id.proPrecoA);
        proPrecoD=(TextView) findViewById(R.id.proPrecoD);
        proNomeProduto=(TextView) findViewById(R.id.proNomeProduto);
        proDescrição=(TextView) findViewById(R.id.proDescrição);
        proBtnComprar=(Button) findViewById(R.id.proBtnComprar);
    }
}
