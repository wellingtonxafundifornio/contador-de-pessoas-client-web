package com.softwareltda.peopleCounter.mqtt;

import org.junit.Test;

import junit.framework.TestCase;

public class TestOperacoesNaClasseMosquitto extends TestCase{

	Mosquitto mqtt = new Mosquitto("192.168.25.38");
	
	@Test
	public void eviarParametroMosquittoToJava() throws Exception{
		mqtt.getMensagem().setPayload("1".getBytes());
		mqtt.getCliente().publish("contadorDePessoas/entrada", mqtt.getMensagem());
		System.out.println("Quantidade de pessoas na sala: "+mqtt.getContadorDePessoas().getQuantidadeDePessoas());
		
		assertEquals(mqtt.getContadorDePessoas().getQuantidadeDePessoas(), 1);
	}
	
}
