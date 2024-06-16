package org.dimdev.vanillafix.modsupport.mixins;


import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import zone.rong.loliasm.client.LoliIncompatibilityHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Mixin(value = zone.rong.loliasm.proxy.CommonProxy.class, remap = false)
public class LoliASMloadPatch {
    /**
     * @author replet
     * @reason allows this mod to load with loliasm/censoredasm loaded
     */
    @Overwrite()
    public void throwIncompatibility() {
        boolean texFix = Loader.isModLoaded("texfix");
        if (texFix) {
            List<String> messages = new ArrayList<>();
            messages.add("LoliASM has replaced and improved upon functionalities from the following mods.");
            messages.add("Therefore, these mods are now incompatible with LoliASM:");
            messages.add("");
            if (texFix) {
                messages.add(TextFormatting.BOLD + "TexFix");
            }
            LoliIncompatibilityHandler.loliHaetPizza(messages);
        }
    }
}
