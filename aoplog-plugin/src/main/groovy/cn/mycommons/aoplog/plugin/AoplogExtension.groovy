package cn.mycommons.aoplog.plugin

class AoplogExtension {

    def enabled = true

    def setEnabled(boolean enabled) {
        this.enabled = enabled
    }

    def getEnabled() {
        return enabled;
    }
}