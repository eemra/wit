/**
 * 
 */
package com.whereistango.common.type;

import com.whereistango.common.type.impl.ModuleImpl;
import com.whereistango.common.type.interfaces.IModule;

/**
 * @author resulav
 *
 */
public enum Module implements IModule {

    UNKNOWN(-1, "Unknown", "un"),
    COMMON_MODULE(0, "Common", "com"),
    //
    ;

    private final ModuleImpl moduleImpl;

    private Module(int moduleId, String moduleName, String moduleShortName) {
        this.moduleImpl = new ModuleImpl(moduleId, moduleName, moduleShortName);
    }

    public int getModuleId() {
        return moduleImpl.getModuleId();
    }

    public String getModuleName() {
        return moduleImpl.getModuleName();
    }

    public String getModuleShortName() {
        return moduleImpl.getModuleShortName();
    }

    //    public static IModule getModule(Integer moduleId) {
    //        return moduleImpl.getModule(moduleId);
    //    }
    //
    //    public static IModule getModule(String moduleName) {
    //        return NAME_MAP.get(moduleName);
    //    }

}
