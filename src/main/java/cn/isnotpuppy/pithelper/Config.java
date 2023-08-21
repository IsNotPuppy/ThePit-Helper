package cn.isnotpuppy.pithelper;

public class Config {

    private boolean autoWalkStatus;

    private boolean quickMathStatus;

    private boolean autoBotStatus;

    public Config(boolean AutoWalk, boolean QuickMath, boolean AutoBot){
        this.autoWalkStatus = AutoWalk;
        this.autoWalkStatus = AutoBot;
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
    public void setAutoBot(boolean status){
        this.autoBotStatus = status;
    }
    public boolean getAutoBot(){
        return this.autoBotStatus;
    }

}
