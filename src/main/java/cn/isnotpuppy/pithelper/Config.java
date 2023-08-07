package cn.isnotpuppy.pithelper;

public class Config {

    private boolean autoWalkStatus;

    private boolean quickMathStatus;

    public Config(boolean AutoWalk, boolean QuickMath){
        this.autoWalkStatus = AutoWalk;
        this.quickMathStatus = QuickMath;
    }

    public void setAutoWalk(boolean status){
        this.autoWalkStatus = status;
    }

    public void setquickMath(boolean status){
        this.quickMathStatus = status;
    }

    public boolean getAutoWalk(){
        return this.autoWalkStatus;
    }

    public boolean getquickMath(){
        return this.quickMathStatus;
    }

}
