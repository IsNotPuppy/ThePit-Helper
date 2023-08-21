package cn.isnotpuppy.pithelper.Module;

import cn.isnotpuppy.pithelper.PitHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

import static cn.isnotpuppy.pithelper.utils.Util_entities.rotations;

public class AutoBot {
    static Minecraft mc = Minecraft.getMinecraft();
    public static void autoBot() {
        //init coordinate
        double playerY = Minecraft.getMinecraft().thePlayer.posY;
        //Get the Y coordinate of the player to judge whether it is at the spawn point

        //y>70 do walk forward
        //            doWalkForward(true);
        //Y<70 do auto bot
        //            doWalkForward(true);
        doAutoBot(PitHelper.config.getAutoBot());

    }

    private static void doAutoBot(boolean status) {
        EntityPlayer targetPlayer = testTarget();
        //walk
        if (status) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(),true);
            if(targetPlayer != null && Minecraft.getMinecraft().thePlayer.posY < 70){
                mc.thePlayer.rotationYaw = rotations(targetPlayer)[0] / 2;
                mc.thePlayer.rotationPitch = rotations(targetPlayer)[1] / 2;
            }
        }else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(),false);
        }

    }

    private static EntityPlayer testTarget(){
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer target = mc.theWorld.playerEntities.stream().filter(entityPlayer -> entityPlayer != mc.thePlayer).min(Comparator.comparing(entityPlayer ->
                entityPlayer.getDistanceToEntity(mc.thePlayer))).filter(entityPlayer -> entityPlayer.getDistanceToEntity(mc.thePlayer) <= 10).orElse(null);
        return target;
    }

}
