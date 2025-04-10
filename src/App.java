public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Banco Desctuary");
        Cliente cliente = new Cliente();
        cliente.setNome("Thomas");

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        Thread.sleep(1000);

        cc.depositar(100);
        
        cc.imprimirExtrato();
        cp.imprimirExtrato();
        Thread.sleep(1000);
        cc.transferir(100, cp);      

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
