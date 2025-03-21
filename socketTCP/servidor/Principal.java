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
        // Inicia o servidor TCP em uma thread separada
        Thread servidorTCPThread = new Thread(() -> {
            ServidorTempoTCP servidorTempoTCP = new ServidorTempoTCP();
            servidorTempoTCP.iniciar();
        });


        // Inicia as threads
        servidorTCPThread.start();

        System.out.println("Servidor TCP iniciado...");
    }

}
