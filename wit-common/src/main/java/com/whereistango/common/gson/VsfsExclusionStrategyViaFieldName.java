package com.whereistango.common.gson;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class VsfsExclusionStrategyViaFieldName implements ExclusionStrategy {

    private Set<String> escapeFiledSet = new HashSet<String>();

    public VsfsExclusionStrategyViaFieldName(String[] escapeFields) {
        if (escapeFields != null && escapeFields.length > 0) {
            for (String string : escapeFields) {
                escapeFiledSet.add(string.trim());
            }
        }

    }

    public boolean shouldSkipField(FieldAttributes f) {
        if (escapeFiledSet.contains(f.getName())) {
            return true;
        }
        return false;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        //            if (clazz.equals(VsfsResponse.class)) {
        //                return true;
        //            }
        return false;
    }

}
