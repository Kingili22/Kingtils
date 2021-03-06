package me.kingili.commands;

import me.kingili.config.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SetNoShiftText extends CommandBase implements ICommand{

    @Override
    public String getCommandName() {
        return "SetNoShiftText";
    }

    @Override
    public String getCommandUsage(ICommandSender arg0) {
        return "/" + getCommandName() + " <key>";
    }

    public static String usage(ICommandSender arg0) {
        return new SetNoShiftText().getCommandUsage(arg0);
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
        final EntityPlayer player = (EntityPlayer)arg0;

        if (arg1.length == 0) {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: " + getCommandUsage(arg0)));
            return;
        }

        Config.ConfigHandler.writeStringConfig("shiftinfo", "shifttxtnoshift", arg1[0]);
        player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Set Text" + EnumChatFormatting.AQUA + " " + arg1[0]));
    }
}
