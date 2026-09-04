public class ContaPoupanca extends ContaBancaria {
    private double meta;

    public ContaPoupanca(String num_conta, String nome , double meta) {
        this.num_conta = num_conta;
        this.nome = nome;
        this.saldo = 0.00;
        this.meta=meta;
    }
    @Override
    public void saque(Double dinheiro) {
        if (dinheiro < 0) {
            System.out.println("Erro valor invalido");
        } else {
            this.saldo = saldo + dinheiro;
            System.out.println("seu dinheiro foi depositado");
        }
    }
    public void getStatus(){
        if (saldo==0){
            System.out.println("meta não inicializada");
        } else if (saldo<meta) {
            System.out.println("Economizando");
        }
        else {
            System.out.println("meta alcançada");
        }
    }

    public void getSaldo() {
        System.out.println("saldo :  R$" + saldo);
        System.out.println("meta:  R$" + meta);
    }
}