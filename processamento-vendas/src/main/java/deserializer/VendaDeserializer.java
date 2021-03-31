package deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Vendas;

public class VendaDeserializer implements Deserializer<Vendas>{

	@Override
	public Vendas deserialize(String topic, byte[] vendas) {
		try {
			return new ObjectMapper().readValue(vendas, Vendas.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
