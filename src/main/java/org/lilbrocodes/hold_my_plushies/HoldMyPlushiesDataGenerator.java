package org.lilbrocodes.hold_my_plushies;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import static org.lilbrocodes.hold_my_plushies.ModImplementation.*;

public class HoldMyPlushiesDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider((o, f) -> new FabricTagProvider.ItemTagProvider(o, f) {
            @Override
            protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
                getOrCreateTagBuilder(HoldMyPlushies.PLUSHIES)
                        .addOptional(COMPOSER_RELOADED.id("plush"))
                        .addOptional(COMPOSER.id("plush"))
                        .addOptional(HUSKY.id("max_plush"))
                        .addOptional(RATATOUILLE.id("folly_plush"))
                        .addOptional(RATATOUILLE.id("rat_maid_plush"))
                        .addOptional(RATATOUILLE.id("mauve_plush"))
                        .addOptionalTag(HEXED.id("plushies"));

                getOrCreateTagBuilder(HoldMyPlushies.HEXED_PLUSHIES)
                        .addOptional(HEXED.id("assistance_plushie"))
                        .addOptional(HEXED.id("bonfire_plushie"))
                        .addOptional(HEXED.id("bread_plushie"))
                        .addOptional(HEXED.id("calamaidas_plushie"))
                        .addOptional(HEXED.id("chronos_plushie"))
                        .addOptional(HEXED.id("crafter_plushie"))
                        .addOptional(HEXED.id("den_plushie"))
                        .addOptional(HEXED.id("eternal_plushie"))
                        .addOptional(HEXED.id("fzzy_plushie"))
                        .addOptional(HEXED.id("gobby_plushie"))
                        .addOptional(HEXED.id("josh_plushie"))
                        .addOptional(HEXED.id("kami_plushie"))
                        .addOptional(HEXED.id("maggie_plushie"))
                        .addOptional(HEXED.id("milkyfur_plushie"))
                        .addOptional(HEXED.id("monk_plushie"))
                        .addOptional(HEXED.id("nightfall_solace_plushie"))
                        .addOptional(HEXED.id("phoenix_plushie"))
                        .addOptional(HEXED.id("reader_plushie"))
                        .addOptional(HEXED.id("silver_plushie"))
                        .addOptional(HEXED.id("solace_plushie"))
                        .addOptional(HEXED.id("tenno_plushie"))
                        .addOptional(HEXED.id("tiger_plushie"))
                        .addOptional(HEXED.id("toboe_plushie"))
                        .addOptional(HEXED.id("tollish_plushie"))
                        .addOptional(HEXED.id("wagon_plushie"))
                        .addOptional(HEXED.id("yirmiri_plushie"))
                        .addOptional(HEXED.id("zarra_plushie"));
            }
        });
    }
}
