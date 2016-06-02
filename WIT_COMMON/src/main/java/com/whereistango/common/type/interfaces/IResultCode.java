/**
 * 
 */
package com.whereistango.common.type.interfaces;

/**
 * @author resulav
 *
 */
public interface IResultCode {

    /**
     * resultCode equals to id.
     * 
     * @return resultCode of ResultDef
     */
    public long getCode();

    /**
     * @return resultMessage of ResultDef
     */
    public String getMessage();

    /**
     * @return resultName of ResultDef
     */
    public String getName();

    /**
     * @return Returns possible correction of the error, if the error has a solution.
     */
    public String getCorrection();

    /**
     * @return description of ResultDef
     */
    public String getDescription();

    /**
     * @return short description of ResultDef
     */
    public String getShortDescription();

    /**
     * @return ResultDef owner
     */
    public IModule getModule();

}
