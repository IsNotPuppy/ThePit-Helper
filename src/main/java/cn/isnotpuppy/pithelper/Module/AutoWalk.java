package cn.isnotpuppy.pithelper.Module;

import cn.isnotpuppy.pithelper.PitHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoWalk {
    public static void autoWalk(Minecraft mc){
        if(PitHelper.config.getAutoWalk()){
            if(mc.currentScreen == null)
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(),true);
            else
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(),false);
        }
    }
}
