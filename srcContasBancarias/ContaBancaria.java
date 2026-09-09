public abstract class ContaBancaria {
    protected double saldo;
    protected String num_conta;
    protected String nome;
    protected double limite;

    public void depositar(Double dinheiro) {
        if (dinheiro <= 0) {
            System.out.println("erro valor invalido");
        } else {
            this.saldo = dinheiro + saldo;
            System.out.println("seu dinheiro foi depositado com sucesso");
        }
    }

    public void saque(Double dinheiro) {
    }

    public void getSaldo() {
        System.out.println("saldo :  R$" + saldo);
        System.out.println("limite :  R$" + limite);
    }
}
