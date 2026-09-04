# Sistema de Gerenciamento de Contas Bancárias

Este projeto é um sistema em Java operado via linha de comando para simular operações bancárias essenciais. Ele utiliza os princípios da Programação Orientada a Objetos (POO), incluindo herança, polimorfismo e encapsulamento, para gerenciar de forma segura o patrimônio financeiro.

---

##  Diferenças entre os três tipos de conta

O sistema foi arquitetado a partir de uma classe abstrata mãe (`ContaBancaria`), da qual derivam três perfis de contas distintos:

1. **Conta Corrente:** Destinada ao uso diário de pessoas físicas. Possui um `saldo` e um `limite` de crédito (cheque especial). Caso o saldo seja insuficiente para um saque, o sistema consome automaticamente o limite disponível.
2. **Conta Empresarial:** Voltada para clientes pessoa jurídica (empresas). Funciona de maneira semelhante à Conta Corrente, possuindo saldo e limite, porém aplica uma regra de negócio específica: **toda operação de saque possui uma taxa fixa de R$ 5,00**.
3. **Conta Poupança:** Focada em economia e rentabilidade. Diferente das demais, não possui limite de crédito. Em vez disso, possui uma `meta` financeira definida pelo usuário. Permite o acompanhamento para saber se a pessoa ainda está "Economizando" ou se a "meta foi alcançada".

---

##  Regras de Depósito

A operação de depósito é padronizada para todas as contas através do método `depositar(Double dinheiro)` herdado da classe `ContaBancaria`.
* **Regra Principal:** O sistema rejeita depósitos com valores menores ou iguais a zero (`dinheiro <= 0`), exibindo a mensagem *"erro valor invalido"*.
* Caso o valor seja positivo, ele é integralmente somado ao `saldo` da conta.

---

##  Regras de Saque

A operação de saque utiliza o polimorfismo, pois cada conta possui sua própria regra de negócio na hora de retirar fundos:

* **Conta Corrente:** 
  - O valor deve ser maior que zero.
  - Se houver `saldo` suficiente, o valor é debitado apenas do saldo.
  - Se o valor for maior que o `saldo`, mas couber na soma `(saldo + limite)`, o saldo é zerado e a diferença é descontada do limite de crédito.
  - Se ultrapassar a soma de ambos, a transação é bloqueada.
* **Conta Empresarial:** 
  - Segue a mesma lógica de aprovação da Conta Corrente (saldo e limite), porém, ao realizar a dedução, o sistema **subtrai R$ 5,00 adicionais** referentes à taxa de operação.
* **Conta Poupança:** 
  - O saque não utiliza limites. *(Atenção à equipe de desenvolvimento: a lógica atual na classe ContaPoupanca soma o valor ao saldo indevidamente no saque e precisa ser ajustada para subtração em atualizações futuras).*

---

##  Justificativa para não existir `setSaldo()`

Em sistemas financeiros, a integridade dos dados é crítica. O método `setSaldo()` não foi implementado para garantir o **encapsulamento** e a **segurança** da aplicação. 

O saldo de uma conta bancária nunca deve ser sobrescrito arbitrariamente por outras partes do código. A única maneira de alterar o saldo é através do fluxo financeiro legítimo: entradas (`depositar()`) e saídas (`saque()`). A ausência do `setSaldo()` impede que um erro no sistema ou uma manipulação indevida redefina o dinheiro do cliente sem validação.

---

## Explicação sobre o método `protected debitar()`

Embora a validação das regras de negócio (limites, taxas) fique a cargo de cada classe filha ao sobrescrever o método `saque()`, a operação matemática de subtrair do saldo idealmente utiliza um conceito de método centralizado, como um `protected void debitar()`.

A utilização do modificador `protected` garante que apenas a própria família de classes (`ContaBancaria` e suas filhas) consiga tocar no atributo `saldo` (que também é protegido). O objetivo de um método `debitar()` isolado é evitar duplicação de código na hora de fazer a subtração pura do dinheiro, centralizando a matemática da operação na classe mãe e deixando as classes filhas apenas com a responsabilidade de decidir *se* o débito foi aprovado e *quais taxas* se aplicam.

---

##  Instruções para execução

O projeto requer recursos recentes do Java, especificamente os pacotes de simplificação de Entrada/Saída (`java.lang.IO`) e os métodos *void main* implícitos.

**Pré-requisito:** Ter o **JDK 21** ou superior instalado e configurado no *classpath*.

1. Abra o terminal e navegue até a pasta raiz onde os arquivos `.java` estão localizados.
2. Compile todas as classes através do comando:
   ```bash
   javac --release 21 --enable-preview *.java
