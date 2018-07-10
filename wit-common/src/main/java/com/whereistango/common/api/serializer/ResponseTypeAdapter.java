/**
 * 
 */
package com.whereistango.common.api.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.whereistango.common.constant.Constant;
import com.whereistango.common.exception.CommonException;
import com.whereistango.common.gson.GsonUtility;
import com.whereistango.common.model.Response;
import com.whereistango.common.type.CommonResultCode;

/**
 * @author resulav
 *
 */
public class ResponseTypeAdapter<T> implements JsonDeserializer<Response<T>> {

    public synchronized Response<T> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            return GsonUtility.getGson().fromJson(jsonElement.getAsString(), type);
        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.JSON_DESERIALIZATION_ERROR, e, (jsonElement != null ? jsonElement.getAsString() : null)
                    + " not a date or not formatable text with " + Constant.REST_API_DATE_FORMAT_TEXT);
        }
    }
}
