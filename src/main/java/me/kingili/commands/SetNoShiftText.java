package me.kingili.commands;

import me.kingili.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SetText extends CommandBase implements ICommand{

    @Override
    public String getCommandName() {
        return "SetShiftText";
    }

    @Override
    public String getCommandUsage(ICommandSender arg0) {
        return "/" + getCommandName() + " <key>";
    }

    public static String usage(ICommandSender arg0) {
        return new SetText().getCommandUsage(arg0);
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
        final EntityPlayer player = (EntityPlayer)arg0;

        if (arg1.length == 0) {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: " + getCommandUsage(arg0)));
            return;
        }

        Config.ConfigHandler.writeStringConfig("shifttxt", "shifttxtnoshift", arg1[0]);
        player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Set Text" + EnumChatFormatting.AQUA + " " + arg1[0]));
    }
}
