package org.dimdev.vanillafix.crashes;

import net.minecraftforge.fml.common.ModContainer;

import java.util.List;
import java.util.Set;

public interface IPatchedCrashReport {
    Set<ModContainer> getSuspectedMods();
    List<String> getSuspectedModsLL();
}
