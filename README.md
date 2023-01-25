# Sistema de filas para publicação de anúncio de veículos

Instruções:

- Rodar activeMQ

Utilizando a devida IDE: 

- run ProducerFila.java para enviar uma msg pra fila.

- run ConsumerFila.java para consumir uma msg da fila.

Todas as mensagens consumidas serão armazenadas e sempre que uma nova mensagem for consumida, a lista de todas as mensagens anteriores será mostrada juntamente com a atual mensagem consumida.

As mensagens aparecem no console, caso o log do activemq esteja muito grande, pode ser necessário scrollar o console para cima.
