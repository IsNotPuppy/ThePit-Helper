package cn.isnotpuppy.pithelper.Module;

import cn.isnotpuppy.pithelper.PitHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class QuickMath {

    Minecraft mc;

    long receiveTime;

    String lastAnswer;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        mc = Minecraft.getMinecraft();
        receiveTime = 0;
        lastAnswer = "";
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        if((!PitHelper.config.getquickMath()) || receiveTime != 0) return;
        String stripped = EnumChatFormatting.getTextWithoutFormattingCodes(event.message.getUnformattedText());
        if(stripped.startsWith("速算! 在聊天栏里写下你的答案: ")){
            String math = stripped.replace("速算! 在聊天栏里写下你的答案: ","");
            String[] plus = math.split("\\+");
            String[] minus = math.split("-");
            String[] times = math.split("x");
            String answer = "";
            if(plus.length == 2){
                answer = Integer.toString(parseInt(plus[0]) + parseInt(plus[1]));
            }else if(minus.length == 2){
                answer = Integer.toString(parseInt(minus[0]) - parseInt(minus[1]));
            }else if(times.length == 2){
                answer = Integer.toString(parseInt(times[0]) * parseInt(times[1]));
            }
            if(!answer.equals("")){
                receiveTime = System.currentTimeMillis();
                lastAnswer = answer;
            }else{
                PitHelper.logger.warn("--------- ThePit-Helper ---------");
                PitHelper.logger.warn("Math : " + math);
                PitHelper.logger.warn("Plus : " + Arrays.toString(plus));
                PitHelper.logger.warn("Minus : " + Arrays.toString(minus));
                PitHelper.logger.warn("Times : " + Arrays.toString(times));
                PitHelper.logger.warn("Answer : " + answer);
                PitHelper.modMessage("算式错误！请附上latest.log反馈此bug给" + PitHelper.author);
            }

        }
    }

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent e){
        if(receiveTime != 0)
            if(System.currentTimeMillis() - receiveTime >= 2300){
                receiveTime = 0;
                mc.thePlayer.sendChatMessage(lastAnswer);
            }

    }

}
