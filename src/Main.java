public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Mara Maravilha", "333.333.333-33", "Rua Deus e mais, 7", 60, 'F');
        Conta conta1 = new Conta(cliente1, "333.3", 3434, 20000, 100000.0);


        conta1.deposito(4000);
        conta1.saque(200);
        conta1.deposito(6000);
        conta1.saque(100);


        System.out.println("Informações da conta:");

        conta1.Imprimir();
        conta1.extrato();
        //fazendo a media
        int media = Operacao.totalOperacoes/Conta.totalContas;

        System.out.println("media:" +media);


    }
}