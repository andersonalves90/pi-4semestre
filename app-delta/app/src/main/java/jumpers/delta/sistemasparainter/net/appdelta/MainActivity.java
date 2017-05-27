package jumpers.delta.sistemasparainter.net.appdelta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.math.BigDecimal;
import android.net.Network;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import jumpers.delta.sistemasparainter.net.appdelta.entities.CarrinhoSingleton;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Produto;


public class MainActivity extends  android.support.v4.app.Fragment {

    private ImageView maiImageP;
    private EditText maiProduto;
    private EditText maiPrecoProduto;
    private EditText maiPromoProduto;
    private EditText maiDescProduto;
    private TextView maiQuantidade;
    private Spinner spinner;
    private  Button maiEntrar;
    private ViewGroup produtos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,
                container, false);
       // produtos = (ViewGroup) view.findViewById(R.id.container);

        return view;
    }
    /*
public  void additem(){
    CardView cardView = (CardView) LayoutInflater.from(this).inflate(R.layout.activity_cardview, produtos, false);
    EditText maiProduto = (EditText) cardView.findViewById(R.id.maiProduto);
    EditText maiPrecoProduto = (EditText) cardView.findViewById(R.id.maiPrecoProduto);
    EditText maiPromoProduto = (EditText) cardView.findViewById(R.id.maiPromoProduto);
    EditText maiDescProduto = (EditText) cardView.findViewById(R.id.maiDescProduto);
    TextView maiQuantidade = (TextView) cardView.findViewById(R.id.maiQuantidade);
    Spinner spinner = (Spinner) cardView.findViewById(R.id.spinner);
    Button maiEntrar = (Button) cardView.findViewById(R.id.maiEntrar);
    Produto produto = new Produto();


   // produto.setNomeProduto();
    maiPrecoProduto.setText((CharSequence) produto);
    maiPromoProduto.setText((CharSequence) produto);
    maiDescProduto.setText((CharSequence) produto);
    maiQuantidade.setText((CharSequence) produto);
    produtos.addView(cardView);


    NetworkCall myCall = new NetworkCall();
}

        /*

        addItem("https://upload.wikimedia.org/wikipedia/commons/5/54/Europa-moon.jpg");
        addItem("https://upload.wikimedia.org/wikipedia/commons/5/54/Europa-moon.jpg");
        */




    public class NetworkCall extends AsyncTask<String, Void, String> {

        // Esse é o método que executa a tarefa em segundo plano
        @Override
        protected String doInBackground(String... params) {
            try {
                // Cria o objeto de conexão
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(params[0]).openConnection();

                // Executa a requisição pegando os dados
                InputStream in = urlConnection.getInputStream();

                // Cria um leitor para ler a resposta
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

                StringBuilder resultado = new StringBuilder();
                String linha = bufferedReader.readLine();

                // Lê linha a linha a resposta e armazena no StringBuilder
                while (linha != null) {
                    resultado.append(linha);
                    linha = bufferedReader.readLine();
                }

                // Transforma o StringBuilder em String, que contém a resposta final
                String respostaCompleta = resultado.toString();

                // Retorna a string final contendo a resposta retornada
                return respostaCompleta;

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Caso tenha dado algum erro, retorna null
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                // Cria um objeto JSON a partir da resposta
                JSONObject json = new JSONObject(result);

                // Verifica o tipo de operação e pega o dado correspondente do JSON
                String finalResult = "";


      /*          Intent intent = new Intent(MainActivity.this,CarrinhoActivity.class);
                intent.putExtra("nomeProduto", json.getString("nome"));
                intent.putExtra("descProduto", json.getString("descricao"));
                intent.putExtra("precProduto", json.getString("preco"));
                intent.putExtra("descontoPromocao", json.getString("desconto"));
                intent.putExtra("idCategoria", json.getString("categoria"));
                intent.putExtra("ativoProduto", json.getString("bolean"));
                intent.putExtra("idUsuario", json.getString("id"));
                intent.putExtra("qtdMinEstoque", json.getString("qtd"));
                intent.putExtra("imagem", json.getString("imagem"));
                startActivity(intent);
                finish();
*/

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /*
    private void addItem(String url) {
        ImageView maiImageP = (ImageView) cardView.findViewById(R.id.maiImageP);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        imageLoader.displayImage(url, maiImageP);
        produtos.addView(cardView);
*/
    }









    //  Produto  produto = new Produto();


    /* private void addItem(Produto produto) {


    }

/* "nomeProduto,descProduto,precProduto,descontoPromocao,idCategoria,ativoProduto,idUsuario,qtdMinEstoque,imagem,sppiner,compra");*/