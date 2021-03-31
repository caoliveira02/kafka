package serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Vendas;

public class VendaSerializer implements Serializer<Vendas> {

	@Override
	public byte[] serialize(String topic, Vendas venda) {
	
		try {
			return new ObjectMapper().writeValueAsBytes(venda);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
