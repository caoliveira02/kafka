package service;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import model.Vendas;
import serializer.VendaSerializer;

public class GeradorVenda {

	private static Random rand = new Random();
	private static long operacao = 0;
	private static BigDecimal valorImpresso = BigDecimal.valueOf(500);
	
	public static void main(String[] args) throws InterruptedException {
		
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());
		
		try(KafkaProducer<String, Vendas> producer = new KafkaProducer<String, Vendas>(properties)){
			while(true) {
				Vendas venda = geravenda();
				ProducerRecord<String, Vendas> record = new ProducerRecord<String, Vendas>("venda-ingressos", venda);
				producer.send(record);
				Thread.sleep(200);
			}
		}
	}

	private static Vendas geravenda() {
		
		long cliente = rand.nextLong();
		int qtdIngressos = rand.nextInt(10);
		
		return new Vendas(operacao++, cliente, qtdIngressos, valorImpresso.multiply(BigDecimal.valueOf(qtdIngressos)));
	}
}
