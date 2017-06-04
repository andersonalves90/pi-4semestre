package jumpers.delta.sistemasparainter.net.appdelta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import jumpers.delta.sistemasparainter.net.appdelta.entities.CarrinhoSingleton;
import jumpers.delta.sistemasparainter.net.appdelta.entities.Produto;

public class MainActivity extends  android.support.v4.app.Fragment {

    private ImageView maiImageP;
    private EditText maiProduto;
    private EditText maiPrecoProduto;
    private int categoria;
    private Button maiEntrar;
    private ViewGroup produtos;
    private JSONObject jsonProduto = new JSONObject();

    Produto produto = new Produto();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,
                container, false);
        produtos = (ViewGroup) view.findViewById(R.id.container);

        try{

            NetworkCall myCall = new NetworkCall();
            myCall.execute("http://192.168.0.5:8080/WSECommerce/rest/produto");

        }catch (Exception e){
            e.getMessage();
        }

        return view;
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

                JSONArray json = new JSONArray(result);
                for (int i=0; i<5; i+=1) {

                    //Log.d ("produto",json.get(i).toString());

                    JSONObject obj = (JSONObject)json.get(i);

                    CardView cardView = (CardView) LayoutInflater.from(MainActivity.this.getContext()).inflate(R.layout.activity_cardview, produtos, false);
                    ImageView maiImageP = (ImageView) cardView.findViewById(R.id.maiImageP);

                    String imageString = obj.get("imagem").toString();

                    byte[] imageAsBytes = Base64.decode(imageString, Base64.DEFAULT);
                    Bitmap imageBitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
                    maiImageP.setImageBitmap(imageBitmap);
                    produto.setImagem(imageAsBytes);

                    String idString = obj.get("idProduto").toString();
                    Integer idProduto = Integer.parseInt(idString);
                    produto.setIdProduto(idProduto);

                    produto.setNomeProduto(obj.get("nomeProduto").toString());

                    String precoString = obj.get("precProduto").toString();
                    BigDecimal precoBigDecimal = new BigDecimal(precoString);
                    produto.setPrecProduto(precoBigDecimal);

                    String categoriaString = obj.get("idCategoria").toString();
                    Integer idCategoria = Integer.parseInt(categoriaString);
                    produto.setIdCategoria(idCategoria);
                    Button maiEntrar = (Button) cardView.findViewById(R.id.maiEntrar);
                    MainActivity.this.produtos.addView(cardView);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}


