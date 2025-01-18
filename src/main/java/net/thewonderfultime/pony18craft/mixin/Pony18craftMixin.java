package net.thewonderfultime.pony18craft.mixin;

import net.thewonderfultime.pony18craft.Pony18craft;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class Pony18craftMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		Pony18craft.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
