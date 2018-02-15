package th.co.maximus.core.utils.converter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomEndDateDeserializer extends JsonDeserializer<Date> {
	Logger logger = LoggerFactory.getLogger(CustomEndDateDeserializer.class);

	FastDateFormat dateFormat = FastDateFormat.getInstance("dd/MM/yyyy HH:mm:ss.SSS", Locale.ENGLISH);

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		Date result = null;
		try {
			if (StringUtils.isNotEmpty(node.asText())) {
				Date refDate = dateFormat.parse(node.asText() + " 23:59:59.999");
				result = new Date(refDate.getTime());
			}
		} catch (ParseException e) {
			logger.error("Can't parse " + node.asText() + " to java.util.Date()", e);
		}
		return result;
	}
}
