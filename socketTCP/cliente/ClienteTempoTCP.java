import java.net.*;

import java.io.*;

public class ClienteTempoTCP {

    private String host;
    private int porta;
    private Principal app;

    // Construtor
    public ClienteTempoTCP(Principal app, String host, int porta) {
        this.host = host;
        this.porta = porta;
        this.app = app;
    }

    // Método para conectar ao servidor e enviar a APDU
    private long conectar(String tipoMensagem) {
        long tempoDecorrido = 0;

        try (Socket socket = new Socket(host, porta);
                ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream())) {

            System.out.println("Conectado ao servidor " + host + ":" + porta);

            long inicioTimer = System.currentTimeMillis();

            saida.writeObject(tipoMensagem);
            saida.flush();
            System.out.println("Mensagem enviada: " + tipoMensagem);

            // Aguarda a resposta antes de fechar a conexão
            String resposta = (String) entrada.readObject();
            tempoDecorrido = System.currentTimeMillis() - inicioTimer;
            System.out.println(
                    "Resposta do servidor: " + resposta + " | Tempo decorrido: " + tempoDecorrido + " ms");

            app.processarMensagemRecebida(resposta, tempoDecorrido);

        } catch (EOFException e) {
            System.err.println("Servidor fechou a conexão inesperadamente.");
        } catch (SocketException e) {
            System.err.println("Conexão perdida com o servidor.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao conectar ou enviar mensagem: " + e.getMessage());
        }

        return tempoDecorrido;
    }

    // Método para enviar a APDU JOIN em uma thread
    public void enviarRequisicao(String req) {
        Thread requisicao = new Thread(() -> conectar(req));
        requisicao.start(); // Inicia a thread de envio JOIN
    }

    // public String receberHorario() {
    // }

    public void setIpServidor(String novoIP) {
        try {
            host = novoIP;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Fecha o socket do cliente e para a escuta.
     */
    // public void fechar() {
    // // escutando = false; // Para a thread de escuta
    // clienteSocket.close();
    // }
}
