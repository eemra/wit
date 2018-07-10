/**
 * 
 */
package com.whereistango.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whereistango.common.type.interfaces.IModule;
import com.whereistango.common.type.interfaces.IResultCode;

/**
 * @author resulav
 *
 */
public class ResultCodeUtility {

    public static final int  RESULT_CODE_LENGTH = 4;
    public static final int  MODULE_CODE_LENGTH = 2;

    public static final long RESULT_CODE_MULTIPLIER;

    static {
        long scale = 1;
        for (int i = 0; i < RESULT_CODE_LENGTH; i++) {
            scale = scale * 10;
        }
        RESULT_CODE_MULTIPLIER = scale;
    }

    private static final Map<Long, IResultCode> RESULT_CODE_TO_I_RESULT_CODE_MAP = new HashMap<Long, IResultCode>();

    private static final String                 SEPERATOR_FIELD                  = ": ";
    private static final String                 SEPERATOR_HASH                   = "-";
    private static final String                 RESULT_CODE_PREFIX               = "RESULT_CODE" + SEPERATOR_HASH;

    private static final String                 TAB                              = "\t\t";
    private static final String                 NEW_LINE                         = "\n";

    public static String toShortDescription(IResultCode resultCode) {
        StringBuilder sb = new StringBuilder(resultCode.getName()).append(SEPERATOR_FIELD).append(RESULT_CODE_PREFIX).append(getFormattedResultCode(
                                                                                                                                                    resultCode
                                                                                                                                                            .getCode()))
                .append(SEPERATOR_FIELD).append(resultCode.getMessage()).append(" (").append(resultCode.getModule().getModuleShortName()
                        .toUpperCase()).append(SEPERATOR_HASH).append(getFormattedResultCode(resultCode.getCode())).append(")");
        return sb.toString();
    }

