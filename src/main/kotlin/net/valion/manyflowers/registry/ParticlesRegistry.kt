package net.valion.manyflowers.registry

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes
import net.minecraft.particle.SimpleParticleType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.valion.manyflowers.ManyFlowers.MOD_ID

object ParticlesRegistry {
    val SWEET_ALYSSUM_PARTICLES: SimpleParticleType = FabricParticleTypes.simple()

    init {
        Registry.register(
            Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "sweet_alyssum_particles"),
            SWEET_ALYSSUM_PARTICLES
        )
    }
}