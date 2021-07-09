package me.kingili.main;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class readMessage {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String unformattedText = event.message.getUnformattedText();
        if (unformattedText.contentEquals("hello world")) {
            Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("This is only being sent to the player"));
        }
    }
}