package net.bbb13.friendsforgermod.util;

import net.bbb13.friendsforgermod.item.ModItems;
import net.bbb13.friendsforgermod.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {

    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HIPSTER, 1 ,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 2),
                            new ItemStack(ModItems.CRE8IVES_DISC,1),
                            6, 5, 0.05f));

                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HIPSTER, 2 ,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 5),
                            new ItemStack(ModItems.CRE8IVES_SKATEBOARD,1),
                            6, 10, 0.05f));

                });
    }
}
