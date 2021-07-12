package me.kingili.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class HelpCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "kinghelp";
    }
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "kinghelp";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§b§l§nHelp Menu\n\n" + "§1§l/kinghelp§r §0- §r §d§bSends this message in the chat!\n"));
    }
}
