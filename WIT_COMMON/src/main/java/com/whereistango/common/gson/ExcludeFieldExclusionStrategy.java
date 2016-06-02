package com.whereistango.common.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.whereistango.common.annotation.ExcludeField;

public class ExcludeFieldExclusionStrategy implements ExclusionStrategy {

    public boolean shouldSkipField(FieldAttributes f) {
        ExcludeField excludeField = f.getAnnotation(ExcludeField.class);
        if (excludeField != null) {
            return true;
        }

        return false;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

}
