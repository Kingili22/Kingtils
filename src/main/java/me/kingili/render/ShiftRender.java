package me.kingili.render;

import com.sun.jna.platform.win32.Guid;
import me.kingili.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class TextRender {
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
        if(GuiScreen.isShiftKeyDown()) {
            Minecraft.getMinecraft().fontRendererObj.drawString("Shift Held Down", 1, 1, 10);
        }
        else if(!GuiScreen.isShiftKeyDown()) {
            Minecraft.getMinecraft().fontRendererObj.drawString("No Shift", 1, 1,  10);
        }
    }
}
