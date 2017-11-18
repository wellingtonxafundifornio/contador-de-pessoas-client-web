# Lab Iniciação Cientifica - Contador de pessoas Web Responsivo

Experimento de criação de uma `aplicação web que lê dados do mqtt` 

## Dentro da pasta

`...documentacao\` Tem o `diagrama de classe` e uma imagem da `tela` da aplicação 

## Para executar e testar a aplicação, pode ser feito o seguinte passo a passo
 * Suba o servidor mosquitto;
 * Tste no servidor mosquitto um pub(publish) e um sub(subscribe);
 * Vá até a classe ...peopleCounter\service\ `ContadorService.java` 
 * Na linha 8 da classe `ContadorService.java`, dentro do construtor do objeto Mosquitto `private Mosquitto mosquitto = new Mosquitto("ip do mosquitto aqui...");` coloque o ip do MQTT
 * Obs: A classe `Contador.class` efetua a logica de `incremento` e `decremento` que baseia-se tópicos lidos do MQTT.
 
`peopleCounter >> Maven >> Update Project`
`peopleCounter >> Run as >> Run on Server`

### Fazendo um breve resumo sobre a aplicação

Está aplicação Web tem o `papel` de lêr dados (subscribe) do MQTT e executar a lógica de `incremento` e `decremento` baseando-se no tópico lido do MQTT. Tal tópico será enviado (publish) ao MQTT por meio da aplicação IOT `contador-de-pessoas-IOT`  https://github.com/wellingtonxafundifornio/contador-de-pessoas-IOT


