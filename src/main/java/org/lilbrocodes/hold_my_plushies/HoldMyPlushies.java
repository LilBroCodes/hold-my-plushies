package org.lilbrocodes.hold_my_plushies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.impl.resource.loader.ResourceManagerHelperImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HoldMyPlushies implements ModInitializer {
    public static final TagKey<Item> PLUSHIES = TagKey.of(Registries.ITEM.getKey(), identify("plushies"));
    public static final TagKey<Item> HEXED_PLUSHIES = TagKey.of(Registries.ITEM.getKey(), ModImplementation.HEXED.id("plushies"));
    public static final String MOD_ID = "hold_my_plushies";

    @Override
    public void onInitialize() {
        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(container -> ResourceManagerHelperImpl.registerBuiltinResourcePack(
                identify("plushie_pack"),
                "resource_packs/plushie_pack",
                container,
                Text.literal("Hold My Plushies model pack"),
                ResourcePackActivationType.DEFAULT_ENABLED
        ));
    }

    public static Identifier identify(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
