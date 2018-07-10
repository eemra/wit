/**
 * 
 */
package com.whereistango.common.api.serializer;

/**
 * @author resulav
 *
 */
public class JsonDateSerializer {
    //extends JsonSerializer<Date> {
    //
    //    private static final DateFormat DATE_FORMAT;
    //    static {
    //        DATE_FORMAT = Constant.REST_API_DATE_FORMAT;
    //        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    //    }
    //
    //    @Override
    //    public void serialize(Date date, org.codehaus.jackson.JsonGenerator jsonGenerator, SerializerProvider provider) {
    //        try {
    //            jsonGenerator.writeString(DATE_FORMAT.format(date));
    //        } catch (Throwable e) {
    //            throw new CommonException(CommonResultCode.JSON_SERIALIZATION_ERROR, e, "date= " + date);
    //        }
    //    }
}