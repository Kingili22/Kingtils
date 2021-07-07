package me.kingili.main;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "forgetemplate", name = "Forge Template", version = "1.0")

public class Main {
    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        // $USER = The username of the currently logged in user.
        // Simply prints out Hello, $USER.
        MinecraftForge.EVENT_BUS.register(new OnTick());
        ClientCommandHandler.instance.registerCommand(new HelpCommand());
        System.out.println("Hello, " + Minecraft.getMinecraft().getSession().getUsername() + "!");
    }
}
