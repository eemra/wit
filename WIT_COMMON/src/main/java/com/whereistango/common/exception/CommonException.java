package com.whereistango.common.exception;

import java.lang.reflect.InvocationTargetException;

import javax.ejb.ApplicationException;

import com.whereistango.common.type.Module;
import com.whereistango.common.type.interfaces.IModule;
import com.whereistango.common.type.interfaces.IResultCode;
import com.whereistango.common.util.ResultCodeUtility;

@ApplicationException(rollback = true, inherited = false)
public class CommonException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Exception Definition
     */
    private final IResultCode resultCode;

    /**
     * Error Additional Info
     */
    private final String[]    additionalInfo;

    /**
     * Exception owner
     */
    private final IModule     module;

    /**
     * 
     */
    public CommonException(IResultCode resultCode) {
        this(resultCode, null, Module.COMMON_MODULE);
    }

    /**
     * 
     */
    public CommonException(IResultCode resultCode, String... additionalInfo) {
        this(resultCode, null, Module.COMMON_MODULE, additionalInfo);
    }

    /**
     * 
     */
    public CommonException(IResultCode resultCode, Throwable throwable) {
        this(resultCode, throwable, Module.COMMON_MODULE);
    }

    /**
     * 
     */
    public CommonException(IResultCode resultCode, Throwable throwable, String... additionalInfo) {
        this(resultCode, throwable, Module.COMMON_MODULE, additionalInfo);
    }

    /**
     * 
     */
    public CommonException(IResultCode resultCode, Throwable throwable, IModule module, String... additionalInfo) {
        super(ResultCodeUtility.prepareErrorMessage(resultCode, throwable, module, additionalInfo), throwable);
        this.resultCode = resultCode;
        this.additionalInfo = additionalInfo;
        this.module = module;
    }

    /**
     * 
     */
    public CommonException(IResultCode resultCode, Throwable throwable, boolean enableSuppression, boolean writableStackTrace, IModule module,
                           String... additionalInfo) {
        super(ResultCodeUtility.prepareErrorMessage(resultCode, throwable, module, additionalInfo), throwable, enableSuppression, writableStackTrace);
        this.resultCode = resultCode;
        this.additionalInfo = additionalInfo;
        this.module = module;
    }

    public IResultCode getResultCode() {
        return resultCode;
    }

    public String[] getAdditionalInfo() {
        return additionalInfo;
    }

    public IModule getModule() {
        return module;
    }

    public <T extends CommonException> T convert(final Class<T> convertKlazz) throws InstantiationException, IllegalAccessException,
        IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        return convertKlazz.getConstructor(IResultCode.class, Throwable.class, IModule.class, String[].class).newInstance(this.getResultCode(), this
                .getCause(), this.getModule(), this.getAdditionalInfo());
    }

    public static <K extends CommonException, T extends CommonException> T convert(K src, final Class<T> convertKlazz) throws InstantiationException,
        IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        return src.convert(convertKlazz);
    }

    public static <T extends CommonException> T convert(IResultCode resultCode, final Class<T> convertKlazz) throws InstantiationException,
        IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        return convertKlazz.getConstructor(IResultCode.class).newInstance(resultCode);
    }

}
