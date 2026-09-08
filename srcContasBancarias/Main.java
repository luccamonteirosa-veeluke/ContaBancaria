import static java.lang.IO.*;
void main() {
    String titu_empre = readln("insira o nome de sua empresa");
    String titu_corrente = readln("insira o seu nome");
    String titu_poupa = readln("insira o nome da sua conta de poupança");
    String num_empre = readln("insira o numero de conta da sua empresa");
    String num_corrente = readln("insira o numero da sua conta ");
    String num_poupa = readln("insira o numero de conta da sua poupança");
    double limite_corrente = Double.parseDouble(readln("insira o limite da sua conta corrente"));
    double limite_empre = Double.parseDouble(readln("insira o limite da sua conta empresarial"));
    double meta = Double.parseDouble(readln("insira a sua meta "));


    ContaEmpresarial ce = new ContaEmpresarial(num_empre, titu_empre, limite_empre);
    ContaCorrente co = new ContaCorrente(num_corrente, titu_corrente, limite_corrente);
    ContaPoupanca cp = new ContaPoupanca(num_poupa, titu_poupa, meta);
    boolean ex = true;

    while (ex) {
        String op = readln("1-conta empresarial , 2-conta corrente , 3-conta de poupança , 4-sair");
        if (op.equals("1")) {
            boolean on = true;
            while (on) {
                String om = readln("1-depositar . 2-sacar . 3-consultar . 4-sair");

                switch (om) {
                    case "1" -> {
                        double dinheirodep = Double.parseDouble(readln("digite o valor para depositar"));
                        ce.depositar(dinheirodep);
                        continue;
                    }
                    case "2" -> {
                        double dinheirosac = Double.parseDouble(readln("digite o valor para sacar"));
                        ce.saque(dinheirosac);
                        continue;
                    }
                    case "3" -> {
                        ce.getSaldo();
                        continue;

                    }
                    case "4" -> {
                        on = false;
                        continue;

                    }
                }
            }
        } else if (op.equals("2")) {
            boolean on = true;
            while (on) {
                String om = readln("1-depositar . 2-sacar . 3-consultar . 4-sair");

                switch (om) {
                    case "1" -> {
                        double dinheirodep = Double.parseDouble(readln("digite o valor para depositar"));
                        co.depositar(dinheirodep);
                    }
                    case "2" -> {
                        double dinheirosac = Double.parseDouble(readln("digite o valor para sacar"));
                        co.saque(dinheirosac);
                    }
                    case "3" -> {
                        co.getSaldo();

                    }
                    case "4" -> {
                        on = false;

                    }
                }
            }
        } else if (op.equals("3")) {
            boolean on = true;
            String om = readln("1-adicionar dinheiro; 2-remover dinheiro ; 3-monstrar saldo; 5-mostrar status;6-sair ");
            while (on) {
                switch (om) {
                    case "1" -> {

                        double adinheiro = Float.parseFloat(readln("insira valor para depositar"));
                        cp.depositar(adinheiro);
                        continue;
                    }
                    case "2" -> {
                        double rdinheiro = Float.parseFloat(readln("insira valor para retirar"));
                        cp.saque(rdinheiro);
                        continue;
                    }
                    case "3" -> {
                        cp.getSaldo();
                        continue;
                    }
                    case "4" -> {
                        cp.getStatus();
                        continue;
                    }
                    case "5" -> {
                        on = false;
                    }
                }
            }
        }
        else if (op.equals("4")){
            ex=false;
        }
    }
}
