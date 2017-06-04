package jumpers.delta.sistemasparainter.net.appdelta;

        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.NumberPicker;
        import android.widget.TextView;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

public class DetalheActivity extends  android.support.v4.app.Fragment {


    private ImageView detImageP;
    private EditText detProduto;
    private EditText detPrecoProduto;
    private EditText detPromoProduto;
    private EditText detDescProduto;
    private TextView detQuantidade;
    private NumberPicker detConte;
    private Button detEntrar;
    private ViewGroup produtos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detalhe,
                container, false);

        produtos = (ViewGroup) view.findViewById(R.id.container);
        CardView cardView = (CardView) LayoutInflater.from(DetalheActivity.this.getContext()).inflate(R.layout.activity_cardview, produtos, false);
        ImageView detImageP = (ImageView) cardView.findViewById(R.id.detImageP);
        EditText detProduto = (EditText) cardView.findViewById(R.id.detProduto);
        EditText detPrecoProduto = (EditText) cardView.findViewById(R.id.detPrecoProduto);
        EditText detPromoProduto = (EditText) cardView.findViewById(R.id.detPromoProduto);
        EditText detDescProduto = (EditText) cardView.findViewById(R.id.detDescProduto);
        EditText detQuantidade = (EditText) cardView.findViewById(R.id.detQuantidade);
        Button detEntrar = (Button) cardView.findViewById(R.id.detEntrar);

        DetalheActivity.this.produtos.addView(cardView);

        return view;

    }
}

