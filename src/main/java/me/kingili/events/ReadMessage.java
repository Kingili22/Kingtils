package me.kingili.main;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ReadMessage {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String unformattedText = event.message.getUnformattedText();
        String CleanText = StringUtils.stripControlCodes(unformattedText);
        if (CleanText.contains(":")) {
            String[] parsedText = CleanText.split(": ");
            String unformattedMSG = parsedText[1].trim();
            System.out.println(unformattedMSG);
            if (unformattedMSG.equals("Hello")) {
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Hello World"));
            }
        }

    }
}