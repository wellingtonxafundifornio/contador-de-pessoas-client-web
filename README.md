# Lab Inicia��o Cientifica - Contador de pessoas Web Responsivo

Experimento de cria��o de uma `aplica��o web que l� dados do mqtt` 

## Dentro da pasta

`...documentacao\` Tem o `diagrama de classe` e uma imagem da `tela` da aplica��o 

## Para executar e testar a aplica��o, pode ser feito o seguinte passo a passo
 * Suba o servidor mosquitto;
 * Tste no servidor mosquitto um pub(publish) e um sub(subscribe);
 * V� at� a classe ...peopleCounter\service\ `ContadorService.java` 
 * Na linha 8 da classe `ContadorService.java`, dentro do construtor do objeto Mosquitto `private Mosquitto mosquitto = new Mosquitto("ip do mosquitto aqui...");` coloque o ip do MQTT
 * Obs: A classe `Contador.class` efetua a logica de `incremento` e `decremento` que baseia-se t�picos lidos do MQTT.
 
`peopleCounter >> Maven >> Update Project`
`peopleCounter >> Run as >> Run on Server`

### Fazendo um breve resumo sobre a aplica��o

Est� aplica��o Web tem o `papel` de l�r dados (subscribe) do MQTT e executar a l�gica de `incremento` e `decremento` baseando-se no t�pico lido do MQTT. Tal t�pico ser� enviado (publish) ao MQTT por meio da aplica��o IOT `contador-de-pessoas-IOT`  https://github.com/wellingtonxafundifornio/contador-de-pessoas-IOT


