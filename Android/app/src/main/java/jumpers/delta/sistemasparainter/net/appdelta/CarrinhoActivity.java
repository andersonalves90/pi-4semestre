package jumpers.delta.sistemasparainter.net.appdelta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CarrinhoActivity extends AppCompatActivity {
    private EditText CarVarlor;
    private Button CarContinuar;
    private Button CarPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        CarVarlor = (EditText) findViewById(R.id.CarVarlor);
        CarContinuar = (Button) findViewById(R.id.CarContinuar);
        CarPagar = (Button) findViewById(R.id.CarPagar);
    }
}
