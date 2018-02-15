package th.co.maximus.core.utils.converter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

	Logger logger = LoggerFactory.getLogger(CustomDateSerializer.class);

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		Date result = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
			if (StringUtils.isNotEmpty(node.asText())) {
				Date refDate = (Date) dateFormat.parse(node.asText());
				result = new Date(refDate.getTime());
			}
		} catch (ParseException e) {
			logger.error("Can't parse " + node.asText() + " to java.util.Date()", e);
		}
		return result;
	}

}
