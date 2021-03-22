package th.co.inquiry.core.utils.converter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomDateTimeDeserializer extends JsonDeserializer<Date> {

	Logger logger = LoggerFactory.getLogger(CustomDateTimeDeserializer.class);
	
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		Date result = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("en", "EN"));
			if (node.asText() != null && node.asText().length() > 0) {
				result = (Date) dateFormat.parseObject(node.asText());
			}
		} catch (ParseException e) {
			logger.error("Can't parse " + node.asText() + " to Date()", e);
		}
		return result;
	}

}
