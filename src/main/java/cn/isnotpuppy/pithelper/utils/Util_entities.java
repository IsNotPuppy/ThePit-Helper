package cn.isnotpuppy.pithelper.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;



public class Util_entities {
    static Minecraft mc = Minecraft.getMinecraft();
    public static float[] rotations(EntityPlayer entity) {
        double x = entity.posX - mc.thePlayer.posX;
        double y = entity.posY - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight()) + 1.5;
        double z = entity.posZ - mc.thePlayer.posZ;

        double u = Math.sqrt(x * x + z * z);

        float u2 = (float) (Math.atan2(z, x) * (180D / Math.PI) - 90.0F);
        float u3 = (float) (-Math.atan2(y, u) * (180D / Math.PI));

        return new float[]{u2, u3};
    }
}
