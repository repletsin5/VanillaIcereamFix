package org.dimdev.vanillafix.crashes;

import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.core.LiteLoader;

import java.util.ArrayList;
import java.util.List;

public class Liteloaderhelper {

    public static List<String> getLLmods(){
        List<String> s = new ArrayList<>();

       LiteLoader.getInstance().getLoadedMods().forEach(liteMod -> {
           s.add(liteMod.getName());
       });
       return s;
    }
}
