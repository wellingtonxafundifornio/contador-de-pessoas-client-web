package com.softwareltda.peopleCounter.service;

import com.softwareltda.peopleCounter.model.Contador;
import com.softwareltda.peopleCounter.mqtt.Mosquitto;

public class ContadorService {

	private Mosquitto mosquitto = new Mosquitto("192.168.0.103");

	public Contador atualizaContador() {

		return mosquitto.getContadorDePessoas();
	}
}
