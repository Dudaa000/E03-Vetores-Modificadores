public class Conta {
    private Cliente dono;
    private double saldo;
    private int numero;
    private double limite;
    private String agencia;
    private Operacao[] operacao = new Operacao[1000];
    private int contador_operacoes = 0;
    public static int totalContas=0;

    public Conta(Cliente dono, String agencia, int numero, int limite, double saldo) {
        this.dono = dono;
        this.saldo = saldo;
        this.numero = numero;
        this.limite = limite;
        this.agencia = agencia;
        totalContas++;
    }
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public Cliente getDono(){
        return dono;
    }
    public void setDono( Cliente dono){
        this.dono = dono ;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLimite(double limite) {
        if( limite < 0) {
            this.limite = 0;
        }else {
            this.limite = limite;
        }

    }

    public boolean deposito(double valor) {
        if(contador_operacoes<1000) {
            if (valor > 0.0) {
                this.operacao[contador_operacoes] = new Operacao('d', valor);
                this.contador_operacoes++;
                this.saldo += valor;
                return true;
            } else {
                return false;
            }
        }else {
            System.out.println("Quantia maxima de operacoes atingidas!!!");
            return false;
        }
    }


    public boolean saque(double valor) {
        if (contador_operacoes < 1000) {
            if (valor > 0.0 && valor <= this.saldo) {
                this.operacao[contador_operacoes] = new Operacao('s', valor);
                this.contador_operacoes++;
                this.saldo -= valor;
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Quantia maxima de operacoes atingidas!!!");
            return false;
        }
    }
    //anotacoes:
    // this funciona só na classe que vc esta chamando o objeto
    // this referencia ao objeto chamado
    //Objeto, tipo uma struct (nesee momento) que pega informações sobre a conta
    //new é tipo o malloc em c, aloca um lugar para aquilo

    public boolean transferir(Conta contaDestino, double valor) {
        boolean transfenciaFeita = this.saque(valor);
        if (transfenciaFeita) {
            boolean deposito = contaDestino.deposito(valor);
            return deposito;
        } else {
            return false;
        }
    }


    public void Imprimir() {
        System.out.println("Nome do dono da conta: " + this.dono.nome);
        System.out.println("CPF: " + this.dono.CPF);
        System.out.println("Endereço: " + this.dono.endereco);
        System.out.println("Idade: " + this.dono.idade);
        System.out.println("Sexo: " + this.dono.sexo);
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("Limite: " + this.limite);
    }
    public void extrato(){
        for(int i=0; i<contador_operacoes; i++){
            System.out.println(operacao[i].tipo+" "+operacao[i].valor+" "+operacao[i].data);
        }
    }
}
