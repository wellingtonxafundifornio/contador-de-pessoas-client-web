package com.softwareltda.peopleCounter.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softwareltda.peopleCounter.model.Contador;

public class Mosquitto implements MqttCallback {

	private static final Logger logger = LoggerFactory.getLogger(Mosquitto.class);
	
	private MqttClient cliente;
	private MqttMessage mensagem;
	private Contador contadorPessoas;

	public Mosquitto(String ip) {
		try {
			contadorPessoas = new Contador();
			cliente = new MqttClient("tcp://" + ip + ":1883", "Send");
			cliente.connect();
			mensagem = new MqttMessage();
			cliente.setCallback(this);
			cliente.subscribe("#");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public MqttClient getCliente() {
		return cliente;
	}

	public void setCliente(final MqttClient cliente) {
		this.cliente = cliente;
	}

	public MqttMessage getMensagem() {
		return mensagem;
	}

	public void setMensagem(final MqttMessage mensagem) {
		this.mensagem = mensagem;
	}

	public Contador getContadorDePessoas() {
		return contadorPessoas;
	}

	public void setContadorDePessoas(final Contador contadorDePessoas) {
		this.contadorPessoas = contadorDePessoas;
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageArrived(final String topico, final MqttMessage mensagem) throws Exception {
		logger.info(">>>> >>> Fazendo SUBSCRIBE do broker, no tópico: " + "'" + topico + "'");

		contadorPessoas.atualizaQuantidadePessoasSala(topico);

		logger.info("Quandidade de Pessoas: " + contadorPessoas.getQuantidadeDePessoas());
		logger.info(">>>> >>> END SUBSCRIBE ..................");

	}

}
