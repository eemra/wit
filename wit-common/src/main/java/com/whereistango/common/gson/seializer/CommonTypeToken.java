/**
 * 
 */
package com.whereistango.common.gson.seializer;

import com.google.gson.reflect.TypeToken;

/**
 * @author resulav
 *
 */

public class CommonTypeToken<T> {

    public TypeToken<T> getTypeToken() {
        return new TypeToken<T>() {
        };
    }
}
