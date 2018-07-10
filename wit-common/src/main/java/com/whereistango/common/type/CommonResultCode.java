/**
 * 
 */
package com.whereistango.common.type;

import com.whereistango.common.type.impl.ResultCodeImpl;
import com.whereistango.common.type.interfaces.IModule;
import com.whereistango.common.type.interfaces.IResultCode;

/**
 * @author resulav
 *
 */
public enum CommonResultCode implements IResultCode {

    /*
     * GENERAL RESULTs
     */
    SUCCESS(0, "Success", null),
    WARNING(1, "Warning", null),
    INVALID_PARAMETER(2, "Invalid Parameter", null),
    NOT_FOUND(3, "Not Found", null),
    INVALID_RESPONSE(4, "Remote response is invalid", null), //

    /*
     * INTERNAL ERROR
     */
    INVALID_SERVER_ENVORINMENT(100, "Invalid File Path", null),
    INVALID_FILE_PATH(101, "Invalid File Path", null),
    INVALID_CONFIG_PARAMETER(102, "Invalid Configuration Parameter", null),

    JSON_SERIALIZATION_ERROR(150, "Json Serialization Error", null),
    JSON_DESERIALIZATION_ERROR(150, "Json Deserialization Error", null),

    /*
     * 
     */
    MODULE_STARTING_FAILED(200, "Starting Module Failed", null),
    MODULE_ALREADY_STARTED(201, "Module Already Started", null),
    MODULE_NOT_STARTED(202, "Module Not Started", null),
    MODULE_STOPING_FAILED(203, "Stoping Module Failed", null),
    MODULE_ALREADY_STOPPED(204, "Module Already Stopped", null),
    MODULE_NOT_STOPPED(205, "Module Not Stopped", null),

    /*
     * 
     */
    SUBSCRIBER_ALREADY_EXIST(300, "Subscriber Already Exist", null),

    /*
     * 
     */
    SERVER_ERROR(500, "Server Error", null),

    /*
     * REST
     */
    REST_CALL_FAILED(520, "Rest calling is failed", null),
    UNREACABLE_REST_SERVICE(521, "Rest Service is down or unreachable",
            "The rest service can be down. The rest service can be unreachable because of network settings.The rest service HTTP method can be wrong"),
    CONVERT_JSON_TO_OBJECT_FAILED(522, "Converting JSON string to object failed", null), //
    INVALID_REST_CALL_PARAMETER(523, "Invalid Rest Call Parameter", null),

    /*
     * 
     */
    WRITING_ACCESS_LOG_ERROR(540, "Error while writing access log", null),

    /*
     * 
     */
    THREAD_LOCAL_FAILURE(800, "", null),

    //
    ;

    private final IModule        MODULE = Module.COMMON_MODULE;

    private final ResultCodeImpl resultCodeImpl;

    private CommonResultCode(long code, String message, String correction) {
        this.resultCodeImpl = new ResultCodeImpl(code, this.name(), message, correction, MODULE);
    }

    public long getCode() {
        return resultCodeImpl.getCode();
    }

    public String getName() {
        return resultCodeImpl.getName();
    }

    public String getMessage() {
        return resultCodeImpl.getMessage();
    }

    public String getDescription() {
        return resultCodeImpl.getDescription();
    }

    public String getCorrection() {
        return resultCodeImpl.getCorrection();
    }

    public String getShortDescription() {
        return resultCodeImpl.getShortDescription();
    }

    public IModule getModule() {
        return resultCodeImpl.getModule();
    }

}
