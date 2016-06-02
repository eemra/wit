/**
 * 
 */
package com.whereistango.common.api.serializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.whereistango.common.constant.Constant;
import com.whereistango.common.exception.CommonException;
import com.whereistango.common.type.CommonResultCode;

/**
 * @author resulav
 *
 */
public class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private static final DateFormat DATE_FORMAT;
    static {
        DATE_FORMAT = Constant.REST_API_DATE_FORMAT;
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public synchronized JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(DATE_FORMAT.format(date));
    }

    public synchronized Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            return DATE_FORMAT.parse(jsonElement.getAsString());
        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.JSON_DESERIALIZATION_ERROR, e, (jsonElement != null ? jsonElement.getAsString() : null)
                    + " not a date or not formatable text with " + Constant.REST_API_DATE_FORMAT_TEXT);
        }
    }
}
