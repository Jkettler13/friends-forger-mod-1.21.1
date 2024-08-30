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

    public static final Identifier SPIDER_ID = Identifier.of("minecraft", "entities/spider");

    public static final Identifier WOODLAND_MANSION_ID = Identifier.of("minecraft", "chests/woodland_mansion");

    public static final Identifier END_CITY_TREASURE_CHEST_ID = Identifier.of("minecraft","chests/end_city_treasure");

    public static final Identifier ANCIENT_CITY_CHEST_ID = Identifier.of("minecraft","chests/ancient_city");

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

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && SPIDER_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.SILK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)))
                                .conditionally(RandomChanceLootCondition.builder(1.0f)));

                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && WOODLAND_MANSION_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)))
                                .conditionally(RandomChanceLootCondition.builder(0.25f)));

                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && ANCIENT_CITY_CHEST_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)))
                                .conditionally(RandomChanceLootCondition.builder(0.1f)));

                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && END_CITY_TREASURE_CHEST_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.SLADERS_CONTROLLER)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .conditionally(RandomChanceLootCondition.builder(0.1f)));

                tableBuilder.pool(poolBuilder);
            }
        });

    }

}
