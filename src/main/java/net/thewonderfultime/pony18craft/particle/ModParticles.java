package net.thewonderfultime.pony18craft.particle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final ParticleType<DefaultParticleType> PEE_PARTICLE = Registry.register(
            Registries.PARTICLE_TYPE,
            new Identifier("pony18craft", "pee_particle"),
            FabricParticleTypes.simple(false)
    );

    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(PEE_PARTICLE, PeeParticle.Factory::new);
    }
}