package me.shurik.allowsymlinks.mixin;

import java.nio.file.Path;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.util.path.SymlinkEntry;
import net.minecraft.util.path.SymlinkFinder;

@Mixin(SymlinkFinder.class)
public class SymlinkFinderMixin {
    // validate(Path path, List<SymlinkEntry> results)
    @Inject(method = "validate", at = @At("HEAD"), cancellable = true)
    private void validate(Path path, List<SymlinkEntry> results, CallbackInfo info) {
        info.cancel();
    }
}