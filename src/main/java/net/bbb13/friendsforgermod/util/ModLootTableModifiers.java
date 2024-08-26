package net.bbb13.friendsforgermod.util;

import net.bbb13.friendsforgermod.block.ModBlocks;
import net.bbb13.friendsforgermod.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    public static final Identifier CREEPER_ID = Identifier.of("minecraft","entities/creeper");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && CREEPER_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModBlocks.CHEESE_BLOCK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)))
                                .conditionally(RandomChanceLootCondition.builder(1.0f)));

                tableBuilder.pool(poolBuilder);
            }
        });
    }

}
