# ContaBancaria
Sistema de Gerenciamento Bancário
Sobre o Projeto
Este é um sistema bancário interativo de linha de comando desenvolvido em Java. O projeto simula operações financeiras diárias e aplica conceitos fundamentais de Programação Orientada a Objetos (POO), como herança, polimorfismo e o uso de classes abstratas para evitar duplicação de código. O usuário pode criar contas, depositar, sacar e consultar o status financeiro de forma dinâmica.

Estrutura de Classes
O sistema é dividido em cinco arquivos principais:

ContaBancaria.java: A classe abstrata que serve como base. Ela define os atributos compartilhados (saldo, nome, num_conta, limite) e o método padrão de depósito.

ContaCorrente.java: Extensão da conta base que permite saques utilizando um limite pré-aprovado quando o saldo principal é insuficiente.

ContaEmpresarial.java: Conta voltada para negócios. A lógica de saque foi adaptada para cobrar uma taxa de operação (deduzindo R$ 5,00 extras a cada transação de saque).

ContaPoupanca.java: Uma conta focada em guardar dinheiro. No lugar de um limite de crédito, o usuário define uma meta e pode usar a função getStatus para verificar se alcançou seu objetivo financeiro.

Main.java: O ponto de entrada do programa. Consiste em um loop com um menu interativo para que o usuário gerencie as três contas instanciadas.

Como Executar
O projeto faz uso de recursos recentes do Java, como métodos void main() simplificados e o pacote java.lang.IO. Siga os passos abaixo:

Certifique-se de ter o Java 21 (ou superior) instalado na sua máquina.

Navegue até o diretório onde os arquivos estão salvos usando o seu terminal.

Compile os arquivos rodando o comando: javac *.java

Como o código utiliza preview features, execute o programa habilitando esses recursos. Exemplo: java --enable-preview Main
