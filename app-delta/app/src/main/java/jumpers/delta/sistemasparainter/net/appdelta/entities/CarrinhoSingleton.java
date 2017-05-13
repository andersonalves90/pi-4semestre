package jumpers.delta.sistemasparainter.net.appdelta.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eliana.aqueiroz on 03/05/2017.
 */

public class CarrinhoSingleton {


    private static CarrinhoSingleton instance = null;

    private CarrinhoSingleton () {}

    public static CarrinhoSingleton getInstance () {
        if (instance == null)
            instance = new CarrinhoSingleton();
        return instance;

    }

    public List<Produto> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    private List<Produto> produtosNoCarrinho = new ArrayList<Produto>();

}
