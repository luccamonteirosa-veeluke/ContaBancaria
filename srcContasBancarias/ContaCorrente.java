public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String num_conta, String nome, Double limite) {
        this.num_conta = num_conta;
        this.nome = nome;
        this.saldo = 0.00;
        this.limite = limite;
    }
    @Override
    public void saque(Double dinheiro){ 
        if(dinheiro<=0){
            System.out.println("erro valor deve ser maior que zero");
        }
        if (dinheiro<=this.saldo){
            this.saldo -= dinheiro;
            System.out.println("sacado com sucesso");
        }
        if (dinheiro<=(this.saldo + this.limite)){
            double diferenca= dinheiro -this.saldo;
            this.saldo = 0.0;
            this.limite-=diferenca;
            System.out.println("Sucesso seu dinheiro foi sacado: " + dinheiro);
        }
        else {
            System.out.println("erro valor maior que saldo e limite");
        }
    }

}
