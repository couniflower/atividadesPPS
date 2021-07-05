package atividade05;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    protected List<ItemDoPedido> itensPedido;
    protected String observacoes;

    public Pedido() {
        itensPedido = new ArrayList<>();
    }

    protected Pedido(PedidoBuilder builder) {
        if(builder.observacoes == null) observacoes = "-";
        else observacoes = builder.observacoes;
        itensPedido = builder.itensPedido;
    }

    @Override
    public String toString() {
        StringBuilder pedido = new StringBuilder("Pedido\n\n");
        String frase;
        for(ItemDoPedido item : itensPedido) {
            frase =
                    item.getProduto().nome() + " (" + item.getProduto().preco() + ") - QTD: " + item.getQuantidade() + " - Subtotal: " + (item.getProduto().preco() * item.getQuantidade()) + " - Obs: " + item.getProduto().obs() + "\n";
            pedido.append(frase);
        }
        frase = "\nObservações: " + observacoes;
        pedido.append(frase);
        return pedido.toString();
    }
}
