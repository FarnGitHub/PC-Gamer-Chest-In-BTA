package farn.pcGamerChest.mixin;

import net.minecraft.client.Minecraft;
import farn.pcGamerChest.Main;
import net.minecraft.client.player.controller.PlayerControllerSP;
import net.minecraft.client.player.controller.PlayerController;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;


@Mixin(value = PlayerControllerSP.class, remap = false)
public class PlayerControllerSPMixin extends PlayerController{
    public PlayerControllerSPMixin(Minecraft minecraft) {
        super(minecraft);
    }

    public void changeWorld(World world) {
        super.changeWorld(world);
        if(world.isNewWorld) {
            Main.initChest(world);
        }
    }

}
