/* ***************************************************************
* Autor............: Hugo Botelho Santana
* Matricula........: 202210485
* Inicio...........: 18/03/2025
* Ultima alteracao.: 20/03/2025
* Nome.............: Servidor de tempo
* Funcao...........: Oferecer um servico de tempo aos clientes
*************************************************************** */


public class Principal {

    public static void main(String[] args) {
        // Inicia o servidor UDP em uma thread separada
        Thread servidorUDPThread = new Thread(() -> {
            ServidorTempoUDP servidorTempoUDP = new ServidorTempoUDP();
            servidorTempoUDP.iniciar();
        });


        // Inicia as threads
        servidorUDPThread.start();

        System.out.println("Servidores UDP iniciado...");
    }

}
