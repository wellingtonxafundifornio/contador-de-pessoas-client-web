package com.softwareltda.peopleCounter.mqtt;

import org.junit.Test;

import com.softwareltda.peopleCounter.mqtt.Mosquitto;

import junit.framework.TestCase;

public class TestConexaoMqtt extends TestCase{
	
	Mosquitto mqtt = new Mosquitto("192.168.25.38");
	
	
	public void testarConexao(){
		assertEquals(mqtt.getCliente().isConnected(), true);
	}
	
	@Test
	public void eviarParametroMosquittoToJava() throws Exception{
		mqtt.getMensagem().setPayload("1".getBytes());
		mqtt.getCliente().publish("contadorDePessoas/entrada", mqtt.getMensagem());
		System.out.println("Quantidade de pessoas na sala: "+mqtt.getContadorDePessoas().getQuantidadeDePessoas());
		
		assertEquals(mqtt.getContadorDePessoas().getQuantidadeDePessoas(), 1);
	}
	
	

}
