package me.kingili.render;

import me.kingili.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class ShiftRender {
    @SubscribeEvent
public void RenderText(final RenderGameOverlayEvent event) throws IOException {
            if (event.type != RenderGameOverlayEvent.ElementType.TEXT || event.isCancelable()) {
                return;
            }
            if ((Minecraft.getMinecraft().currentScreen != null &&
                    !Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) ||
                    Minecraft.getMinecraft().gameSettings.showDebugInfo) {
                return;
            }
            if (Config.ConfigHandler.config == null){
            Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "No Text Set, set it with /SetShiftText"));
        }
        if(GuiScreen.isShiftKeyDown()) {
            Minecraft.getMinecraft().fontRendererObj.drawString(Config.ConfigHandler.getString("shiftinfo","shifttxtshift"), Config.ConfigHandler.getInt("shiftinfo", "shiftxposition"), Config.ConfigHandler.getInt("shiftinfo", "shiftyposition"),  Config.ConfigHandler.getInt("shiftinfo", "shiftcolor"), true );
        }
        else if(!GuiScreen.isShiftKeyDown()) {
            Minecraft.getMinecraft().fontRendererObj.drawString(Config.ConfigHandler.getString("shiftinfo","shifttxtnoshift"), Config.ConfigHandler.getInt("shiftinfo", "shiftxposition"), Config.ConfigHandler.getInt("shiftinfo", "shiftyposition"),   Config.ConfigHandler.getInt("shiftinfo", "shiftcolor"), true);
        }
    }
}