    private static String getFormattedResultCode(Long resultCode) {
        if (resultCode == null) {
            throw new IllegalArgumentException("resultCode is null");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(resultCode);

        while (sb.length() < RESULT_CODE_LENGTH + MODULE_CODE_LENGTH) {
            sb.insert(0, "0");
        }

        return sb.toString();
    }

    public static String toString(IResultCode resultCode) {
        StringBuilder sb = new StringBuilder(resultCode.getShortDescription()).append(NEW_LINE);

        if (resultCode.getCorrection() != null) {
            sb.append(TAB).append("Correction: ").append(resultCode.getCorrection()).append(NEW_LINE);
        }

        sb.append(TAB).append("Module Id").append(SEPERATOR_FIELD).append(resultCode.getModule().getModuleId()).append(" Name").append(
                                                                                                                                       SEPERATOR_FIELD)
                .append(resultCode.getModule().getModuleName());

        return sb.toString();
    }

    public static String prepareErrorMessage(IResultCode resultCode, Throwable throwable, IModule module, String... additionalInfo) {
        StringBuilder sb = new StringBuilder(resultCode.getDescription()).append(NEW_LINE);

        if (module != null && resultCode.getModule() != null && module.equals(resultCode.getModule()) == false) {
            sb.append(TAB).append("Error Owner Module Id").append(SEPERATOR_FIELD).append(module.getModuleId()).append(" Name").append(
                                                                                                                                       SEPERATOR_FIELD)
                    .append(module.getModuleName()).append(NEW_LINE);
        }

        if (additionalInfo != null && additionalInfo.length > 0) {
            for (String info : additionalInfo) {
                if (info != null) {
                    sb.append(TAB).append("Additional Info").append(SEPERATOR_FIELD).append(info).append(NEW_LINE);
                }
            }
        }

        if (throwable != null) {
            sb.append(getCauseText(throwable));
        }

        return sb.toString();
    }

    private static String getCauseText(Throwable throwable) {
        StringBuilder sb = new StringBuilder();

        String rootCauseMessage = getRootCauseMessage(throwable);

        if (rootCauseMessage != null) {
            sb.append(TAB).append("Root Cause").append(SEPERATOR_FIELD).append(rootCauseMessage.replace(TAB, TAB + ">>"));
        }

        return sb.toString();
    }

    private static String getRootCauseMessage(Throwable throwable) {
        if (throwable.getCause() != null) {
            return getRootCauseMessage(throwable.getCause());
        }

        return throwable.toString();
    }

    public static String prepareErrorMessage2(IResultCode resultCode, Throwable throwable, IModule module, String... additionalInfo) {
        StringBuilder sb = new StringBuilder(resultCode.getDescription()).append(NEW_LINE);

        if (module != null && resultCode.getModule() != null && module.equals(resultCode.getModule()) == false) {
            sb.append(TAB).append("Error Owner Module Id").append(SEPERATOR_FIELD).append(module.getModuleId()).append(" Name").append(
                                                                                                                                       SEPERATOR_FIELD)
                    .append(module.getModuleName()).append(NEW_LINE);
        }

        if (additionalInfo != null && additionalInfo.length > 0) {
            for (String info : additionalInfo) {
                if (info != null) {
                    sb.append(TAB).append("Additional Info").append(SEPERATOR_FIELD).append(info).append(NEW_LINE);
                }
            }
        }

        if (throwable != null) {

            List<Throwable> throwables = getCauses(throwable);
            if (throwables != null && throwables.size() > 0) {
                for (Throwable t : throwables) {
                    sb.append(TAB).append("Root Cause").append(SEPERATOR_FIELD).append(t.getMessage().replace(TAB, TAB + ">>"));
                }
            }
        }

        return sb.toString();
    }

    private static List<Throwable> getCauses(Throwable throwable) {

        List<Throwable> throwables = new ArrayList<Throwable>();

        if (throwable.getCause() != null) {
            throwables.addAll(getCauses(throwable.getCause()));
        }

        throwables.add(throwable);

        return throwables;

    }

    public static void validate(IResultCode iResultCode) {

        IResultCode duplicatedResultCode = RESULT_CODE_TO_I_RESULT_CODE_MAP.get(iResultCode.getCode());

        if (duplicatedResultCode != null) {
            throw new IllegalArgumentException("There is another ResultCode with same resultCode! ResultCode with Code: " + iResultCode.getCode()
                    + " Name: " + iResultCode.getName() + " is duplicated with Code: " + duplicatedResultCode.getCode() + " Name: "
                    + duplicatedResultCode.getName());

        }

        RESULT_CODE_TO_I_RESULT_CODE_MAP.put(iResultCode.getCode(), iResultCode);
    }

    private static void putToMap(IResultCode iResultCode) {
        if (RESULT_CODE_TO_I_RESULT_CODE_MAP.get(iResultCode.getCode()) == null) {
            RESULT_CODE_TO_I_RESULT_CODE_MAP.put(iResultCode.getCode(), iResultCode);
        }
    }

    /**
     * Use this method
     * 
     * @param resultCode
     * @param resultMessage
     * @param module
     * @return
     */
    public static IResultCode getResultCode(final String responseShortDescription) {

        String shortDescription = responseShortDescription;

        String[] array = shortDescription.split(SEPERATOR_FIELD);
        if (array.length != 3) {
            throw new IllegalArgumentException(
                    "responseShortDescription format is <error_name>: VSFS-<module_id><error_code>: <error_description>. Inconsistent format for "
                            + responseShortDescription);
        }
        final String name = array[0];

        shortDescription = shortDescription.substring(shortDescription.indexOf(RESULT_CODE_PREFIX) + RESULT_CODE_PREFIX.length()); //  replace(array[0], "").replace(RESULT_CODE_PREFIX, "");

        if (shortDescription.length() == responseShortDescription.length()) {
            throw new IllegalArgumentException(
                    "responseShortDescription format is <error_name>: VSFS-<module_id><error_code>: <error_description>. Inconsistent format for "
                            + responseShortDescription);
        }

        array = shortDescription.split(SEPERATOR_FIELD);

        if (array.length != 2) {
            throw new IllegalArgumentException(
                    "responseShortDescription format is <error_name>: VSFS-<module_id><error_code>: <error_description>. Inconsistent format for "
                            + responseShortDescription);
        }

        String _resultCode = array[0];

        if (_resultCode == null || _resultCode.length() != (RESULT_CODE_LENGTH + MODULE_CODE_LENGTH)) {
            throw new IllegalArgumentException("result code length is mismatched for  " + responseShortDescription + " (resultCode:" + _resultCode
                    + ")");
        }

        final Long resultCode = Long.parseLong(_resultCode);

        IResultCode iResultCode = RESULT_CODE_TO_I_RESULT_CODE_MAP.get(resultCode);
        if (iResultCode != null) {
            return iResultCode;
        }

        String _modeleId = array[0].substring(0, 2);
        if (_modeleId == null || _modeleId.length() != (MODULE_CODE_LENGTH)) {
            throw new IllegalArgumentException("module id length is mismatched for  " + responseShortDescription + " (modeuleId:" + _modeleId + ")");
        }

        final IModule module = null;
        //        = ModuleImpl.toModuleTypeFromStr(_modeleId);

        final String resultMessage = array[1];

        iResultCode = new IResultCode() {

            public long getCode() {
                return resultCode;
            }

            public String getMessage() {
                return resultMessage;
            }

            public String getName() {
                return name;
            }

            public String getCorrection() {
                return null;
            }

            public String getShortDescription() {
                return responseShortDescription;
            }

            public IModule getModule() {
                return module;
            }

            public String getDescription() {
                return ResultCodeUtility.toString(this);
            }

            //            @Override
            //            public String getResultName() {
            //                return name;
            //            }
            //
            //            @Override
            //            public String getResultMessage() {
            //                return resultMessage;
            //            }
            //
            //            @Override
            //            public long getResultCode() {
            //                return resultCode;
            //            }
            //
            //            @Override
            //            public ModuleTypesEnum getModule() {
            //                return module;
            //            }
            //
            //            @Override
            //            public String getDescription() {
            //                return iResultCodeHelper.toString(this);
            //            }
            //
            //            @Override
            //            public String getCorrection() {
            //                return null;
            //            }
            //
            //            @Override
            //            public String getShortDescription() {
            //                return responseShortDescription;
            //            }

        };

        putToMap(iResultCode);

        return iResultCode;
    }

    //    
}
