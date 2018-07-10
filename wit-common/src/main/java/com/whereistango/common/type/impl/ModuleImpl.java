/**
 * 
 */
package com.whereistango.common.type.impl;

import java.util.HashMap;
import java.util.Map;

import com.whereistango.common.type.interfaces.IModule;

/**
 * @author resulav
 *
 */
public class ModuleImpl implements IModule {

    private final int                          moduleId;
    private final String                       moduleName;
    private final String                       moduleShortName;

    private static final Map<Integer, IModule> ID_MAP   = new HashMap<Integer, IModule>();

    private static final Map<String, IModule>  NAME_MAP = new HashMap<String, IModule>();

    public ModuleImpl(int moduleId, String moduleName, String moduleShortName) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleShortName = moduleShortName;

        IModule iModule = ID_MAP.get(moduleId);
        if (iModule != null) {
            throw new IllegalArgumentException("There is another Module with same ID! Module with id: " + moduleId + " Name: " + moduleName
                    + " is duplicated with id: " + iModule.getModuleId() + " Name: " + iModule.getModuleName());
        }
        ID_MAP.put(moduleId, this);

        iModule = NAME_MAP.get(moduleId);
        if (iModule != null) {
            throw new IllegalArgumentException("There is another Module with same name! Module with id: " + moduleId + " Name: " + moduleName
                    + " is duplicated with id: " + iModule.getModuleId() + " Name: " + iModule.getModuleName());
        }
        NAME_MAP.put(moduleName, this);
    }

    public int getModuleId() {
        return moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModuleShortName() {
        return moduleShortName;
    }

    public IModule getModule(Integer moduleId) {
        return ID_MAP.get(moduleId);
    }

    public IModule getModule(String moduleName) {
        return NAME_MAP.get(moduleName);
    }

}
