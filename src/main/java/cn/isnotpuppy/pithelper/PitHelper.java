package cn.isnotpuppy.pithelper;

import cn.isnotpuppy.pithelper.Command.commandAutoBot;
import cn.isnotpuppy.pithelper.Command.commandAutoWalk;
import cn.isnotpuppy.pithelper.Command.commandQuickMath;
import cn.isnotpuppy.pithelper.Module.AutoBot;
import cn.isnotpuppy.pithelper.Module.AutoWalk;
import cn.isnotpuppy.pithelper.Module.QuickMath;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = PitHelper.MODID, version = PitHelper.VERSION)
public class PitHelper {
    public static final String MODID = "pithelper";
    public static final String VERSION = "1.0";
    public static final String author = "IsNotPuppy";
    public static final Minecraft mc  = Minecraft.getMinecraft();
    public static final Logger logger = LogManager.getLogger();
    public static Config config;
    public QuickMath quickMath;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        new eventLoader();
        quickMath = new QuickMath();
        config = new Config(false,false,false);
        quickMath.init(event);
        ClientCommandHandler.instance.registerCommand(new commandAutoWalk());
        ClientCommandHandler.instance.registerCommand(new commandQuickMath());
        ClientCommandHandler.instance.registerCommand(new commandAutoBot());
        logger.info("ThePit-Helper Mod Loaded!");
        logger.info("Subscribe me on bilibili @IsNotPuppy :)");
    }

    public static void modMessage(String text){
        mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[" + EnumChatFormatting.WHITE + "PitHelper" +
                EnumChatFormatting.RED + "] " + EnumChatFormatting.WHITE + text));
    }

}
