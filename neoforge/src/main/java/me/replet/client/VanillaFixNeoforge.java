package me.replet.client;

import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.dimdev.vanillafix.util.config.ModConfig;
@Mod("vanillafix")
public class VanillaFixNeoforge {
    public VanillaFixNeoforge(){
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (mc, parent) -> AutoConfig.getConfigScreen(ModConfig.class,parent).get());
    }

}
