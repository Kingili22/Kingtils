package me.kingili.init;

import me.kingili.commands.*;
import me.kingili.events.ReadMessage;
import me.kingili.render.ShiftRender;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "kingtils", name = "Kingtils", version = "1.0", clientSideOnly = true)

public class Main {
    @Mod.EventHandler
    public void preFMLInitialization(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new HelpCommand());
        ClientCommandHandler.instance.registerCommand(new SetShiftXPosition());
        ClientCommandHandler.instance.registerCommand(new SetShiftYPosition());
        ClientCommandHandler.instance.registerCommand(new SetNoShiftText());
        ClientCommandHandler.instance.registerCommand(new SetShiftText());
        ClientCommandHandler.instance.registerCommand(new SetShiftColor());
        MinecraftForge.EVENT_BUS.register(new ShiftRender());
    }
    public void onFMLInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ReadMessage());
        System.out.println("Hello, " + Minecraft.getMinecraft().getSession().getUsername() + "!");
    }
}
