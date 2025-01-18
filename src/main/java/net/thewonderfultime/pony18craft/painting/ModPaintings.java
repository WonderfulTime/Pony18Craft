package net.thewonderfultime.pony18craft.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;

public class ModPaintings {

    public static final PaintingVariant NIGHT_PONY_MOON_PAINT = registerPainting("night_pony_moon_paint",
            new PaintingVariant(64, 64));

    public static final PaintingVariant KINDER_BUENO_PAINT = registerPainting("kinder_bueno_paint",
            new PaintingVariant(16, 32));

    public static final PaintingVariant RKN_PONY_PAINT = registerPainting("rkn_pony_paint",
            new PaintingVariant(32, 32));

    public static final PaintingVariant BEBS_PAINT = registerPainting("bebs_paint",
            new PaintingVariant(16, 16));


    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(Pony18craft.MOD_ID, name), paintingVariant);
    }








    public static void registerPaintings(){
        Pony18craft.LOGGER.debug("Registering paintings for: " + Pony18craft.MOD_ID);
    }
}
