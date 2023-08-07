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

    static Minecraft mc;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        mc = Minecraft.getMinecraft();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent e){
        if(PitHelper.config.getAutoWalk()){
            if(mc.currentScreen == null)
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(),true);
            else
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(),false);
        }

    }
}
