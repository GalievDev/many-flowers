package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.block.flowers.entity.AutumnAstersEntity;
import net.valion.manyflowers.block.flowers.entity.VelvetsBlockEntity;

public class BlockEntitiesReg {
    public static BlockEntityType<VelvetsBlockEntity> VELVETS_ENTITY;
    public static BlockEntityType<AutumnAstersEntity> AUTUMN_ASTERS_ENTITY;

    public static void register() {
        VELVETS_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ManyFlowers.MOD_ID, "velvets_entity"),
                FabricBlockEntityTypeBuilder.create(VelvetsBlockEntity::new, Flowers.VELVETS).build());
        AUTUMN_ASTERS_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ManyFlowers.MOD_ID, "autumn_asters_entity"),
                FabricBlockEntityTypeBuilder.create(AutumnAstersEntity::new, Flowers.AUTUMN_ASTERS).build());
    }
}
