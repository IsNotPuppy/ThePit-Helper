package cn.isnotpuppy.pithelper.Command;

import cn.isnotpuppy.pithelper.PitHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class commandAutoWalk implements ICommand {

    Minecraft mc = Minecraft.getMinecraft();

    private final List<String> aliases;

    public commandAutoWalk(){
        aliases = new ArrayList<String>();
        aliases.add("autowalk");
        aliases.add("aw");
    }

    @Override
    public String getCommandName() {
        return "autowalk";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "autowalk";
    }

    @Override
    public List<String> getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if(PitHelper.config.getAutoWalk())
            PitHelper.modMessage("已成功关闭 " + EnumChatFormatting.RED + "AutoWalk !");
        else
            PitHelper.modMessage("已成功开启 " + EnumChatFormatting.RED + "AutoWalk !");
        PitHelper.config.setAutoWalk(!PitHelper.config.getAutoWalk());
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] strings, BlockPos blockPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
