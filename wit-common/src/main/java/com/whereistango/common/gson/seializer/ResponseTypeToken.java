/**
 * 
 */
package com.whereistango.common.gson.seializer;

import com.google.gson.reflect.TypeToken;
import com.whereistango.common.model.Response;

/**
 * @author resulav
 *
 */
public class ResponseTypeToken<T> {

    public TypeToken<Response<T>> getTypeToken() {
        return new TypeToken<Response<T>>() {
        };
    }
}
