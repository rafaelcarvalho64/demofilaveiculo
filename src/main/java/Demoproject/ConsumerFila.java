package Demoproject;

import java.util.ArrayList;
import java.util.List;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class ConsumerFila {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; // "vm://localhost";
    //Nome da fila ou topico para onde enviaremos a mensagem
    private static String subject = "MY_FILA";
    List<Veiculo> myList = new ArrayList<Veiculo>();
    private void consumir() throws JMSException {
        // cria a fabrica de conexao e inicia a conexao
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // Cria sessão para consumir a mensagem
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // Cria a fila destino (Queue)
        Destination destination = session.createQueue(subject);
        // Cria uma MessageConsumer da Session do Topic or Queue
        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive(15000);

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Recebi da Fila a msg = '" + textMessage.getText() + "'");
            if (textMessage.getText().toLowerCase().contains("xml")) {
            	recuperaMensagemObjeto(textMessage);
            }
        }
        
        consumer.close();
        session.close();
        connection.close();
    }
    
    public static void main(String[] args) throws JMSException {
    	ConsumerFila cf = new ConsumerFila();
    	while (true)  cf.consumir();  
    }
    
    private void recuperaMensagemObjeto(TextMessage msg) throws JMSException {
    	// consumer side:
    	TextMessage tmsg = (TextMessage)msg;
    	
    	// instancia um XStream
        XStream xstream = new XStream(new StaxDriver());
    	// configura a seguranca do XStream
       // xstream .addPermission(NoTypePermission.NONE); //forbid everything
       // xstream .addPermission(NullPermission.NULL);   // allow "null"
       // xstream .addPermission(PrimitiveTypePermission.PRIMITIVES); // allow primitive types
        
        xstream.addPermission(AnyTypePermission.ANY);
        
        Veiculo par = (Veiculo) xstream.fromXML(tmsg.getText());
        
        myList.add(par);
        
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
      	System.out.println("Lista de Veículos:");
      	for (Veiculo par1 : myList) {
      		System.out.println("Nome do Cliente = " + par1.getNomeCliente());
            System.out.println("Marca - Modelo = " + par1.getMarcaModeloVeiculo());
            System.out.println("Ano = " + par1.getAnoModelo());
            System.out.println("Valor = " + par1.getValorVenda());
            System.out.println("Data = " + par1.getDataPublicacao());
		}
      	System.out.println("--------------------------------------------");
      	System.out.println("--------------------------------------------");
      	System.out.println("--------------------------------------------");
      	System.out.println("--------------------------------------------");
      	System.out.println("--------------------------------------------");
    }
}
