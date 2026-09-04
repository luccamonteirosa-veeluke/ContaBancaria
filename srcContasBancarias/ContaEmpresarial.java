public class ContaEmpresarial extends ContaBancaria {
    public ContaEmpresarial (String num_conta ,String nome , Double limite ){
        this.num_conta=num_conta;
        this.nome=nome;
        this.saldo=0.00;
        this.limite=limite;
    }
    @Override
    public void saque(Double dinheiro) {
        if (dinheiro <= 0) {
            System.out.println("ERRO valor invalido");
        }
        if (dinheiro <= saldo) {
            this.saldo -= (dinheiro + 5);
            System.out.println("sacado com sucesso");
        }
        if (dinheiro <= (this.saldo + this.limite)) {
            double diferenca = dinheiro - this.saldo;
            this.limite -= (diferenca-5);
            System.out.println("Sucesso seu dinheiro foi sacado: " + dinheiro);
        }

    }

}