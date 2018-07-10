/**
 * 
 */
package com.whereistango.common.gson;

import java.util.Date;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.whereistango.common.api.serializer.DateTypeAdapter;

/**
 * @author resulav
 *
 */
public class GsonUtility {

    private final static class GsonBuilderHolder {

        private final static GsonBuilder GSON_BUILDER = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter());
    }

    public final static Gson getGson() {
        return GsonBuilderHolder.GSON_BUILDER.create();
    }

    public final static Gson getGson(String... escapeFields) {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).setExclusionStrategies(
                                                                                                                                  new VsfsExclusionStrategyViaFieldName(
                                                                                                                                          escapeFields));

        return gsonBuilder.create();
    }

    public final static Gson getGsonForExcludeField() {
        return getGson(new ExcludeFieldExclusionStrategy());
    }

    public final static Gson getGson(ExclusionStrategy exclusionStrategy) {
        return new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).setExclusionStrategies(exclusionStrategy).create();
    }

    //    public static void main(String[] args) {
    //
    //        VsfsResponse<?> vsfsResponse = VsfsResponse.newSuccess("Test");
    //
    //        System.out.println(getGson().toJson(vsfsResponse));
    //        System.out.println();
    //        System.out.println(getGson("data").toJson(vsfsResponse));
    //        System.out.println();
    //        System.out.println(getGsonForExclution().toJson(vsfsResponse));
    //
    //    }

}
