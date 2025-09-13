package org.lilbrocodes.hold_my_plushies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.impl.resource.loader.ResourceManagerHelperImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HoldMyPlushies implements ModInitializer {
    public static final String MOD_ID = "hold_my_plushies";

    @Override
    public void onInitialize() {
        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(container -> {
            ResourceManagerHelperImpl.registerBuiltinResourcePack(
                    identify("plushie_pack"),
                    "resource_packs/plushie_pack",
                    container,
                    Text.literal("Hold My Plushies model pack"),
                    ResourcePackActivationType.DEFAULT_ENABLED
            );
        });
    }

    public static Identifier identify(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
