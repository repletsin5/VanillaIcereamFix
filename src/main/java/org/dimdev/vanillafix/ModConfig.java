package org.dimdev.vanillafix;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.minecraftforge.common.config.Config.*;

@Config(modid = "vanillafix", name = "vanillaicecreamfix",category = "")
public final class ModConfig {

    public enum ProblemAction {
        @LangKey("vanillafix.crashes.problemAction.log") LOG,
        @LangKey("vanillafix.crashes.problemAction.notification") NOTIFICATION,
        @LangKey("vanillafix.crashes.problemAction.warningScreen") WARNING_SCREEN,
        @LangKey("vanillafix.crashes.problemAction.crash") CRASH
    }

    public static Fixes fixes = new Fixes();
    public static Crashes crashes = new Crashes();
    //public static Options options = new Options();

    public static class Fixes {
        @Name("bugFixes")
        @LangKey("vanillafix.fixes.bugFixes")
        @RequiresMcRestart
        public boolean bugFixes = true;

        @Name("crashFixes")
        @LangKey("vanillafix.fixes.crashFixes")
        @RequiresMcRestart
        public boolean crashFixes = true;

        @Name("modSupport")
        @LangKey("vanillafix.fixes.modSupport")
        @RequiresMcRestart
        public boolean modSupport = true;

        @Name("profiler")
        @LangKey("vanillafix.fixes.profiler")
        @RequiresMcRestart
        public boolean profiler = true;

        @Name("textureFixes")
        @LangKey("vanillafix.fixes.textureFixes")
        @RequiresMcRestart
        public boolean textureFixes = true;
    }

    public static class Crashes {
        @Name("disableReturnToMainMenu")
        @LangKey("vanillafix.crashes.disableReturnToMainMenu")
        public boolean disableReturnToMainMenu = false;

        @Name("scheduledTaskproblemAction")
        @LangKey("vanillafix.crashes.scheduledTaskproblemAction")
        public ProblemAction scheduledTaskAction = ProblemAction.NOTIFICATION;

        @Name("hasteURL")
        @LangKey("vanillafix.crashes.hasteURL")
        public String hasteURL = "https://api.mclo.gs";

        @Name("replaceErrorNotifications")
        @LangKey("vanillafix.crashes.replaceErrorNotifications")
        public boolean replaceErrorNotifications = false;

        @Name("errorNotificationDuration")
        @LangKey("vanillafix.crashes.errorNotificationDuration")
        public int errorNotificationDuration = 30000;
    }

    /*public static class Options {
        @Name("loginTimeout")
        @LangKey("vanilafix.options.loginTimeout")
        @RangeInt(min = 600)
        public int loginTimeout = 600;
    }*/

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals("vanillafix")) {
            ConfigManager.sync(event.getModID(), Type.INSTANCE);
        }
    }
}