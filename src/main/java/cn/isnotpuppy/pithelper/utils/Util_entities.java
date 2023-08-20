package cn.isnotpuppy.pithelper.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import static cn.isnotpuppy.pithelper.PitHelper.mc;

public class Util_entities {
    public static Entity getTargets(long reach) {

        Entity targets = null;
        for (Entity ent : mc.theWorld.loadedEntityList) {
            if (ent instanceof EntityLivingBase) {
                if (!ent.isDead &&  ((EntityLivingBase) ent).getHealth() > 0 && ent != mc.thePlayer && ent.getDistanceToEntity(mc.thePlayer) < reach){
                    targets = mc.theWorld.playerEntities.iterator().next();
                }
            }
        }
        return targets;
        //return targets;
    }
    public static float[] getRotations(Entity e) {
        double deltaX = e.posX + (e.posX - e.lastTickPosX) - mc.thePlayer.posX;
        double deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ;
        double deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight();
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaZ, 2));

        float yaw = (float) Math.toDegrees(-Math.atan(deltaX / deltaZ));
        float pitch = (float) -Math.toDegrees(Math.atan(deltaY/distance));

        if(deltaX < 0 && deltaZ < 0)
            yaw = (float) (90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
        else if (deltaX > 0 && deltaZ < 0)
            yaw = (float) (-90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));

        return new float[] {yaw, pitch};
    }

    public static double getPlayerY(){
        return Minecraft.getMinecraft().thePlayer.posY;
    }
}
