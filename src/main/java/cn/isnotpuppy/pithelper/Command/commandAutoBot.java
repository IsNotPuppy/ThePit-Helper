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

public class commandAutoBot implements ICommand {

    Minecraft mc = Minecraft.getMinecraft();

    private final List<String> aliases;

    public commandAutoBot(){
        aliases = new ArrayList<String>();
        aliases.add("autobot");
        aliases.add("ab");
    }

    @Override
    public String getCommandName() {
        return "autobot";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "autobot";
    }

    @Override
    public List<String> getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if(PitHelper.config.getAutoWalk())
            PitHelper.modMessage("已成功关闭 " + EnumChatFormatting.RED + "autobot !");
        else
            PitHelper.modMessage("已成功开启 " + EnumChatFormatting.RED + "autobot !");
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
