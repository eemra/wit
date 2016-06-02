/**
 * 
 */
package com.whereistango.common.type.impl;

import com.whereistango.common.type.interfaces.IModule;
import com.whereistango.common.type.interfaces.IResultCode;
import com.whereistango.common.util.ResultCodeUtility;

/**
 * @author resulav
 *
 */
public class ResultCodeImpl implements IResultCode {

    private final long    code;
    private final String  message;
    private final String  correction;

    private final String  name;
    private final String  shortDescription;
    private final String  description;

    private final IModule module;

    public ResultCodeImpl(long code, String name, String message, String correction, IModule module) {
        this.code = ResultCodeUtility.RESULT_CODE_MULTIPLIER * module.getModuleId() + code;
        this.correction = correction;
        this.name = name;
        this.module = module;
        this.message = message;

        this.shortDescription = ResultCodeUtility.toShortDescription(this);
        this.description = ResultCodeUtility.toString(this);
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getCorrection() {
        return correction;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public IModule getModule() {
        return module;
    }

}
