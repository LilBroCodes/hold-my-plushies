package org.lilbrocodes.hold_my_plushies;

import net.minecraft.util.Identifier;

public enum ModImplementation {
    COMPOSER_RELOADED("composer_reloaded"),
    MINECRAFT("minecraft"),
    COMPOSER("composer"),
    HEXED("hexed"),
    HUSKY("husky"),
    RATATOUILLE("ratatouille");

    private final String id;
    ModImplementation(String modId) {
        this.id = modId;
    }

    public Identifier id(String path) {
        return Identifier.of(id, path);
    }
}