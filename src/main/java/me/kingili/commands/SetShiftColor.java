package me.kingili.commands;

import me.kingili.config.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SetShiftColor extends CommandBase implements ICommand {
    @Override
    public String getCommandName() {
        return "SetShiftColor";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName() + " <key>";
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
        final EntityPlayer player = (EntityPlayer) arg0;

        if (arg1.length == 0) {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: " + getCommandUsage(arg0)));
            return;
        }
        Integer color = 0;
        try {
            color = parseInt(arg1[0]);
        } catch(NumberFormatException error){
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You Must Give an Integer for your argument!"));
            return;
        }
        Config.ConfigHandler.writeIntConfig("shiftinfo", "shiftcolor", color);
    }
}
