package me.kingili.init;

import me.kingili.commands.*;
import me.kingili.config.Config;
import me.kingili.events.ReadMessage;
import me.kingili.render.ShiftRender;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "kingtils", name = "Kingtils", version = "1.0")

public class Main {
    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        // $USER = The username of the currently logged in user.
        // Simply prints out Hello, $USER.
        MinecraftForge.EVENT_BUS.register(new ReadMessage());
        MinecraftForge.EVENT_BUS.register(new ShiftRender());
        ClientCommandHandler.instance.registerCommand(new HelpCommand());
        ClientCommandHandler.instance.registerCommand(new SetShiftXPosition());
        ClientCommandHandler.instance.registerCommand(new SetShiftYPosition());
        ClientCommandHandler.instance.registerCommand(new SetNoShiftText());
        ClientCommandHandler.instance.registerCommand(new SetShiftText());
        ClientCommandHandler.instance.registerCommand(new SetShiftColor());
        System.out.println("Hello, " + Minecraft.getMinecraft().getSession().getUsername() + "!");
    }
}
