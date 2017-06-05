package jumpers.delta.sistemasparainter.net.appdelta;

        import android.content.Intent;
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
        import java.math.BigDecimal;
        import java.net.HttpURLConnection;
        import java.net.URL;

        import jumpers.delta.sistemasparainter.net.appdelta.entities.Produto;

public class DetalheActivity extends  AppCompatActivity {

    private static Integer quant;
    private ImageView detImageP;
    private EditText detProduto;
    private EditText detPrecoProduto;
    private EditText detPromoProduto;
    private EditText detDescProduto;
    private TextView detQuantidade;
    private NumberPicker detConte;
    private Button detEntrar;
    Produto produto = new Produto();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        ImageView detImageP = (ImageView) findViewById(R.id.detImageP);
        EditText detProduto = (EditText) findViewById(R.id.detProduto);
        EditText detPrecoProduto = (EditText)findViewById(R.id.detPrecoProduto);
        EditText detPromoProduto = (EditText)findViewById(R.id.detPromoProduto);
        EditText detDescProduto = (EditText)findViewById(R.id.detDescProduto);
        Button detEntrar = (Button)findViewById(R.id.detEntrar);
        EditText detConte = (EditText)findViewById(R.id.detConte);

        String qtd =detConte.getText().toString();
        Integer quantInt = Integer.parseInt(qtd);
        produto.setQtdMinEstoque(quantInt);
        quant = quantInt;



        try{
            Intent i = getIntent();

            String idProdutoQR = i.getStringExtra("idProduto");

            String id =  getIntent().getExtras().getString("id");

            NetworkCall myCall = new NetworkCall();

            // passando o id na url
            myCall.execute("http://deltaws.azurewebsites.net/g2/rest/produto/" +id);

        }catch (Exception e){
            e.getMessage();
        }

    }


    public static Integer getQuant() {
        return quant;
    }


    public class NetworkCall extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(params[0]).openConnection();

                InputStream in = urlConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

                StringBuilder resultado = new StringBuilder();
                String linha = bufferedReader.readLine();

                while (linha != null) {
                    resultado.append(linha);
                    linha = bufferedReader.readLine();
                }

                String respostaCompleta = resultado.toString();

                return respostaCompleta;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                JSONObject obj =new JSONObject(result);

                String idString = obj.get("idProduto").toString();
                Integer idProduto = Integer.parseInt(idString);
                produto.setIdProduto(idProduto);

                produto.setNomeProduto(obj.get("nomeProduto").toString());
                produto.setDescProduto(obj.get("descProduto").toString());

                String preString = obj.get("precProduto").toString();
                BigDecimal precoBigDecimal = new BigDecimal(preString);
                produto.setPrecProduto(precoBigDecimal);

                String descontoString = obj.get("descPromocao").toString();
                BigDecimal descBigDecimal = new BigDecimal(descontoString);
                produto.setPrecProduto(descBigDecimal);

                String quantidadeString = obj.get("qtdMinEstoque").toString();
                Integer quantInt = Integer.parseInt(quantidadeString);
                produto.setIdCategoria(quantInt);



                detEntrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DetalheActivity.this,Carrinho.class);
                        startActivity(intent);
                    }
                });



            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
