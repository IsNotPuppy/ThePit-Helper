package cn.isnotpuppy.pithelper;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;

import java.io.Console;

import static cn.isnotpuppy.pithelper.Module.AutoBot.autoBot;
import static cn.isnotpuppy.pithelper.Module.AutoWalk.autoWalk;
import static java.lang.Integer.parseInt;

public class eventLoader {
    static Minecraft mc;
    static long receiveTime;

    static String lastAnswer;
    public eventLoader(){
        //register
        MinecraftForge.EVENT_BUS.register(this);
        //Initialize variables

    }

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent e){
        //subscribe ClientTickEvent
        mc = Minecraft.getMinecraft();
        // do autoWalk function
        autoWalk(mc);

        //do sendAnswer

    }

    @SubscribeEvent
    public void test(EntityEvent event) {
        if (mc.thePlayer != null){
            autoBot();
        }
    }

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {

    }





}
