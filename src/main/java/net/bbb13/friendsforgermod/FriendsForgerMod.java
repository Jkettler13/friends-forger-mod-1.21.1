package net.bbb13.friendsforgermod;

import net.bbb13.friendsforgermod.block.ModBlocks;
import net.bbb13.friendsforgermod.client.render.ModElytraFeatureRenderer;
import net.bbb13.friendsforgermod.item.ModItemGroups;
import net.bbb13.friendsforgermod.item.ModItems;
import net.bbb13.friendsforgermod.sound.ModSounds;
import net.bbb13.friendsforgermod.util.ModCustomTrades;
import net.bbb13.friendsforgermod.util.ModLootTableModifiers;
import net.bbb13.friendsforgermod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendsForgerMod implements ModInitializer {
	public static final String MOD_ID = "friendsforgermod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		ModVillagers.registerVillagers();

		ModSounds.registerSounds();

		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, renderer, registrationHelper, context) -> {
			if (entityType == EntityType.PLAYER) {
				registrationHelper.register(
						new ModElytraFeatureRenderer<>(
								renderer,
								context.getModelLoader().getModelPart(EntityModelLayers.ELYTRA)
						)
				);
			}
		});
	}
}
