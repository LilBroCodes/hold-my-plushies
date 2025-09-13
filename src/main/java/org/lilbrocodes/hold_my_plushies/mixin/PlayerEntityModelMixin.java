package org.lilbrocodes.hold_my_plushies.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import org.lilbrocodes.hold_my_plushies.HoldMyPlushies;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public class PlayerEntityModelMixin<T extends LivingEntity> extends BipedEntityModel<T> {
    @Unique private static final TagKey<Item> PLUSHIES = TagKey.of(Registries.ITEM.getKey(), HoldMyPlushies.identify("plushies"));
    @Shadow @Final public ModelPart leftSleeve;
    @Shadow @Final public ModelPart rightSleeve;

    public PlayerEntityModelMixin(ModelPart root) {
        super(root);
    }

    @Inject(method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at = @At("TAIL"))
    public void setPlushieHand(T livingEntity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo ci) {
        if (holdingPlushie(livingEntity)) {
            float pitch = (float) (-Math.PI / 2f) * 0.8f;

            setupArm(leftArm, leftSleeve, pitch);
            setupArm(rightArm, rightSleeve, pitch);
        }
    }

    @Unique
    private void setupArm(ModelPart arm, ModelPart sleeve, float pitch) {
        arm.pitch = pitch;
        sleeve.pitch = pitch;

        arm.roll = 0;
        sleeve.roll = 0;
    }

    @Unique
    private boolean holdingPlushie(T entity) {
        if (entity.getEquippedStack(EquipmentSlot.MAINHAND).isIn(PLUSHIES)) return true;
        return entity.getEquippedStack(EquipmentSlot.OFFHAND).isIn(PLUSHIES);
    }
}
